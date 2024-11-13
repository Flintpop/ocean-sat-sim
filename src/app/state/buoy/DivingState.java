package app.state.buoy;

import app.model.BuoyModel;

/**
 * État de plongée de la balise. Est en train de plonger pour revenir a son état de RecordingState.
 */
public class DivingState implements BuoyState {
  @Override
  public void handle(BuoyModel buoyModel) {
    // Logique de synchronisation avec un satellite
  }
}
