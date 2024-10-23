// src/app/factory/ElementFactory.java
package app.factory;

import app.controller.SatelliteController;
import app.model.SatelliteModel;
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
  public static SatelliteController createSatellite(double speed, int x, int y) {
    SatelliteModel satelliteModel = new SatelliteModel(new Point(x, y), speed);
    SatelliteView satelliteView = new SatelliteView(satelliteModel);

    SatelliteController satelliteController = new SatelliteController(satelliteModel, satelliteView);
    satelliteView.setController(satelliteController);
    return satelliteController;
  }

  public static SatelliteController createGeostationnarySatellite(int x, int y) {
    return createSatellite(0, x, y);
  }
}
