package app.model;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class WindowModel {
  int width;
  int height;
  int seaLevel;

  int worldWidth;
  int worldHeight;

  public WindowModel(int width, int height) {
    this.width = width;
    this.height = height;

    this.worldWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    this.worldHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

    this.seaLevel = this.worldHeight / 2;

    if (this.width > this.worldWidth || this.height > this.worldHeight) {
      throw new IllegalArgumentException("Window size is too big for the screen : " + this.width + " " + this.height);
    }
  }
}
