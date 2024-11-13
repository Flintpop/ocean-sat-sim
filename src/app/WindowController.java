package app;

import app.announcer.Announcer;
import app.controller.BuoyController;
import app.controller.SatelliteController;
import app.factory.BuoyFactory;
import app.factory.SatelliteFactory;
import app.model.WindowModel;
import app.strategy.buoy.VerticalMovement;
import app.view.WindowView;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

import static app.Constants.WINDOW_HEIGHT;
import static app.Constants.WINDOW_WIDTH;

/**
 * Contrôleur de la fenêtre principale de l'application.
 */
@Getter
@Setter
public class WindowController {
  WindowModel windowModel = new WindowModel(WINDOW_WIDTH, WINDOW_HEIGHT);
  WindowView windowView = new WindowView(this);
  SatelliteController satelliteController = SatelliteFactory.createSatellite(5, 40, 240);
//  SatelliteController satelliteController2 = SatelliteFactory.createSatellite(5, 40, 240);
  BuoyController buoyController = BuoyFactory.createBuoy(1, 200, this.getWindowModel().getSeaLevel() + 100, windowModel, new VerticalMovement(50));

  public WindowController() {
    windowView.addToWindow(satelliteController.getSatelliteView());
//    windowView.addToWindow(satelliteController2.getSatelliteView());
    windowView.addToWindow(buoyController.getBuoyView());
    windowView.addToWindow(windowView.getSky());

    Timer timer = new Timer(10, e -> buoyController.move());
    timer.start();
    windowView.openInWindow();
  }

  public static void main(String[] args) {
    new WindowController();
  }
}
