package app.state.buoy;

import app.model.BuoyModel;
import app.model.SatelliteModel;
import app.state.satellite.SatelliteSynchronizingState;

public class WaitingSynchronizingState implements BuoyState {
  private boolean isSatelliteAbove = false;

  @Override
  public void handle(BuoyModel buoyModel) {
    // Vérifiez si un satellite est au-dessus (logique à implémenter)
    isSatelliteAbove = isSatelliteAbove(buoyModel);

    if (isSatelliteAbove) {
      buoyModel.setState(new SynchronizingState());
      System.out.println("Satellite détecté. Début de la synchronisation.");
    }
  }

  private boolean isSatelliteAbove(BuoyModel buoyModel) {
    for (SatelliteModel satelliteModel : buoyModel.getWindow().getSatellites()) {
      if (Math.abs(satelliteModel.getPos().x - buoyModel.getPos().x) < satelliteModel.getWidth() ) {
        satelliteModel.setState(new SatelliteSynchronizingState());
        return true;
      }
    }
    return false;
  }

}
