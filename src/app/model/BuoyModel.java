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
public class BuoyModel extends ObjectModel {
  Color color = Color.RED;
  int height = 20;
  int width = 20;
  BuoyState state;
  MovementStrategy movementStrategy;

  public BuoyModel(Point pos, double speed, WindowModel window, MovementStrategy movementStrategy, Announcer announcer) {
    this.pos = pos;
    this.spawningY = pos.y;
    this.spawningX = pos.x;
    this.speed = speed;
    this.window = window;
    this.movementStrategy = movementStrategy;
    this.announcer = announcer;
  }

}
