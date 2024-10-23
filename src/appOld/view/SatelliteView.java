//// src/app/view/SatelliteView.java
//package app.view;
//
//import app.model.SatelliteModel;
//import app.observer.Observer;
//import app.MovableEllipse;
//import nicellipse.component.NiSpace;
//
//import java.awt.*;
//
///**
// * Vue représentant un satellite graphiquement.
// */
//public class SatelliteView extends MovableEllipse implements Observer {
//  private final SatelliteModel model;
//
//  /**
//   * Constructeur de la vue du satellite.
//   *
//   * @param fenetre Fenêtre graphique où le satellite sera affiché.
//   * @param model   Modèle du satellite à observer.
//   * @param speed   Vitesse de déplacement graphique.
//   */
//  public SatelliteView(NiSpace fenetre, SatelliteModel model, int speed) {
//    super(fenetre, (int) model.getHauteur(), model.getPosition(), speed);
//    this.model = model;
//    this.setBackground(Color.GRAY);
//    this.setSize(20, 20);
//    this.model.addObserver(this);
//  }
//
//  /**
//   * Mise à jour de la vue en réponse aux changements du modèle.
//   *
//   * @param event Type d'événement.
//   */
//  @Override
//  public void update(String event) {
//    switch (event) {
//      case "position":
//        this.setMovableObjectLocation(new Point(model.getPosition(), (int) model.getHauteur()));
//        break;
//      case "hauteur":
//        this.setBackground(Color.BLUE);
//        break;
//      case "speed":
//        this.speed = model.getSpeed();
//        break;
//      case "SYNCHRONIZING":
//        this.setBackground(Color.RED);
//        break;
//    }
//  }
//}
