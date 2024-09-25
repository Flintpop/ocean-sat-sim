package app;

import java.awt.*;

public class HorizontalMovement implements MovementStrategy {
  private final int amplitude;  // Amplitude maximale du mouvement

  public HorizontalMovement(int amplitude) {
    this.amplitude = amplitude;
  }

  @Override
  public void move(Buoy buoy) {
    Point loc = buoy.getLocation();

    // Calcul de la position minimale et maximale en fonction de l'amplitude
    int maxWidth = buoy.startingPosition + amplitude / 2;
    int minWidth = buoy.startingPosition - amplitude / 2;

    // Inverse la direction si on dépasse la largeur maximale ou minimale, ou si on atteint les bords de la fenêtre
    if (loc.x >= maxWidth || loc.x <= minWidth || loc.x <= 0 || loc.x >= (buoy.fenetre.getWidth() - buoy.getWidth())) {
      buoy.speed = -buoy.speed;
    }

    // Applique le mouvement horizontal
    loc.translate(buoy.speed, 0);

    buoy.setMovableObjectLocation(loc);
  }
}
