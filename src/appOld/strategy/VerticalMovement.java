package appOld.strategy;

import appOld.model.BuoyModel;

import java.awt.*;

import static appOld.Constants.SEA_LEVEL;

public class VerticalMovement implements MovementStrategy {
  private final int amplitude;  // Amplitude maximale du mouvement

  public VerticalMovement(int amplitude) {
    this.amplitude = amplitude;
  }

  @Override
  public void move(BuoyModel buoyModel) {
    Point loc = buoyModel.getLocation();

    // Calcul de la position minimale et maximale en fonction de l'amplitude et du niveau de la mer
    int maxHeight = buoyModel.altitude + amplitude / 2;
    int minHeight = buoyModel.altitude - amplitude / 2;

    // Inverse la direction si on dépasse la hauteur maximale ou minimale
    if (loc.y >= maxHeight || loc.y <= minHeight || loc.y <= SEA_LEVEL || loc.y >= (buoyModel.fenetre.getHeight() - buoyModel.getHeight())) {
      buoyModel.speed = -buoyModel.speed;
    }

    // Applique le mouvement vertical
    loc.translate(0, buoyModel.speed);

    buoyModel.setMovableObjectLocation(loc);
  }
}
