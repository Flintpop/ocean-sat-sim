// src/app/factory/ElementFactory.java
package app.factory;

import app.announcer.Announcer;
import app.controller.SatelliteController;
import app.model.SatelliteModel;
import app.model.WindowModel;
import app.state.satellite.MovingState;
import app.strategy.satellite.LeftToRightMovementStrategy;
import app.view.SatelliteView;

import javax.swing.text.Position;
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
    SatelliteModel satelliteModel = new SatelliteModel(new Point(x, y), speed, windowModel,
      new LeftToRightMovementStrategy(), movementAnnouncer);
    satelliteModel.setState(new MovingState());
    SatelliteView satelliteView = new SatelliteView(movementAnnouncer, satelliteModel);

    SatelliteController satelliteController = new SatelliteController(satelliteModel, satelliteView);
    satelliteView.setController(satelliteController);
    return satelliteController;
  }

  public static SatelliteController createGeostationnarySatellite(int x, int y, WindowModel windowModel) {
    return createSatellite(0, x, y, windowModel);
  }
}
