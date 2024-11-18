package app.state.buoy;

import app.model.BuoyModel;
import app.strategy.buoy.GoToSurfaceMovement;

import java.util.Random;

/**
 * État d'enregistrement de la balise.
 */
public class RecordingState implements BuoyState {
  private long startTime;
  private long duration; // en millisecondes
//  private static final long MIN_DURATION = 500; // 5 secondes
//  private static final long MAX_ADDITIONAL_DURATION = 1000; // 5 secondes supplémentaires
  private static final long MIN_DURATION = 5000; // 5 secondes
  private static final long MAX_ADDITIONAL_DURATION = 15000; // 5 secondes supplémentaires
  private Random random = new Random();

  @Override
  public void handle(BuoyModel buoyModel) {
    if (startTime == 0) {
      startTime = System.currentTimeMillis();
      duration = MIN_DURATION + random.nextInt((int) MAX_ADDITIONAL_DURATION);
      System.out.println("Bouée commence l'enregistrement pour " + duration + " ms.");
    }

    long elapsed = System.currentTimeMillis() - startTime;
    if (elapsed >= duration) {
      // Transition vers l'état suivant, par exemple AscendingState
      buoyModel.setState(new AscendingState());
      buoyModel.setMovementStrategy(new GoToSurfaceMovement());
      System.out.println("Bouée passe à l'état de remontée.");
    }
  }
}
