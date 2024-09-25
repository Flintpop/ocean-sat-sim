package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import nicellipse.component.NiRectangle;
import nicellipse.component.NiSpace;

import static app.constants.SEA_LEVEL;

public class Ocean {
  NiSpace fenetre = new NiSpace("Exercice 1", new Dimension(400, 400));
  Satellite satellite = new Satellite(fenetre, 50, 1);
  Satellite satellite2 = new Satellite(fenetre, 20, 160, 0);
//  Buoy buoyVertical = new Buoy(fenetre, 185, 90, 1);
  Buoy buoyHorizontal = new Buoy(fenetre, 120, 150, 1, satellite);
//  Buoy buoySinusoidal = new Buoy(fenetre, 160, 15, 1);
  NiRectangle ciel = new NiRectangle();

  public Ocean() {
    fenetre.setBackground(Color.blue);
    ciel.setBackground(Color.white);
    ciel.setSize(400, SEA_LEVEL);

    buoyHorizontal.movementStrategy = new HorizontalMovement(200);
//    buoySinusoidal.movementStrategy = new SinusoidalMovement(50);

    // Ajouter les bouées comme observateurs des satellites
//    satellite.addObserver(buoyVertical);
    satellite.addObserver(buoyHorizontal);
//    satellite2.addObserver(buoySinusoidal);

    fenetre.add(ciel);
    fenetre.openInWindow();

    // Animation de base avec mouvement continu
    int delay = 1; // milliseconds
    ActionListener taskPerformer = evt -> {
      satellite.move();
      satellite2.move();
//      buoyVertical.move();
      buoyHorizontal.move();
//      buoySinusoidal.move();
    };
    Timer animation = new Timer(delay, taskPerformer);
    animation.setRepeats(true);
    animation.start();

    // Synchronisation toutes les 5 secondes
    Timer synchronizationTimer = new Timer(5000, evt -> {
      satellite.startSynchronization();
      satellite2.startSynchronization();
    });
    synchronizationTimer.setRepeats(true);
    synchronizationTimer.start();
  }

  public static void main(String[] args) {
    new Ocean();
  }
}
