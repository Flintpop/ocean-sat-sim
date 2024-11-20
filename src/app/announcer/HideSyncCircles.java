package app.announcer;

public class HideSyncCircles implements AbstractEvent<CirclesListener> {

  public HideSyncCircles() {
  }

  @Override
  public void sentTo(CirclesListener listener) {
    listener.onCirclesHidden();
  }
}