package app.view;

import app.controller.BuoyController;
import app.model.BuoyModel;
import lombok.Getter;
import lombok.Setter;
import nicellipse.component.NiImage;

import java.io.File;
import java.io.IOException;

import static app.Constants.BUOY_IMAGE_URL;

@Getter
@Setter
public class BuoyView extends NiImage {
  private BuoyModel model;
  private BuoyController controller;

  public BuoyView(BuoyModel buoyModel) throws IOException {
    super(new File(BUOY_IMAGE_URL));
      this.model = buoyModel;
      this.setSize(model.getWidth(), model.getHeight());
      this.setLocation(model.getPos());
  }
}
