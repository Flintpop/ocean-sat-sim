package app.state.satellite;

import app.announcer.ColorChangedEvent;
import app.announcer.DisplaySyncCircles;
import app.announcer.HideSyncCircles;
import app.model.SatelliteModel;

import java.awt.*;

import static app.Constants.SYNCHRONIZATION_DURATION;

public class SatelliteSynchronizingState implements SatelliteState {
  private long startTime;

  @Override
  public void handle(SatelliteModel satelliteModel) {
    if (startTime == 0) {
      startTime = System.currentTimeMillis();
      satelliteModel.getAnnouncer().announce(new ColorChangedEvent(Color.YELLOW));
      satelliteModel.getAnnouncer().announce(new DisplaySyncCircles());
      System.out.println("Bouée synchronise avec le satellite.");
    }

    long elapsed = System.currentTimeMillis() - startTime;
    if (elapsed >= SYNCHRONIZATION_DURATION) {
      satelliteModel.setState(new MovingState());
      satelliteModel.getAnnouncer().announce(new HideSyncCircles());
      satelliteModel.getAnnouncer().announce(new ColorChangedEvent(satelliteModel.getOriginalColor()));
      System.out.println("Synchronisation terminée. Bouée commence à plonger.");
    }
  }
}
