package app.state.satellite;

import app.announcer.ColorChangedEvent;
import app.model.SatelliteModel;

import java.awt.*;

public class SatelliteSynchronizingState implements SatelliteState {
  private static final long SYNCHRONIZING_DURATION = 2000; // 2 secondes
  private long startTime;

  @Override
  public void handle(SatelliteModel satelliteModel) {
    if (startTime == 0) {
      startTime = System.currentTimeMillis();
      satelliteModel.getAnnouncer().announce(new ColorChangedEvent(Color.YELLOW));
      satelliteModel.getAnnouncer().announce(new ColorChangedEvent(Color.YELLOW));
      System.out.println("Bouée synchronise avec le satellite.");
    }

    long elapsed = System.currentTimeMillis() - startTime;
    if (elapsed >= SYNCHRONIZING_DURATION) {
      satelliteModel.setState(new MovingState());
      satelliteModel.getAnnouncer().announce(new ColorChangedEvent(satelliteModel.getOriginalColor()));
      System.out.println("Synchronisation terminée. Bouée commence à plonger.");
    }
  }
}
