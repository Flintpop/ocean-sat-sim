package app.state.buoy;

import app.model.BuoyModel;

/**
 * État de synchronisation de la balise. Est déja remontée à la surface se synchronise un satellite.
 */
public class SynchronizingState implements BuoyState {
  @Override
  public void handle(BuoyModel buoyModel) {
    // Logique de synchronisation avec un satellite
  }
}
