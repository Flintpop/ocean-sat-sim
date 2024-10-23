package appOld;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import appOld.factory.SatelliteFactory;
import appOld.model.Satellite;
import nicellipse.component.NiRectangle;
import nicellipse.component.NiSpace;

import static appOld.Constants.SEA_LEVEL;

public class Ocean {
  NiSpace fenetre = new NiSpace("Exercice 1", new Dimension(400, 400));
//  Satellite satelliteModel = new Satellite(fenetre, 50, 1);
  Satellite satelliteModel = SatelliteFactory.createSatellite();
  Satellite satelliteModel2 = new Satellite(fenetre, 20, 160, 0);
//  Buoy buoyVertical = new Buoy(fenetre, 185, 90, 1);
//  BuoyModel buoyModelHorizontal = new BuoyModel(fenetre, 120, 150, 1, satelliteModel);
//  Buoy buoySinusoidal = new Buoy(fenetre, 160, 15, 1);
  NiRectangle ciel = new NiRectangle();

  public Ocean() {
    fenetre.setBackground(Color.blue);
    ciel.setBackground(Color.white);
    ciel.setSize(400, SEA_LEVEL);

//    buoyModelHorizontal.movementStrategy = new HorizontalMovement(200);
//    buoySinusoidal.movementStrategy = new SinusoidalMovement(50);

    // Ajouter les bouées comme observateurs des satellites
//    satellite.addObserver(buoyVertical);
//    satelliteModel.addObserver(buoyModelHorizontal);
//    satellite2.addObserver(buoySinusoidal);

    fenetre.add(ciel);
    fenetre.openInWindow();

    // Animation de base avec mouvement continu
    int delay = 1; // milliseconds
    ActionListener taskPerformer = evt -> {
      satelliteModel.move();
      satelliteModel2.move();
//      buoyVertical.move();
//      buoyModelHorizontal.move();
//      buoySinusoidal.move();
    };
    Timer animation = new Timer(delay, taskPerformer);
    animation.setRepeats(true);
    animation.start();

    // Synchronisation toutes les 5 secondes
    Timer synchronizationTimer = new Timer(5000, evt -> {
      satelliteModel.startSynchronization();
      satelliteModel2.startSynchronization();
    });
    synchronizationTimer.setRepeats(true);
    synchronizationTimer.start();
  }

  public static void main(String[] args) {
    new Ocean();
  }
}
