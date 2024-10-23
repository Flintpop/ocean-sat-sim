//// src/app/controller/SatelliteController.java
//package app.controller;
//
//import app.model.Satellite;
//import app.view.SatelliteView;
//
//import java.util.Timer;
//import java.util.TimerTask;
//
///**
// * Contrôleur pour le satellite.
// */
//public class SatelliteController {
//  private final Satellite model;
//  private final SatelliteView view;
//  private final Timer timer;
//
//  /**
//   * Constructeur du contrôleur de satellite.
//   *
//   * @param model Modèle du satellite.
//   * @param view  Vue du satellite.
//   */
//  public SatelliteController(Satellite model, SatelliteView view) {
//    this.model = model;
//    this.view = view;
//    this.timer = new Timer();
//  }
//
//  /**
//   * Démarre le mouvement du satellite.
//   */
//  public void start() {
//    timer.scheduleAtFixedRate(new TimerTask() {
//      @Override
//      public void run() {
//        moveSatellite();
//      }
//    }, 0, 1000); // Mise à jour toutes les secondes, ajustez selon vos besoins
//  }
//
//  /**
//   * Arrête le mouvement du satellite.
//   */
//  public void stop() {
//    timer.cancel();
//  }
//
//  /**
//   * Logique de déplacement du satellite.
//   */
//  private void moveSatellite() {
//    int currentPosition = model.getPosition();
//    int speed = model.getSpeed();
//    int newPosition = currentPosition + speed;
//
//    // Logique de déplacement, par exemple, boucle autour de la fenêtre
//    // Vous pouvez ajuster les limites en fonction de la largeur de la fenêtre
//    if (newPosition > 800) { // Supposons que la largeur de la fenêtre est 800
//      newPosition = 0;
//    }
//
//    model.setPosition(newPosition);
//  }
//
//  /**
//   * Démarre la synchronisation avec les balises.
//   */
//  public void startSynchronization() {
//    model.startSynchronization();
//  }
//}
