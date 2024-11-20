package app.controller;

import app.model.BuoyModel;
import app.view.BuoyView;
import app.view.CircleView;
import app.view.WindowView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BuoyController {
  BuoyModel buoyModel;
  BuoyView buoyView;

  public void update() {
    buoyModel.update();
    buoyView.setLocation(buoyModel.getPos());
  }

  public void addCirclesToWindow(WindowView windowView) {
    for (CircleView circle : buoyView.getCircles()) {
      windowView.addToWindow(circle);
    }
  }

}
