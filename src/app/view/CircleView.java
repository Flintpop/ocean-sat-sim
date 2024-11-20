package app.view;

import lombok.Getter;
import lombok.Setter;
import nicellipse.component.NiEllipse;
import java.awt.*;

@Getter
@Setter
public class CircleView extends NiEllipse {
  private int radius;
  // Méthode pour obtenir l'instance de NiEllipse
  // Rendre le constructeur public pour permettre l'instanciation
  public CircleView(int radius) {
    this.radius = radius;
    this.setSize(radius, radius);
    this.setBorderColor(Color.red);  // Couleur de la bordure du cercle
    this.setStrokeWidth(2);
    this.setWithBorder(true);
    this.setBackground(new Color(0, 0, 0, 0));  // Cercle transparent à l'intérieur
  }

  public void updatePosition(int x, int y, int objectWidth, int objectHeight) {
    int radius = this.getRadius();
    this.setLocation((x - radius / 2) + this.getWidth() / 2, (y - radius / 2) + this.getHeight() / 2);
    this.setLocation((x - radius / 2) + objectWidth / 2, (y - radius / 2) + objectHeight / 2);
  }
}
