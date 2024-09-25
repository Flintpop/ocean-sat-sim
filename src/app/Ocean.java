package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import nicellipse.component.NiRectangle;
import nicellipse.component.NiSpace;

public class Ocean {
  NiSpace fenetre = new NiSpace("Exercice 1", new Dimension(400, 400));
  MovableObject satellite = new Satellite(fenetre, 50, 1);
  MovableObject satellite2 = new Satellite(fenetre, 20, 160, 0);
  NiRectangle ciel = new NiRectangle();

  public Ocean() {
    fenetre.setBackground(Color.blue);
    ciel.setBackground(Color.white);
    ciel.setSize(400, 200);

    fenetre.add(ciel);
    fenetre.openInWindow();

    int delay = 1; // milliseconds
    ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        satellite.move();
        satellite2.move();
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

