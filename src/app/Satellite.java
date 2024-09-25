package app;

import nicellipse.component.NiSpace;

import java.awt.*;
import java.util.ArrayList;

public class Satellite extends MovableObject implements Observable  {
  private final ArrayList<Observer> observers = new ArrayList<>();

  @Override
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers(String event) {
    for (Observer observer : observers) {
      observer.update(event);
    }
  }

  public void startSynchronization() {
    notifyObservers("SYNCHRONIZING");
  }

  public Satellite(NiSpace fenetre, int altitude, int startingPosition, int speed) {
    super(fenetre, altitude, startingPosition, speed);
    this.setBackground(Color.gray);
    this.setSize(20, 20);
  }

  public Satellite(NiSpace fenetre, int altitude, int speed) {
    this(fenetre, altitude, 0, speed);
  }
}
