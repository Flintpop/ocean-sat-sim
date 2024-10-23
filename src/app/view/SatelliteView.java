package app.view;

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
public class SatelliteView extends NiEllipse {
  private final SatelliteModel model;
  private SatelliteController controller;

  /**
   * Constructeur de la vue du satellite.
   *
   */
  public SatelliteView(SatelliteModel satelliteModel) {
    super();
    this.model = satelliteModel;
    this.setBackground(model.getColor());
    this.setSize(model.getWidth(), model.getHeight());
    this.setLocation(model.getPos());
  }
}
