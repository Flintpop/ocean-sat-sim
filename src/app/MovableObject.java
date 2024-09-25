package app;

import nicellipse.component.NiEllipse;
import nicellipse.component.NiSpace;

import java.awt.*;

public abstract class MovableObject extends NiEllipse {
  Point loc;
  int speed;
  NiSpace fenetre;

  public MovableObject(NiSpace fenetre, int altitude, int startingPosition, int speed) {
    super();
    this.fenetre = fenetre;
    loc = this.getLocation();
    this.loc.y = altitude;
    this.loc.x = startingPosition;
    this.fenetre.add(this);
    this.speed = speed;
  }

  void move() {
    if (loc.x < fenetre.getWidth() - this.getWidth()) {
      loc.translate(this.speed,0);
    } else if (loc.x > 0) {
      loc.setLocation(0, this.loc.getY());
    }
    this.setLocation(loc);
  }
}
