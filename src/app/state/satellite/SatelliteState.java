package app.state.satellite;

import app.model.SatelliteModel;

/**
 * Interface représentant un état du cycle de vie d'une balise.
 */
public interface SatelliteState {
  void handle(SatelliteModel satelliteModel);
}

