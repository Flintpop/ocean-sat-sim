package app;

import java.awt.*;

public class SinusoidalMovement implements MovementStrategy {
  private double angle = 0;

  @Override
  public void move(Buoy buoy) {
    Point loc = buoy.getLocation();
    loc.x += buoy.speed;
    loc.y = (int) (buoy.loc.y + Math.sin(angle) * 50);
    angle += 0.1;
    if (loc.x > buoy.fenetre.getWidth()) {
      loc.x = 0;
    }
    buoy.setLocation(loc);
  }
}