package app;

import java.awt.*;

public class SinusoidalMovement implements MovementStrategy {
  private double angle = 0;
  private final int amplitude; // Amplitude maximale pour le mouvement vertical

  public SinusoidalMovement(int amplitude) {
    this.amplitude = amplitude;
  }

  @Override
  public void move(Buoy buoy) {
    Point loc = buoy.getLocation();

    // Déplacement horizontal
    loc.x += buoy.speed;

    // Mouvement vertical sinusoïdal basé sur l'angle
    loc.y = (int) (buoy.altitude + Math.sin(angle) * ((double) amplitude / 2));

    // Incrément de l'angle pour le prochain mouvement
    angle += 0.1;

    // Si la bouée dépasse la largeur de la fenêtre, elle revient au début
    if (loc.x > buoy.fenetre.getWidth()) {
      loc.x = 0;
    }

    buoy.setLocation(loc);
  }
}
