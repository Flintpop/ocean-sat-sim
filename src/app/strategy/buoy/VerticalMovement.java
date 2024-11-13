package app.strategy.buoy;

import app.model.BuoyModel;

import java.awt.*;

import static app.Constants.SEA_LEVEL;

public class VerticalMovement implements MovementStrategy {
  private final int amplitude;  // Amplitude maximale du mouvement

  public VerticalMovement(int amplitude) {
    this.amplitude = amplitude;
  }

  @Override
  public void move(BuoyModel buoyModel) {
    Point loc = buoyModel.getPos();

    // Calcul de la position minimale et maximale en fonction de l'amplitude et du niveau de la mer
    int maxHeight = buoyModel.getRecordingAltitude() + amplitude / 2;
    int minHeight = buoyModel.getRecordingAltitude() - amplitude / 2;

    // Inverse la direction si on dépasse la hauteur maximale ou minimale
    if (loc.y >= maxHeight || loc.y <= minHeight || loc.y <= SEA_LEVEL || loc.y >= (buoyModel.getWindow().getHeight() - buoyModel.getHeight())) {
      buoyModel.setSpeed(-buoyModel.getSpeed());
    }

    // Applique le mouvement vertical
    loc.translate(0, (int) buoyModel.getSpeed());

    buoyModel.setPositionAndTranslate(loc);
  }
}
