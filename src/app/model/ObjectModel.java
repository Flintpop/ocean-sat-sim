package app.model;

import app.announcer.Announcer;
import app.announcer.PositionChangedEvent;
import app.strategy.buoy.MovementStrategy;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public abstract class ObjectModel {
  Point pos;
  double speed;
  int spawningY;
  int spawningX;
  Color color;
  WindowModel window;
  MovementStrategy movementStrategy;
  Announcer announcer;
  int height;
  int width;

  public void setPositionAndTranslate(Point loc) {
    this.pos = loc;
    this.announcer.announce(new PositionChangedEvent(loc.getX(), loc.getY()));
  }
}
