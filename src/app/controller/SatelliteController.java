package app.controller;

import app.model.SatelliteModel;
import app.view.CircleView;
import app.view.SatelliteView;
import app.view.WindowView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SatelliteController {
  SatelliteModel satelliteModel;
  SatelliteView satelliteView;

  public void update() {
    satelliteModel.update();
    satelliteView.setLocation(satelliteModel.getPos());
  }

  public void addCirclesToWindow(WindowView windowView) {
    for (CircleView circle : satelliteView.getCircles()) {
      windowView.addToWindow(circle);
    }
  }
}
