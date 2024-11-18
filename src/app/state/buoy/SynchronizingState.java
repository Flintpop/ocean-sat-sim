package app.state.buoy;

import app.model.BuoyModel;
import app.strategy.buoy.ReturnToStartMovement;

public class SynchronizingState implements BuoyState {
  private long startTime;
  private static final long SYNCHRONIZING_DURATION = 2000; // 2 secondes

  @Override
  public void handle(BuoyModel buoyModel) {
    if (startTime == 0) {
      startTime = System.currentTimeMillis();
      System.out.println("Bouée synchronise avec le satellite.");
    }

    long elapsed = System.currentTimeMillis() - startTime;
    if (elapsed >= SYNCHRONIZING_DURATION) {
      buoyModel.setState(new DivingState());
      buoyModel.setMovementStrategy(new ReturnToStartMovement());
      System.out.println("Synchronisation terminée. Bouée commence à plonger.");
    }
  }
}
