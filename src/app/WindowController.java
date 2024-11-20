package app;

import app.announcer.Announcer;
import app.controller.BuoyController;
import app.controller.SatelliteController;
import app.factory.BuoyFactory;
import app.factory.SatelliteFactory;
import app.model.SatelliteModel;
import app.model.WindowModel;
import app.strategy.buoy.HorizontalMovement;
import app.strategy.buoy.SinusoidalMovement;
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
  SatelliteController satelliteController = SatelliteFactory.createSatellite(2, 40, 240, windowModel);
  SatelliteController satelliteController2 = SatelliteFactory.createSatellite(3, 40, 250, windowModel);
  BuoyController buoyController = BuoyFactory.createBuoy(1, 200, this.getWindowModel().getSeaLevel() + 100,
    windowModel, new VerticalMovement(50));
  BuoyController buoyController2 = BuoyFactory.createBuoy(1, 250, this.getWindowModel().getSeaLevel() + 100,
    windowModel, new SinusoidalMovement(50));
  BuoyController buoyController3 = BuoyFactory.createBuoy(1, 250, this.getWindowModel().getSeaLevel() + 100,
    windowModel, new HorizontalMovement(50));

  public WindowController() {
    windowModel.getSatellites().add(satelliteController.getSatelliteModel());
    windowModel.getSatellites().add(satelliteController2.getSatelliteModel());
    windowView.addToWindow(satelliteController.getSatelliteView());
    windowView.addToWindow(satelliteController2.getSatelliteView());
    windowView.addToWindow(buoyController.getBuoyView());
    windowView.addToWindow(buoyController2.getBuoyView());
    windowView.addToWindow(buoyController3.getBuoyView());
    windowView.addToWindow(windowView.getSky());

    Timer timer = new Timer(10, e ->  {
      buoyController.update();
      buoyController2.update();
      buoyController3.update();
      satelliteController.move();
      satelliteController2.move();
    });
    timer.start();
    windowView.openInWindow();
  }

  public static void main(String[] args) {
    new WindowController();
  }
}
