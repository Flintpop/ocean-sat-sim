package app.state;

import app.model.BuoyModel;

/**
 * État de synchronisation de la balise.
 */
public class SynchronizingState implements BuoyState {
  @Override
  public void handle(BuoyModel buoyModel) {
    // Logique de synchronisation avec un satellite
  }
}
