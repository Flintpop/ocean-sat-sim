package app.state.buoy;

import app.model.BuoyModel;

/**
 * État d'attente de synchronisation de la balise. Est remontée à la surface et attend un satellite.
 */
public class WaitingSynchronizingState implements BuoyState {
  @Override
  public void handle(BuoyModel buoyModel) {
    // Logique de synchronisation avec un satellite
  }
}
