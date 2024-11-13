package app.controller;

import app.model.BuoyModel;
import app.view.BuoyView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BuoyController {
  BuoyModel buoyModel;
  BuoyView buoyView;

  public void move() {
    buoyModel.getMovementStrategy().move(buoyModel);
  }
}
