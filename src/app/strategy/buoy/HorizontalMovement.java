package app.strategy.buoy;

import app.model.ObjectModel;

import java.awt.*;

public class HorizontalMovement implements MovementStrategy {
  private final int amplitude;  // Amplitude maximale du mouvement

  public HorizontalMovement(int amplitude) {
    this.amplitude = amplitude;
  }

  @Override
  public void move(ObjectModel buoy) {
    Point loc = buoy.getPos();

    // Calcul de la position minimale et maximale en fonction de l'amplitude
    int maxWidth = buoy.getSpawningX() + amplitude / 2;
    int minWidth = buoy.getSpawningX() - amplitude / 2;

    // Inverse la direction si on dépasse la largeur maximale ou minimale, ou si on atteint les bords de la fenêtre
    if (loc.x >= maxWidth || loc.x <= minWidth || loc.x <= 0 || loc.x >= (buoy.getWindow().getWidth() - buoy.getWidth())) {
      buoy.setSpeed(-buoy.getSpeed());
    }

    // Applique le mouvement horizontal
    loc.translate((int) buoy.getSpeed(), 0);

    buoy.setPositionAndTranslate(loc);
  }
}
