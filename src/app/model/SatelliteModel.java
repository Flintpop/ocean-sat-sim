package app.model;

import app.announcer.Announcer;
import app.state.satellite.SatelliteState;
import app.strategy.buoy.MovementStrategy;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class SatelliteModel extends ObjectModel {
  int id;
  Point pos;
  double speed;
  Color color = Color.GRAY;
  int height = 20;
  int width = 20;
  SatelliteState state;
  MovementStrategy movementStrategy;

  public SatelliteModel(int id, Point pos, double speed, WindowModel window,
                        MovementStrategy movementStrategy, Announcer announcerMovement) {
    this.id = id;
    this.pos = pos;
    this.speed = speed;
    this.window = window;
    this.movementStrategy = movementStrategy;
    this.announcer = announcerMovement;
  }
}
