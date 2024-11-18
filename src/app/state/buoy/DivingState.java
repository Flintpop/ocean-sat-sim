package app.state.buoy;

import app.model.BuoyModel;

public class DivingState implements BuoyState {
  private long startTime;
  private static final long DIVING_DURATION = 2000; // 2 secondes

  @Override
  public void handle(BuoyModel buoyModel) {
    if (startTime == 0) {
      startTime = System.currentTimeMillis();
      System.out.println("Bouée commence à plonger.");
    }

    long elapsed = System.currentTimeMillis() - startTime;
    if (elapsed >= DIVING_DURATION) {
      buoyModel.setState(new RecordingState());
      buoyModel.setMovementStrategy(buoyModel.getOriginalMovementStrategy());
      System.out.println("Bouée revient à l'état d'enregistrement.");
    }
  }
}
