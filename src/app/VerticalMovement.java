package app;

import java.awt.*;

import static app.constants.SEA_LEVEL;

public class VerticalMovement implements MovementStrategy {
  private final int amplitude;  // Amplitude maximale du mouvement

  public VerticalMovement(int amplitude) {
    this.amplitude = amplitude;
  }

  @Override
  public void move(Buoy buoy) {
    Point loc = buoy.getLocation();

    // Calcul de la position minimale et maximale en fonction de l'amplitude et du niveau de la mer
    int maxHeight = buoy.altitude + amplitude / 2;
    int minHeight = buoy.altitude - amplitude / 2;

    // Inverse la direction si on dépasse la hauteur maximale ou minimale
    if (loc.y >= maxHeight || loc.y <= minHeight || loc.y <= SEA_LEVEL || loc.y >= (buoy.fenetre.getHeight() - buoy.getHeight())) {
      buoy.speed = -buoy.speed;
    }

    // Applique le mouvement vertical
    loc.translate(0, buoy.speed);

    buoy.setLocation(loc);
  }
}
