package appOld;

import nicellipse.component.NiEllipse;
import nicellipse.component.NiSpace;

import java.awt.*;

public abstract class MovableEllipse extends NiEllipse {
  public Point loc;
  public int speed;
  public final int altitude;
  public final int startingPosition;
  public NiSpace fenetre;

  public MovableEllipse(NiSpace fenetre, int altitude, int startingPosition, int speed) {
    super();
    this.fenetre = fenetre;
    loc = new Point(startingPosition, altitude);
    this.altitude = altitude;
    this.startingPosition = startingPosition;
    this.fenetre.add(this);
    this.speed = speed;
    this.setMovableObjectLocation(loc);
  }

  protected void move() {
    if (loc.x < fenetre.getWidth() - this.getWidth()) {
      loc.translate(this.speed, 0);
    } else if (loc.x > 0) {
      loc.setLocation(0, this.loc.getY());
    }
    this.setMovableObjectLocation(loc);
  }
  
  public void setMovableObjectLocation(Point loc) {
    this.loc = loc;
    this.setLocation(loc);
  }
}
