package app.factory;

import app.view.CircleView;

import java.util.ArrayList;

public class CirclesFactory {
  public static ArrayList<CircleView> createCircles() {
    ArrayList<CircleView> circles = new ArrayList<>();
    CircleView circle1 = new CircleView(100, 100, 50);
    CircleView circle2 = new CircleView(200, 150, 80);
    CircleView circle3 = new CircleView(300, 200, 110);

    circles.add(circle1);
    circles.add(circle2);
    circles.add(circle3);

    circles.forEach(circle -> {
      circle.setVisible(false);
    });
    return circles;
  }
}
