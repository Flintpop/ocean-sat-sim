package app;

import nicellipse.component.NiEllipse;
import nicellipse.component.NiSpace;

import java.awt.*;

public abstract class MovableObject extends NiEllipse {
  Point loc;
  int speed;
  final int altitude;
  final int startingPosition;
  NiSpace fenetre;

  public MovableObject(NiSpace fenetre, int altitude, int startingPosition, int speed) {
    super();
    this.fenetre = fenetre;
    loc = new Point(startingPosition, altitude);  // On utilise cette position initiale une seule fois
    this.altitude = altitude;
    this.startingPosition = startingPosition;
    this.fenetre.add(this);
    this.speed = speed;
    this.setMovableObjectLocation(loc);
  }

  void move() {
    if (loc.x < fenetre.getWidth() - this.getWidth()) {
      loc.translate(this.speed, 0);
    } else if (loc.x > 0) {
      loc.setLocation(0, this.loc.getY());
    }
    this.setMovableObjectLocation(loc);
  }
  
  void setMovableObjectLocation(Point loc) {
    this.loc = loc;
    this.setLocation(loc);
  }
}
