package app;

import nicellipse.component.NiSpace;

import java.awt.*;

public class Satellite extends MovableObject {
  public Satellite(NiSpace fenetre, int altitude, int startingPosition, int speed) {
    super(fenetre, altitude, startingPosition, speed);
    this.setBackground(Color.gray);
    this.setSize(20, 20);
  }

  public Satellite(NiSpace fenetre, int altitude, int speed) {
    this(fenetre, altitude, 0, speed);
  }
}
