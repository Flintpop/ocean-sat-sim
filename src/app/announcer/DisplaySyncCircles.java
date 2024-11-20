package app.announcer;

import java.awt.*;

public class DisplaySyncCircles implements AbstractEvent<CirclesListener> {

  public DisplaySyncCircles() {
  }

  @Override
  public void sentTo(CirclesListener listener) {
    listener.onCirclesDisplayed();
  }
}