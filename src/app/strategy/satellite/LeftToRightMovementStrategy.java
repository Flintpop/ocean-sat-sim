package app.strategy.satellite;

import app.model.ObjectModel;
import app.strategy.buoy.MovementStrategy;

import java.awt.*;

public class LeftToRightMovementStrategy implements MovementStrategy {
  @Override
  public void move(ObjectModel model) {
    Point loc = model.getPos();

    if (loc.x < model.getWindow().getWidth() - model.getWidth()) {
      loc.translate((int) model.getSpeed(), 0);
    } else if (loc.x > 0) {
      loc.setLocation(0, loc.getY());
    }
    model.setPositionAndTranslate(loc);
  }
}
