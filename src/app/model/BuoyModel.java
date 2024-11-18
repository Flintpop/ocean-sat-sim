package app.model;

import app.announcer.Announcer;
import app.announcer.PositionChangedEvent;
import app.state.buoy.BuoyState;
import app.strategy.buoy.MovementStrategy;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class BuoyModel {
  Point pos;
  int spawningY;
  int spawningX;
  double speed;
  Color color = Color.RED;
  int height = 20;
  int width = 20;
  BuoyState state;
  MovementStrategy movementStrategy;
  WindowModel window;
  Announcer announcer;

  public BuoyModel(Point pos, double speed, WindowModel window, MovementStrategy movementStrategy, Announcer announcer) {
    this.pos = pos;
    this.spawningY = pos.y;
    this.spawningX = pos.x;
    this.speed = speed;
    this.window = window;
    this.movementStrategy = movementStrategy;
    this.announcer = announcer;
  }

  public void setPositionAndTranslate(Point loc) {
    this.pos = loc;
    this.announcer.announce(new PositionChangedEvent(loc.getX(), loc.getY()));
  }
}
