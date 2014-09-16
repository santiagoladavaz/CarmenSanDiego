package persona;

import org.eclipse.xtext.xbase.lib.InputOutput;
import persona.Persona;

@SuppressWarnings("all")
public class Cuidador extends Persona {
  public String informar() {
    InputOutput.<String>print("El ladron no paso por aqui");
    return "El ladron no paso por aqui";
  }
}
