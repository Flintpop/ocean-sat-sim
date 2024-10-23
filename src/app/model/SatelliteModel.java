package app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class SatelliteModel {
  Point pos;
  double speed;
  Color color = Color.GRAY;
  int height = 20;
  int width = 20;

  public SatelliteModel(Point pos, double speed) {
    this.pos = pos;
    this.speed = speed;
  }
}
