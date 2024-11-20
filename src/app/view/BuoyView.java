package app.view;

import app.announcer.Announcer;
import app.announcer.CirclesListener;
import app.announcer.ColorChangedEvent;
import app.announcer.ColorListener;
import app.announcer.DisplaySyncCircles;
import app.announcer.HideSyncCircles;
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
public class BuoyView extends NiEllipse implements PositionListener, ColorListener, CirclesListener {
  private BuoyController controller;
  private ArrayList<CircleView> circles = new ArrayList<>();

  public BuoyView(Announcer announcer, int width, int height, Point pos, Color color) {
    this.setSize(width, height);
    this.setLocation(pos);
    this.setBackground(color);
    announcer.register(this, PositionChangedEvent.class);
    announcer.register(this, ColorChangedEvent.class);
    announcer.register(this, DisplaySyncCircles.class);
    announcer.register(this, HideSyncCircles.class);

    circles = CirclesFactory.createCircles();
  }

  @Override
  public void onPositionChanged(double x, double y) {
    this.setLocation((int) x, (int) y);
    circles.forEach(circleView -> circleView.updatePosition((int) x, (int) y, this.getWidth(), this.getHeight()));
  }

  @Override
  public void onColorChanged(Color color) {
    this.setBackground(color);
  }

  @Override
  public void onCirclesDisplayed() {
    this.circles.forEach(circleView -> circleView.setVisible(true));
  }

  @Override
  public void onCirclesHidden() {
    this.circles.forEach(circleView -> circleView.setVisible(false));
  }

}
