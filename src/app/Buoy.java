package app;

import nicellipse.component.NiSpace;
import nicellipse.component.NiEllipse;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static app.constants.SEA_LEVEL;

public class Buoy extends MovableObject implements Observer {
  public MovementStrategy movementStrategy;
  private BuoyState state;
  private boolean isSynchronizing = false; // Variable pour vérifier la synchronisation
  private long syncStartTime = 0; // Temps de début de la synchronisation
  private long collectStartTime = 0; // Temps de début de la collecte
  private int syncStep = 0;  // Variable pour gérer les étapes de synchronisation

  private boolean syncRequested = false; // Indicateur pour une synchro en attente
  private List<NiEllipse> circles = new ArrayList<>(); // Liste pour stocker les cercles

  private Satellite satellite;  // Référence au satellite pour obtenir sa position

  public enum BuoyState {
    COLLECTING,
    SURFACING,
    WAITING_FOR_SYNC,
    SYNCHRONIZING,
    DIVING
  }

  public Buoy(NiSpace fenetre, int altitude, int startingPosition, int speed, Satellite satellite) {
    super(fenetre, altitude + SEA_LEVEL, startingPosition, speed);
    if (altitude < 0) {
      throw new IllegalArgumentException("Buoy altitude must be positive");
    }
    if (startingPosition < 0) {
      throw new IllegalArgumentException("Buoy starting position must be positive");
    }
    this.satellite = satellite;  // Assigner le satellite
    this.setBackground(Color.yellow);
    this.setSize(15, 15);
    this.state = BuoyState.COLLECTING;
    this.movementStrategy = new VerticalMovement(50); // Default strategy

    if (altitude > SEA_LEVEL - this.getHeight()) {
      throw new IllegalArgumentException("Buoy altitude must be less than sea level");
    }

    this.collectStartTime = System.currentTimeMillis(); // Démarrer le temps de collecte
  }

  @Override
  public void move() {
    long currentTime = System.currentTimeMillis();

    switch (state) {
      case COLLECTING:
        // La bouée collecte pendant 5 secondes, puis passe en mode SURFACING
        if (currentTime - collectStartTime >= 5000) {
          state = BuoyState.SURFACING;
        } else {
          movementStrategy.move(this);  // Continuer à bouger pendant la collecte
        }
        break;

      case SURFACING:
        surfaceMovement();
        break;

      case WAITING_FOR_SYNC:
        // La bouée attend qu'un satellite soit au même X qu'elle
        if (Math.abs(satellite.getX() - loc.x) < 20) {  // Si proche du satellite en X
          startSynchronization();  // Commencer la synchronisation
        }
        break;

      case SYNCHRONIZING:
        // Gérer la synchronisation avec les cercles
        if (isSynchronizing) {
          if (currentTime - syncStartTime >= 1000) {
            // Après 1 seconde, arrêter la synchronisation et redescendre
            isSynchronizing = false;
            removeCircles();
            state = BuoyState.DIVING;  // Passer en mode DIVING
          } else {
            int syncStepDuration = 250; // Chaque étape dure 250ms
            syncStep = (int) ((currentTime - syncStartTime) / syncStepDuration);
            addCircle(loc.x, loc.y, syncStep * 70); // Ajouter un nouveau cercle
          }
        }
        break;

      case DIVING:
        // La bouée redescend à son altitude d'origine
        diveMovement();
        break;
    }
  }

  @Override
  public void update(String event) {
    if ("SYNCHRONIZING".equals(event)) {
      // Si la synchronisation est demandée, vérifier la position du satellite
      if (state == BuoyState.WAITING_FOR_SYNC && Math.abs(satellite.getX() - loc.x) < 20) {
        startSynchronization(); // Si déjà à la surface et proche du satellite
      }
    }
  }

  private void surfaceMovement() {
    // Déplacer la bouée vers le haut jusqu'à ce qu'elle atteigne la surface
    if (getLocation().y > 200) {
      Point locTranslate = this.getLocation();
      locTranslate.translate(0, -Math.abs(speed));
      this.setMovableObjectLocation(locTranslate);
      this.loc = locTranslate;
    } else {
      state = BuoyState.WAITING_FOR_SYNC;  // Une fois à la surface, attendre la synchro
    }
  }

  private void diveMovement() {
    // Redescendre la bouée à son altitude initiale
    if (getLocation().y < this.altitude) {
      Point locTranslate = this.getLocation();
      locTranslate.translate(0, Math.abs(speed));  // Bouger vers le bas
      this.setMovableObjectLocation(locTranslate);
      this.loc = locTranslate;
    } else {
      state = BuoyState.COLLECTING;  // Revenir en mode collecte
      collectStartTime = System.currentTimeMillis();  // Redémarrer le timer de collecte
    }
  }

  private void startSynchronization() {
    syncStep = 0;
    isSynchronizing = true;  // Marquer l'état de synchronisation
    syncStartTime = System.currentTimeMillis();  // Enregistrer le temps de départ
    state = BuoyState.SYNCHRONIZING;  // Passer en mode SYNCHRONIZING
  }

  // Méthode pour ajouter un cercle (NiEllipse) à la fenêtre
  private void addCircle(int x, int y, int radius) {
    NiEllipse circle = new NiEllipse();
    circle.setSize(radius, radius);
    circle.setLocation(x - radius / 2, y - radius / 2);  // Centrer le cercle autour de la bouée
    circle.setBorderColor(Color.red);  // Couleur de la bordure du cercle
    circle.setStrokeWidth(2);
    circle.setWithBorder(true);
    circle.setBackground(new Color(0, 0, 0, 0));  // Cercle transparent à l'intérieur
    fenetre.add(circle);
    fenetre.repaint();
    circles.add(circle);  // Ajouter le cercle à la liste pour suppression ultérieure
  }

  // Méthode pour supprimer tous les cercles
  private void removeCircles() {
    for (NiEllipse circle : circles) {
      fenetre.remove(circle);  // Retirer chaque cercle de la fenêtre
    }
    fenetre.repaint();  // Redessiner la fenêtre pour effacer les cercles
    circles.clear();  // Vider la liste des cercles
  }
}
