package app.announcer;

/**
 * Interface pour écouter les événements de position des satellites.
 */
public interface SatellitePositionListener {
  void onSatellitePositionChanged(SatellitePositionEvent event);
}
