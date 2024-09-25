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
  private int syncStep = 0;  // Variable pour gérer les étapes de synchronisation

  private boolean syncRequested = false; // Indicateur pour une synchro en attente
  private List<NiEllipse> circles = new ArrayList<>(); // Liste pour stocker les cercles

  public enum BuoyState {
    COLLECTING,
    SURFACING,
    SYNCHRONIZING
  }

  public Buoy(NiSpace fenetre, int altitude, int startingPosition, int speed) {
    super(fenetre, altitude + SEA_LEVEL, startingPosition, speed);
    if (altitude < 0) {
      throw new IllegalArgumentException("Buoy altitude must be positive");
    }
    if (startingPosition < 0) {
      throw new IllegalArgumentException("Buoy starting position must be positive");
    }
    this.setBackground(Color.yellow);
    this.setSize(15, 15);
    this.state = BuoyState.COLLECTING;
    this.movementStrategy = new VerticalMovement(50); // Default strategy

    if (altitude > SEA_LEVEL - this.getHeight()) {
      throw new IllegalArgumentException("Buoy altitude must be less than sea level");
    }
  }

  @Override
  public void move() {
    // Vérification de l'état de synchronisation
    if (isSynchronizing) {
      // On gère les cercles d'onde pendant la synchronisation
      long currentTime = System.currentTimeMillis();
      if (currentTime - syncStartTime >= 1000) {
        // Après 1 seconde, on arrête la synchronisation et on supprime les cercles
        isSynchronizing = false;
        removeCircles();  // Effacer les cercles
        state = BuoyState.COLLECTING;
      } else {
        // On crée et affiche les cercles
        int syncStepDuration = 250; // Chaque étape dure 250ms
        syncStep = (int) ((currentTime - syncStartTime) / syncStepDuration);
        addCircle(loc.x, loc.y, syncStep * 70); // Ajouter un nouveau cercle
      }
      return;
    }

    // Sinon, continuer avec les mouvements normaux
    switch (state) {
      case COLLECTING:
        movementStrategy.move(this);
        break;
      case SURFACING:
        surfaceMovement();
        break;
      case SYNCHRONIZING:
        // Ne rien faire, on gère la synchro via le timer
        break;
    }
  }

  @Override
  public void update(String event) {
    if ("SYNCHRONIZING".equals(event)) {
      // Si une synchronisation est demandée, vérifier si la bouée est déjà à la surface
      if (state == BuoyState.SURFACING || loc.y > 200) {
        // Si la bouée est en train de remonter ou n'est pas encore à la surface
        syncRequested = true; // Marquer que la synchronisation est demandée après surface
        state = BuoyState.SURFACING;
      } else {
        // Si elle est déjà à la surface, commencer la synchronisation
        startSynchronization();
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
      // Une fois à la surface, vérifier si une synchronisation est demandée
      if (syncRequested) {
        syncRequested = false; // Réinitialiser l'indicateur de synchronisation
        startSynchronization();
      } else {
        state = BuoyState.COLLECTING; // Revenir à l'état de collecte si pas de synchronisation
      }
    }
  }

  private void startSynchronization() {
    syncStep = 0;
    isSynchronizing = true;  // Marquer l'état de synchronisation
    syncStartTime = System.currentTimeMillis();  // Enregistrer le temps de départ
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
