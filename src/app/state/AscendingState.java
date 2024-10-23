package app.state;

import app.model.BuoyModel;

/**
 * État de remontée de la balise.
 */
public class AscendingState implements BuoyState {
  @Override
  public void handle(BuoyModel buoyModel) {
    // Logique de remontée à la surface
  }
}
