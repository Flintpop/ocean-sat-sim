package app.state.buoy;

import app.model.BuoyModel;
import app.strategy.buoy.ReturnToStartMovement;
import app.strategy.buoy.WaitingMovement;

public class WaitingSynchronizingState implements BuoyState {
  private boolean satelliteAbove = false;

  @Override
  public void handle(BuoyModel buoyModel) {
    // Vérifiez si un satellite est au-dessus (logique à implémenter)
    satelliteAbove = checkSatellitePosition(buoyModel);

    if (satelliteAbove) {
      buoyModel.setState(new SynchronizingState());
      System.out.println("Satellite détecté. Début de la synchronisation.");
    }
  }

  private boolean checkSatellitePosition(BuoyModel buoyModel) {
    // Implémentez la logique pour vérifier si un satellite est au-dessus
    // Par exemple, comparer les coordonnées x
    // Retourne true si un satellite est détecté
    return true; // Placeholder
  }
}
