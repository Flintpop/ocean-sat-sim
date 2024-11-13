package app.view;

import app.Constants;
import app.WindowController;
import lombok.Getter;
import lombok.Setter;
import nicellipse.component.NiRectangle;
import nicellipse.component.NiSpace;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class WindowView {
  NiSpace window = new NiSpace("Ocean-sat-sim", new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
  NiRectangle sky = new NiRectangle();
  WindowController controller;

  public WindowView(WindowController controller) {
    this.controller = controller;
    window.setBackground(Color.blue);
    sky.setBackground(Color.white);
    sky.setSize(controller.getWindowModel().getWorldWidth(), controller.getWindowModel().getSeaLevel());
    sky.setFixedToScreen(true);
  }

  public void addToWindow(Component component) {
    window.add(component);
  }

  public void openInWindow() {
    window.openInWindow();

    ImageIcon img = new ImageIcon("assets/ocean-sat-sim-logo.png");
    window.frame.setIconImage(img.getImage());
  }
}
