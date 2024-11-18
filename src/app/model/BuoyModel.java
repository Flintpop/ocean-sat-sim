package app.model;

import app.announcer.Announcer;
import app.state.buoy.BuoyState;
import app.state.buoy.RecordingState;
import app.strategy.buoy.MovementStrategy;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class BuoyModel extends ObjectModel {
  Color color = Color.RED;
  int height = 20;
  int width = 20;
  BuoyState state;
  MovementStrategy movementStrategy;
  MovementStrategy originalMovementStrategy; // Pour sauvegarder la stratégie originale

  public BuoyModel(Point pos, double speed, WindowModel window, MovementStrategy movementStrategy, Announcer announcer) {
    this.pos = pos;
    this.spawningY = pos.y;
    this.spawningX = pos.x;
    this.speed = speed;
    this.window = window;
    this.movementStrategy = movementStrategy;
    this.originalMovementStrategy = movementStrategy; // Sauvegarder la stratégie originale
    this.announcer = announcer;
    this.state = new RecordingState(); // État initial
  }

  /**
   * Méthode à appeler régulièrement pour mettre à jour l'état de la bouée.
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
