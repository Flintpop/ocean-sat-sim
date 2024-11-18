package app.state.buoy;

import app.model.BuoyModel;
import app.strategy.buoy.WaitingMovement;

import static app.Constants.SEA_LEVEL;

/**
 * État de remontée de la balise.
 */
public class AscendingState implements BuoyState {
  private long startTime;

  @Override
  public void handle(BuoyModel buoyModel) {
    if (startTime == 0) {
      startTime = System.currentTimeMillis();
      System.out.println("Bouée commence à remonter.");
    }

    if (buoyModel.getPos().y <= SEA_LEVEL) {
      // Transition vers l'état suivant, par exemple WaitingSynchronizingState
      buoyModel.setState(new WaitingSynchronizingState());
      buoyModel.setMovementStrategy(new WaitingMovement());
      System.out.println("Bouée attend la synchronisation avec le satellite.");
    }
  }
}
