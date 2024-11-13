package app.announcer;

public class PositionChangedEvent implements AbstractEvent<PositionListener> {
  private final double x, y;

  public PositionChangedEvent(double x, double y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public void sentTo(PositionListener listener) {
    listener.onPositionChanged(x, y);
  }
}