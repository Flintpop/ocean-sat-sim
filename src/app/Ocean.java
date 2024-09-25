package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import nicellipse.component.NiRectangle;
import nicellipse.component.NiSpace;

public class Ocean {
  NiSpace fenetre = new NiSpace("Exercice 1", new Dimension(400, 400));
  NiRectangle satellite = new NiRectangle();
  NiRectangle ciel = new NiRectangle();

  public Ocean() {
    fenetre.setBackground(Color.blue);
    ciel.setBackground(Color.white);
    ciel.setSize(400, 200);
    satellite.setBackground(Color.gray);
    satellite.setSize(20, 20);
    fenetre.add(satellite);
    fenetre.add(ciel);

    fenetre.openInWindow();

    int delay = 1; // milliseconds
    ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Point loc = satellite.getLocation();
        if (loc.y == 0 && loc.x < fenetre.getWidth() - satellite.getWidth()) {
          loc.translate(1,0);
        } else if (loc.x > 0 && loc.y < fenetre.getHeight() - satellite.getHeight()) {
          loc.translate(0,1);
        } else if (loc.x > 0) {
          loc.translate(-1,0);
        } else if (loc.y > 0) {
          loc.translate(0,-1);
        }
        if (loc.x == 0 && loc.y == 0) {
          satellite.setBackground(new Color((int)(Math.random() * 0x1000000)));
        }
        satellite.setLocation(loc);
      }
    };
    Timer animation = new Timer(delay, taskPerformer);
    animation.setRepeats(true);
    animation.start();
  }

  public static void main(String[] args) {
    new Ocean();
  }

}

