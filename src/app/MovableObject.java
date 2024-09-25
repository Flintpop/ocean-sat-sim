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
    loc = this.getLocation();
    this.loc.y = altitude;
    this.loc.x = startingPosition;
    this.altitude = altitude;
    this.startingPosition = startingPosition;
    this.fenetre.add(this);
    this.speed = speed;
    this.setLocation(startingPosition, altitude);
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

//package app;
//
//import nicellipse.component.NiEllipse;
//import nicellipse.component.NiSpace;
//
//import java.awt.*;
//
//public abstract class MovableObject extends NiEllipse {
//  int speed;
//  NiSpace fenetre;
//
//  public MovableObject(NiSpace fenetre, int altitude, int startingPosition, int speed) {
//    super();
//    this.fenetre = fenetre;
//    this.setLocation(startingPosition, altitude);
//    this.fenetre.add(this);
//    this.speed = speed;
//  }
//
//  void move() {
//    if (loc.x < fenetre.getWidth() - this.getWidth()) {
//      loc.translate(this.speed,0);
//    } else if (this.getX() > 0) {
//      this.setLocation(0, this.getY());
//    }
//    this.setLocation(loc);
//  }
//}
