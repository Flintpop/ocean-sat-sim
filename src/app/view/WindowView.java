package app.view;

import app.Constants;
import lombok.Getter;
import lombok.Setter;
import nicellipse.component.NiRectangle;
import nicellipse.component.NiSpace;

import javax.swing.*;
import java.awt.*;

import static app.Constants.SEA_LEVEL;
import static app.Constants.WINDOW_WIDTH;

@Getter
@Setter
public class WindowView {
  NiSpace window = new NiSpace("Ocean-sat-sim", new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
  NiRectangle sky = new NiRectangle();

  public WindowView() {
    window.setBackground(Color.blue);
    sky.setBackground(Color.white);
    sky.setSize(WINDOW_WIDTH, SEA_LEVEL);
  }

  public void addToWindow(Component component) {
    window.add(component);
  }

  public void openInWindow() {
    window.openInWindow();

    ImageIcon img = new ImageIcon("assets/ocean-sat-sim-logo.png");
    window.jframe.setIconImage(img.getImage());
  }
}
