package app.announcer;

/**
 * Événement représentant la position d'un satellite.
 */
public class SatellitePositionEvent implements AbstractEvent<SatellitePositionListener> {
  private final int satelliteId;
  private final double x, y;

  public SatellitePositionEvent(int satelliteId, double x, double y) {
    this.satelliteId = satelliteId;
    this.x = x;
    this.y = y;
  }

  public int getSatelliteId() {
    return satelliteId;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  @Override
  public void sentTo(SatellitePositionListener listener) {
    listener.onSatellitePositionChanged(this);
  }
}
