package app.strategy.buoy;

import app.model.ObjectModel;

import java.awt.*;

public class SinusoidalMovement implements MovementStrategy {
  private double angle = 0;
  private final int amplitude; // Amplitude maximale pour le mouvement vertical

  public SinusoidalMovement(int amplitude) {
    this.amplitude = amplitude;
  }

  @Override
  public void move(ObjectModel model) {
    Point loc = model.getPos();

    // Déplacement horizontal
    loc.x += (int) model.getSpeed();

    // Mouvement vertical sinusoïdal basé sur l'angle
    loc.y = (int) (model.getSpawningY() + Math.sin(angle) * ((double) amplitude / 2));

    // Incrément de l'angle pour le prochain mouvement
    angle += 0.1;

    // Si la bouée dépasse la largeur de la fenêtre, elle revient au début
    if (loc.x > model.getWindow().getWidth()) {
      loc.x = 0;
    }

    model.setPositionAndTranslate(loc);
  }
}
