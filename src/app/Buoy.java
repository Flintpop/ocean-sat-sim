package app;

import nicellipse.component.NiSpace;
import java.awt.*;

public class Buoy extends MovableObject {
  private final MovementStrategy movementStrategy;
  private BuoyState state;

  public enum BuoyState {
    COLLECTING,
    SURFACING,
    SYNCHRONIZING
  }

  public Buoy(NiSpace fenetre, int altitude, int startingPosition, int speed) {
    super(fenetre, altitude, startingPosition, speed);
    this.setBackground(Color.yellow);
    this.setSize(15, 15);
    this.state = BuoyState.COLLECTING;
    this.movementStrategy = new SinusoidalMovement(); // Default strategy
  }

  @Override
  public void move() {
    switch (state) {
      case COLLECTING:
        movementStrategy.move(this);
        break;
      case SURFACING:
        surfaceMovement();
        break;
      case SYNCHRONIZING:
        // Do nothing, waiting for synchronization
        break;
    }
  }

  private void surfaceMovement() {
    if (loc.y > 200) {
      loc.translate(0, -speed);
      this.setLocation(loc);
    } else {
      state = BuoyState.SYNCHRONIZING;
    }
  }
}