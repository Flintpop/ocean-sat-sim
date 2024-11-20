package app.view;

import app.announcer.Announcer;
import app.announcer.ColorChangedEvent;
import app.announcer.ColorListener;
import app.announcer.PositionChangedEvent;
import app.announcer.PositionListener;
import app.controller.SatelliteController;
import app.factory.CirclesFactory;
import app.model.SatelliteModel;
import lombok.Getter;
import lombok.Setter;
import nicellipse.component.NiEllipse;

import java.awt.*;
import java.util.ArrayList;

/**
 * Vue représentant un satellite graphiquement.
 */
@Getter
@Setter
public class SatelliteView extends NiEllipse implements PositionListener, ColorListener {
  private SatelliteController controller;
  private ArrayList<CircleView> circles = new ArrayList<>();

  /**
   * Constructeur de la vue du satellite.
   */
  public SatelliteView(Announcer announcer, int width, int height, Point pos, Color color) {
    super();
    this.setBackground(color);
    this.setSize(width, height);
    this.setLocation(pos);
    announcer.register(this, PositionChangedEvent.class);
    announcer.register(this, ColorChangedEvent.class);

    circles = CirclesFactory.createCircles();
  }

  @Override
  public void onPositionChanged(double x, double y) {
    this.setLocation((int) x, (int) y);
    circles.forEach(circleView -> {
      circleView.updatePosition((int) x, (int) y, this.getWidth(), this.getHeight());
    });
  }

  @Override
  public void onColorChanged(Color color) {
    this.setBackground(color);
  }
}
