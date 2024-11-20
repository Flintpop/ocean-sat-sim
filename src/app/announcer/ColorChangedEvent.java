package app.announcer;

import java.awt.*;

public class ColorChangedEvent implements AbstractEvent<ColorListener> {
  private final Color color;

  public ColorChangedEvent(Color color) {
    this.color = color;
  }

  @Override
  public void sentTo(ColorListener listener) {
    listener.onColorChanged(color);
  }
}