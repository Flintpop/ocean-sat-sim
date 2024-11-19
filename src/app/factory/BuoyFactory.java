// src/app/factory/ElementFactory.java
package app.factory;

import app.announcer.Announcer;
import app.model.BuoyModel;
import app.controller.BuoyController;
import app.model.WindowModel;
import app.state.buoy.RecordingState;
import app.strategy.buoy.MovementStrategy;
import app.view.BuoyView;

import java.awt.*;

/**
 * Fabrique pour créer des éléments de la simulation.
 */
public class BuoyFactory {

  /**
   * Crée un satellite avec les paramètres spécifiés.
   */
  public static BuoyController createBuoy(double speed, int x, int y, WindowModel windowModel, MovementStrategy movementStrategy) {
    Announcer movementAnnouncer = new Announcer();
    BuoyModel buoyModel = new BuoyModel(new Point(x, y), speed, windowModel, movementStrategy, movementAnnouncer);
    buoyModel.setState(new RecordingState());
    try {
      BuoyView buoyView = new BuoyView(movementAnnouncer, buoyModel.getWidth(), buoyModel.getHeight(), buoyModel.getPos());
      BuoyController buoyController = new BuoyController(buoyModel, buoyView);
      buoyView.setController(buoyController);
      return buoyController;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  public static BuoyController createBuoy(int id, int x, int y, WindowModel window, MovementStrategy movementStrategy, Announcer announcer) {
    BuoyModel model = new BuoyModel(new Point(x, y), 10.0, window, movementStrategy, announcer);
    BuoyView view = new BuoyView(announcer, 20, 20, new Point(x, y));
    return new BuoyController(model, view);
  }
}
