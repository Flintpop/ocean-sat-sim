// src/app/factory/ElementFactory.java
package appOld.factory;

import appOld.model.Satellite;

/**
 * Fabrique pour créer des éléments de la simulation.
 */
public class SatelliteFactory {

  /**
   * Crée un satellite avec les paramètres spécifiés.
   *
   * @param id        Identifiant du satellite.
   * @param hauteur   Hauteur initiale du satellite.
   * @param speed     Vitesse de déplacement du satellite.
   * @param fenetre   Fenêtre graphique où le satellite sera affiché.
   * @return Le contrôleur du satellite.
   */
  public static Satellite createSatellite() {
    return null;
  }

  public static Satellite createGeostationnarySatellite() {
    return null;
  }
}
