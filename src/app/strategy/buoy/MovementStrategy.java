package app.strategy.buoy;

import app.model.BuoyModel;

public interface MovementStrategy {
  void move(BuoyModel buoyModel);
}
