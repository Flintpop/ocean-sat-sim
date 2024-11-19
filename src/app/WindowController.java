package app;

import app.announcer.Announcer;
import app.controller.BuoyController;
import app.controller.SatelliteController;
import app.factory.BuoyFactory;
import app.factory.SatelliteFactory;
import app.model.WindowModel;
import app.strategy.buoy.HorizontalMovement;
import app.strategy.buoy.SinusoidalMovement;
import app.strategy.buoy.VerticalMovement;
import app.view.WindowView;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

import static app.Constants.WINDOW_HEIGHT;
import static app.Constants.WINDOW_WIDTH;

/**
 * Contrôleur de la fenêtre principale de l'application.
 */
@Getter
@Setter
public class WindowController {
  private final WindowView windowView;
  private final Announcer announcer = new Announcer(); // Announcer central
  private final WindowModel windowModel = new WindowModel(WINDOW_WIDTH, WINDOW_HEIGHT, announcer);

  // Création des satellites avec le Announcer central
  private final SatelliteController satelliteController = SatelliteFactory.createSatellite(
          1,
          40,
          240,
          windowModel,
          new VerticalMovement(50),
          announcer
  );

  // Création des bouées avec le Announcer central
  private final BuoyController buoyController = BuoyFactory.createBuoy(
          1,
          200,
          Constants.SEA_LEVEL + 100,
          windowModel,
          new VerticalMovement(50),
          announcer
  );
  private final BuoyController buoyController2 = BuoyFactory.createBuoy(
          2,
          250,
          Constants.SEA_LEVEL + 100,
          windowModel,
          new SinusoidalMovement(50),
          announcer
  );
  private final BuoyController buoyController3 = BuoyFactory.createBuoy(
          3,
          300,
          Constants.SEA_LEVEL + 100,
          windowModel,
          new HorizontalMovement(50),
          announcer
  );

  public WindowController() {
    // Ajout des vues à la fenêtre
    this.windowView = new WindowView(this);
    windowView.addToWindow(satelliteController.getSatelliteView());
    windowView.addToWindow(buoyController.getBuoyView());
    windowView.addToWindow(buoyController2.getBuoyView());
    windowView.addToWindow(buoyController3.getBuoyView());
    windowView.addToWindow(windowView.getSky());
    windowModel.addSatellite(satelliteController.getSatelliteModel());

    // Boucle principale de la simulation
    Timer timer = new Timer(100, e -> { // Intervalle de 100 ms
      buoyController.update();
      buoyController2.update();
      buoyController3.update();
      satelliteController.move();
    });
    timer.start();
    windowView.openInWindow();
  }

  public static void main(String[] args) {
    new WindowController();
  }
}
