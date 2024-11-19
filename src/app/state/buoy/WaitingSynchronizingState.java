package app.state.buoy;

import app.announcer.Announcer;
import app.announcer.SatellitePositionEvent;
import app.announcer.SatellitePositionListener;
import app.model.BuoyModel;
import app.Constants;

import java.awt.Color;

/**
 * État où la bouée attend la synchronisation avec un satellite.
 */
public class WaitingSynchronizingState implements BuoyState {
  private boolean isRegistered = false;
  private SatellitePositionListener listener;

  @Override
  public void handle(BuoyModel buoyModel) {
    if (!isRegistered) {
      Announcer announcer = buoyModel.getWindow().getAnnouncer();
      listener = new SatellitePositionListener() {
        @Override
        public void onSatellitePositionChanged(SatellitePositionEvent event) {
          if (isSatelliteAbove(buoyModel, event)) {
            buoyModel.setState(new SynchronizingState());
            System.out.println("Satellite détecté au-dessus. Début de la synchronisation.");
            // Désenregistrer le listener après la synchronisation
            announcer.unregister(this, SatellitePositionEvent.class);
          }
        }
      };
      announcer.register(listener, SatellitePositionEvent.class);
      isRegistered = true;
      buoyModel.setColor(Color.PINK); // Changement visuel pour indiquer l'état d'attente
      System.out.println("Bouée en attente de synchronisation avec un satellite.");
    }
  }

  /**
   * Vérifie si le satellite est au-dessus de la bouée.
   *
   * @param buoy  La bouée.
   * @param event L'événement de position du satellite.
   * @return true si le satellite est au-dessus, false sinon.
   */
  private boolean isSatelliteAbove(BuoyModel buoy, SatellitePositionEvent event) {
    double buoyX = buoy.getPos().x;
    double buoyY = buoy.getPos().y;
    double satelliteX = event.getX();
    double satelliteY = event.getY();

    double tolerance = 10.0; // Tolérance en pixels pour considérer qu'un satellite est "au-dessus"

    boolean isAboveX = Math.abs(satelliteX - buoyX) <= tolerance;
    boolean isAboveY = satelliteY < buoyY; // Satellite est au-dessus de la bouée si y du satellite est inférieur (origine en haut)

    return isAboveX && isAboveY;
  }
}
