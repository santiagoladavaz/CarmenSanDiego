package persona;

import persona.Persona;

@SuppressWarnings("all")
public class Cuidador extends Persona {
  private String dialogo = "El ladron no paso por aqui";
  
  public String informar() {
    return this.dialogo;
  }
  
  public void avisarEmboscada() {
    this.dialogo = "Ten cuidado! El ladron esta en la ciudad";
  }
}
