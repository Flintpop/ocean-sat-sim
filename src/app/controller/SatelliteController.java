package app.controller;

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
}
