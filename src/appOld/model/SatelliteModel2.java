// src/app/model/SatelliteModel.java
package appOld.model;

import appOld.observer.Observable;
import appOld.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Modèle représentant un satellite.
 */
public class SatelliteModel2 implements Observable {
  private final String id;
  private double hauteur;
  private int speed;
  private int position;
  private final List<Observer> observers;

  /**
   * Constructeur du modèle de satellite.
   *
   * @param id               Identifiant unique du satellite.
   * @param hauteur          Hauteur initiale du satellite.
   * @param speed            Vitesse de déplacement du satellite.
   * @param startingPosition Position de départ sur l'axe X.
   */
  public SatelliteModel2(String id, double hauteur, int speed, int startingPosition) {
    this.id = id;
    this.hauteur = hauteur;
    this.speed = speed;
    this.position = startingPosition;
    this.observers = new ArrayList<>();
  }

  // Getters et Setters
  public String getId() {
    return id;
  }

  public double getHauteur() {
    return hauteur;
  }

  public void setHauteur(double hauteur) {
    this.hauteur = hauteur;
    notifyObservers("hauteur");
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
    notifyObservers("speed");
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
    notifyObservers("position");
  }

  @Override
  public void addObserver(Observer observer) {
    if (!observers.contains(observer)) {
      observers.add(observer);
    }
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  /**
   * Notifie tous les observateurs d'un changement spécifique.
   *
   * @param event Type d'événement.
   */
  @Override
  public void notifyObservers(String event) {
    for (Observer observer : observers) {
      observer.update(event);
    }
  }

  /**
   * Démarre la synchronisation avec les balises.
   */
  public void startSynchronization() {
    notifyObservers("SYNCHRONIZING");
  }

  // Ajoutez d'autres méthodes métier si nécessaire
}
