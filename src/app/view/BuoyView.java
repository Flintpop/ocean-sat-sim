package app.view;

import app.announcer.Announcer;
import app.announcer.PositionChangedEvent;
import app.announcer.PositionListener;
import app.controller.BuoyController;
import app.model.BuoyModel;
import lombok.Getter;
import lombok.Setter;
import nicellipse.component.NiEllipse;

import java.awt.*;
import java.io.IOException;

@Getter
@Setter
public class BuoyView extends NiEllipse implements PositionListener {
  private BuoyController controller;

  public BuoyView(Announcer announcerMovement, int width, int height, Point pos) {
      this.setSize(width, height);
      this.setLocation(pos);
      announcerMovement.register(this, PositionChangedEvent.class);
  }

  @Override
  public void onPositionChanged(double x, double y) {
    this.setLocation((int) x, (int) y);
  }
}
