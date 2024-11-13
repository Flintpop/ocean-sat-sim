package app;

import app.controller.BuoyController;
import app.controller.SatelliteController;
import app.factory.BuoyFactory;
import app.factory.SatelliteFactory;
import app.model.WindowModel;
import app.strategy.buoy.VerticalMovement;
import app.view.WindowView;

import javax.swing.*;

import static app.Constants.WINDOW_HEIGHT;
import static app.Constants.WINDOW_WIDTH;

/**
 * Contrôleur de la fenêtre principale de l'application.
 */
public class WindowController {
  WindowView windowView = new WindowView();
  WindowModel windowModel = new WindowModel(WINDOW_WIDTH, WINDOW_HEIGHT);
  SatelliteController satelliteController = SatelliteFactory.createSatellite(5, 40, 240);
  BuoyController buoyController = BuoyFactory.createBuoy(1, 200, 300, windowModel, new VerticalMovement(50));

  public WindowController() {
    windowView.addToWindow(satelliteController.getSatelliteView());
    windowView.addToWindow(buoyController.getBuoyView());
    windowView.addToWindow(windowView.getSky());

    Timer timer = new Timer(10, e -> {
      buoyController.move();
    });
    timer.start();
    windowView.openInWindow();
  }

  public static void main(String[] args) {
    new WindowController();
  }
}
