package app.model;

import app.announcer.Announcer;
import app.state.satellite.MovingState;
import app.state.satellite.SatelliteState;
import app.strategy.buoy.MovementStrategy;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class SatelliteModel extends ObjectModel {
  Color color = Color.GRAY;
  Color originalColor = color;
  int height = 20;
  int width = 20;
  SatelliteState state;
  MovementStrategy movementStrategy;

  public SatelliteModel(Point pos, double speed, WindowModel window,
                        MovementStrategy movementStrategy, Announcer announcerMovement) {
    this.pos = pos;
    this.speed = speed;
    this.window = window;
    this.movementStrategy = movementStrategy;
    this.announcer = announcerMovement;
    this.state = new MovingState();
  }

  /**
   * Méthode à appeler régulièrement pour mettre à jour l'état du satellite.
   */
  public void update() {
    if (state != null) {
      state.handle(this);
    }
    if (movementStrategy != null) {
      movementStrategy.move(this); // Gérer le mouvement de la bouée
    }
  }
}
