// src/app/factory/ElementFactory.java
package app.factory;

import app.model.BuoyModel;
import app.controller.BuoyController;
import app.view.BuoyView;

import javax.swing.*;
import java.awt.*;

/**
 * Fabrique pour créer des éléments de la simulation.
 */
public class BuoyFactory {

  /**
   * Crée un satellite avec les paramètres spécifiés.
   */
  public static BuoyController createBuoy(double speed, int x, int y) {
    BuoyModel buoyModel = new BuoyModel(new Point(x, y), speed);
    try {
      BuoyView buoyView = new BuoyView(buoyModel);
      BuoyController buoyController = new BuoyController(buoyModel, buoyView);
      buoyView.setController(buoyController);
      return buoyController;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
