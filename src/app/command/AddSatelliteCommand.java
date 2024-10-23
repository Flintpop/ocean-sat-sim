package app.command;

/**
 * Commande pour ajouter un satellite.
 */
public class AddSatelliteCommand implements Command {
  private String id;
  private double hauteur;

  public AddSatelliteCommand(String id, double hauteur) {
    this.id = id;
    this.hauteur = hauteur;
  }

  @Override
  public void execute() {
  }
}
