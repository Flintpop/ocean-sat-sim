package app.view;

import app.controller.BuoyController;
import app.model.BuoyModel;
import lombok.Getter;
import lombok.Setter;
import nicellipse.component.NiEllipse;

import java.io.IOException;

@Getter
@Setter
public class BuoyView extends NiEllipse {
  private BuoyModel model;
  private BuoyController controller;

  public BuoyView(BuoyModel buoyModel) throws IOException {
//    super(new File(BUOY_IMAGE_URL));
      this.model = buoyModel;
      this.setSize(model.getWidth(), model.getHeight());
      this.setLocation(model.getPos());
  }
}
