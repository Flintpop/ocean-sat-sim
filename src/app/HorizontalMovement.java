package app;

import java.awt.*;

public class HorizontalMovement implements MovementStrategy {
  @Override
  public void move(Buoy buoy) {
    Point loc = buoy.getLocation();
    if (loc.x < buoy.fenetre.getWidth() - buoy.getWidth()) {
      loc.translate(buoy.speed, 0);
    } else {
      loc.setLocation(0, loc.y);
    }
    buoy.setLocation(loc);
  }
}