package app.model;

import app.announcer.Announcer;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;

@Getter
@Setter
public class WindowModel {
  int width;
  int height;
  int seaLevel;

  int worldWidth;
  int worldHeight;
  private ArrayList<SatelliteModel> satellites; // Liste des satellites
  private Announcer announcer;

  public WindowModel(int width, int height, Announcer announcer) {
    this.announcer = announcer;
    this.width = width;
    this.height = height;

    this.worldWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    this.worldHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

    this.seaLevel = this.worldHeight / 2;

    if (this.width > this.worldWidth || this.height > this.worldHeight) {
      throw new IllegalArgumentException("Window size is too big for the screen : " + this.width + " " + this.height);
    }
  }

  public boolean addSatellite(SatelliteModel satellite) {
    if (satellite == null) {
      return false;
    }
    if (this.satellites == null) {
      this.satellites = new ArrayList<>();
    }
    this.satellites.add(satellite);
    return true;
  }
}
