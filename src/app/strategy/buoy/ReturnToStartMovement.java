package app.strategy.buoy;

import app.model.ObjectModel;
import java.awt.Point;

/**
 * Stratégie de mouvement pour retourner à la position de départ.
 */
public class ReturnToStartMovement implements MovementStrategy {
  @Override
  public void move(ObjectModel buoy) {
    Point currentPos = buoy.getPos();

    if (currentPos.y <= buoy.getSpawningY())
      currentPos.translate(0, Math.abs((int) buoy.getSpeed()));

    buoy.setPositionAndTranslate(currentPos);
  }
}
