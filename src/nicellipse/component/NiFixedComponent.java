package nicellipse.component;

import java.awt.Point;

public interface NiFixedComponent extends NiBasicComponent {
  default boolean isFixedToScreen() {
    return false;
  }

  default Point getScreenPosition() {
    return null;
  }

  default void setScreenPosition(Point p) {
  }
}