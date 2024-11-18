package app.strategy.buoy;

import app.model.ObjectModel;

import java.awt.*;

import static app.Constants.SEA_LEVEL;

public class VerticalMovement implements MovementStrategy {
  private final int amplitude;  // Amplitude maximale du mouvement

  public VerticalMovement(int amplitude) {
    this.amplitude = amplitude;
  }

  @Override
  public void move(ObjectModel model) {
    Point loc = model.getPos();

    // Calcul de la position minimale et maximale en fonction de l'amplitude et du niveau de la mer
    int maxHeight = model.getSpawningY() + amplitude / 2;
    int minHeight = model.getSpawningY() - amplitude / 2;

    // Inverse la direction si on dépasse la hauteur maximale ou minimale
    if (loc.y >= maxHeight || loc.y <= minHeight || loc.y <= SEA_LEVEL || loc.y >= (model.getWindow().getHeight() - model.getHeight())) {
      model.setSpeed(-model.getSpeed());
    }

    // Applique le mouvement vertical
    loc.translate(0, (int) model.getSpeed());

    model.setPositionAndTranslate(loc);
  }
}
