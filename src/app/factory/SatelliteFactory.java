// src/app/factory/ElementFactory.java
package app.factory;

import app.announcer.Announcer;
import app.controller.SatelliteController;
import app.model.SatelliteModel;
import app.model.WindowModel;
import app.state.satellite.MovingState;
import app.strategy.buoy.MovementStrategy;
import app.strategy.satellite.LeftToRightMovement;
import app.view.SatelliteView;

import java.awt.*;

/**
 * Fabrique pour créer des éléments de la simulation.
 */
public class SatelliteFactory {

  /**
   * Crée un satellite avec les paramètres spécifiés.
   */
  public static SatelliteController createSatellite(double speed, int x, int y, WindowModel windowModel) {
    Announcer movementAnnouncer = new Announcer();
    SatelliteModel satelliteModel = new SatelliteModel(1, new Point(x, y), speed, windowModel,
      new LeftToRightMovement(), movementAnnouncer);
    satelliteModel.setState(new MovingState());
    SatelliteView satelliteView = new SatelliteView(movementAnnouncer, satelliteModel);

    SatelliteController satelliteController = new SatelliteController(satelliteModel, satelliteView, movementAnnouncer);
    satelliteView.setController(satelliteController);
    return satelliteController;
  }

  public static SatelliteController createSatellite(int id, int x, int y, WindowModel window, MovementStrategy movementStrategy, Announcer announcer) {
    SatelliteModel model = new SatelliteModel(id, new Point(x, y), 1.0, window, movementStrategy, announcer);
    SatelliteView view = new SatelliteView(model);
    return new SatelliteController(model, view, announcer);
  }

  public static SatelliteController createGeostationnarySatellite(int x, int y, WindowModel windowModel) {
    return createSatellite(0, x, y, windowModel);
  }
}
