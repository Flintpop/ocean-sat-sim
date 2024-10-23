package app.command;

/**
 * Commande pour supprimer une balise.
 */
public class RemoveBuoyCommand implements Command {
  private String buoyId;

  public RemoveBuoyCommand(String buoyId) {
    this.buoyId = buoyId;
  }

  @Override
  public void execute() {
  }
}
