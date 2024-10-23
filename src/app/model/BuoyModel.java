package app.model;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class BuoyModel {
  Point pos;
  double speed;
  Color color = Color.RED;
  int height = 20;
  int width = 20;

  public BuoyModel(Point pos, double speed) {
    this.pos = pos;
    this.speed = speed;
  }
}
