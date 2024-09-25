package app;

import java.awt.*;

public class VerticalMovement implements MovementStrategy {
  @Override
  public void move(Buoy buoy) {
    Point loc = buoy.getLocation();
    if (loc.y < buoy.fenetre.getHeight() - buoy.getHeight()) {
      loc.translate(0, buoy.speed);
    } else {
      loc.setLocation(loc.x, 0);
    }
    buoy.setLocation(loc);
  }
}