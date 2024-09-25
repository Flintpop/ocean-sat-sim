package app;

import nicellipse.component.NiSpace;
import java.awt.*;

import static app.constants.SEA_LEVEL;

public class Buoy extends MovableObject {
  public MovementStrategy movementStrategy;
  private BuoyState state;

  public enum BuoyState {
    COLLECTING,
    SURFACING,
    SYNCHRONIZING
  }

  public Buoy(NiSpace fenetre, int altitude, int startingPosition, int speed) {
    super(fenetre, altitude + SEA_LEVEL, startingPosition, speed);
    if (altitude < 0) {
      throw new IllegalArgumentException("Buoy altitude must be positive");
    }
    if (startingPosition < 0) {
      throw new IllegalArgumentException("Buoy starting position must be positive");
    }
    this.setBackground(Color.yellow);
    this.setSize(15, 15);
    this.state = BuoyState.COLLECTING;
    this.movementStrategy = new VerticalMovement(50); // Default strategy

    if (altitude > SEA_LEVEL - this.getHeight()) {
      throw new IllegalArgumentException("Buoy altitude must be less than sea level");
    }
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