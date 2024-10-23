package app;

import app.controller.BuoyController;
import app.controller.SatelliteController;
import app.factory.BuoyFactory;
import app.factory.SatelliteFactory;
import nicellipse.component.NiRectangle;
import nicellipse.component.NiSpace;

import javax.swing.*;
import java.awt.*;

import static app.Constants.SEA_LEVEL;
import static app.Constants.WINDOW_WIDTH;

public class GameController {
  NiSpace fenetre = new NiSpace("Ocean-sat-sim", new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
  SatelliteController satelliteController = SatelliteFactory.createSatellite(5, 40, 40);
  BuoyController buoyController = BuoyFactory.createBuoy(1, 200, 300);
  NiRectangle ciel = new NiRectangle();

  public GameController() {
    fenetre.setBackground(Color.blue);
    ciel.setBackground(Color.white);
    ciel.setSize(WINDOW_WIDTH, SEA_LEVEL);

    fenetre.add(satelliteController.getSatelliteView());
    fenetre.add(buoyController.getBuoyView());

//    fenetre.add(ciel);
    fenetre.openInWindow();
    ImageIcon img = new ImageIcon("assets/ocean-sat-sim-logo.png");
    fenetre.jframe.setIconImage(img.getImage());
  }

  public static void main(String[] args) {
    new GameController();
  }
}
