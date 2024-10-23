package app.controller;

import app.model.BuoyModel;
import app.model.SatelliteModel;
import app.view.BuoyView;
import app.view.SatelliteView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BuoyController {
  BuoyModel buoyModel;
  BuoyView buoyView;
}
