package dominio;

import dominio.Persona;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class Cuidador extends Persona {
  public String informar() {
    InputOutput.<String>print("El ladron no paso por aqui");
    return "El ladron no paso por aqui";
  }
}
