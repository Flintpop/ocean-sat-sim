package app.controller;

import app.announcer.Announcer;
import app.announcer.SatellitePositionEvent;
import app.model.SatelliteModel;
import app.view.SatelliteView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SatelliteController {
  SatelliteModel satelliteModel;
  SatelliteView satelliteView;
  private Announcer announcer;

  public void move() {
    satelliteModel.getMovementStrategy().move(satelliteModel);
    announcer.announce(new SatellitePositionEvent(
            satelliteModel.getId(),
            satelliteModel.getPos().x,
            satelliteModel.getPos().y
    ));
  }
}
