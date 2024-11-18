package app.strategy.buoy;

import app.model.ObjectModel;

import java.awt.*;

import static app.Constants.SEA_LEVEL;

/**
 * Stratégie de mouvement pour remonter à la surface (niveau de la mer).
 */
public class GoToSurfaceMovement implements MovementStrategy {

  @Override
  public void move(ObjectModel buoy) {
    Point currentPos = buoy.getPos();

    // Calcul de la distance à parcourir vers le niveau de la mer
    int deltaY = currentPos.y - SEA_LEVEL;

    // Si la bouée est déjà au niveau de la mer ou au-dessus, ne rien faire
    if (deltaY <= 0) {
      return;
    }

    // Calculer un pas vers le niveau de la mer
    // On limite le pas à la vitesse définie pour éviter les dépassements
    int stepY = (int) Math.min(buoy.getSpeed() * buoy.getSpeed(), deltaY);

    // Appliquer le mouvement vertical
    currentPos.translate(0, -stepY); // Remonter : y diminue

    buoy.setPositionAndTranslate(currentPos);
  }
}
