package app.view;

import app.announcer.Announcer;
import app.announcer.PositionChangedEvent;
import app.announcer.PositionListener;
import app.controller.SatelliteController;
import app.model.SatelliteModel;
import lombok.Getter;
import lombok.Setter;
import nicellipse.component.NiEllipse;

/**
 * Vue représentant un satellite graphiquement.
 */
@Getter
@Setter
public class SatelliteView extends NiEllipse implements PositionListener {
  private final SatelliteModel model;
  private SatelliteController controller;

  /**
   * Constructeur de la vue du satellite.
   */
  public SatelliteView(Announcer announcerMovement, SatelliteModel satelliteModel) {
    super();
    this.model = satelliteModel;
    this.setBackground(model.getColor());
    this.setSize(model.getWidth(), model.getHeight());
    this.setLocation(model.getPos());
    announcerMovement.register(this, PositionChangedEvent.class);
  }

  @Override
  public void onPositionChanged(double x, double y) {
    this.setLocation((int) x, (int) y);
  }
}
