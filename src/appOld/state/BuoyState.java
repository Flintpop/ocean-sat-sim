package appOld.state;

import appOld.model.BuoyModel;

/**
 * Interface représentant un état du cycle de vie d'une balise.
 */
public interface BuoyState {
  void handle(BuoyModel buoyModel);
}

