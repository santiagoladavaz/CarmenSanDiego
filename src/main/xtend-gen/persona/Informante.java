package persona;

import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import persona.Persona;

@SuppressWarnings("all")
public class Informante extends Persona {
  private List<String> _pistas;
  
  public List<String> getPistas() {
    return this._pistas;
  }
  
  public void setPistas(final List<String> pistas) {
    this._pistas = pistas;
  }
  
  public Informante(final List<String> strings) {
    this._pistas = strings;
  }
  
  public String informar() {
    String s = "";
    List<String> _pistas = this.getPistas();
    for (final String p : _pistas) {
      s = (s + p);
    }
    InputOutput.<String>print(s);
    return s;
  }
}
