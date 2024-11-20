package app.factory;

import app.view.CircleView;

import java.util.ArrayList;

public class CirclesFactory {
  public static ArrayList<CircleView> createCircles() {
    ArrayList<CircleView> circles = new ArrayList<>();
    int number = 12;
    int baseRadius = 60;
    int radiusGap = 40;

    for (int i = 0; i < number; i++) {
      int currentRadius = baseRadius + i * radiusGap;

      CircleView circle = new CircleView(currentRadius);
      circle.setVisible(false);  // Rendre le cercle invisible par défaut
      circles.add(circle);
    }

    return circles;
  }
}
