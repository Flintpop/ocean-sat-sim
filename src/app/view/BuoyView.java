package app.view;

import app.announcer.Announcer;
import app.announcer.ColorChangedEvent;
import app.announcer.ColorListener;
import app.announcer.DisplaySyncCircles;
import app.announcer.PositionChangedEvent;
import app.announcer.PositionListener;
import app.controller.BuoyController;
import app.factory.CirclesFactory;
import app.model.BuoyModel;
import lombok.Getter;
import lombok.Setter;
import nicellipse.component.NiEllipse;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

@Getter
@Setter
public class BuoyView extends NiEllipse implements PositionListener, ColorListener {
  private BuoyController controller;
  private ArrayList<CircleView> circles = new ArrayList<>();

  public BuoyView(Announcer announcer, int width, int height, Point pos, Color color) {
    this.setSize(width, height);
    this.setLocation(pos);
    this.setBackground(color);
    announcer.register(this, PositionChangedEvent.class);
    announcer.register(this, ColorChangedEvent.class);
//    announcer.register(this, DisplaySyncCircles.class);
    circles = CirclesFactory.createCircles();
  }

  @Override
  public void onPositionChanged(double x, double y) {
    this.setLocation((int) x, (int) y);
  }

  @Override
  public void onColorChanged(Color color) {
    this.setBackground(color);
  }
}
