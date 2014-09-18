package pais;

import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import persona.Persona;
import persona.Villano;

@SuppressWarnings("all")
public abstract class Lugar {
  protected String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  protected Persona _okupa;
  
  public Persona getOkupa() {
    return this._okupa;
  }
  
  public void setOkupa(final Persona okupa) {
    this._okupa = okupa;
  }
  
  public abstract void pasoLadron(final Villano villano, final List<String> pistas);
  
  public String toString() {
    return this.getNombre();
  }
  
  public String ocupanteInforma() {
    String _xblockexpression = null;
    {
      InputOutput.<Lugar>print(this);
      this._okupa.informar();
      _xblockexpression = InputOutput.<String>print("\n");
    }
    return _xblockexpression;
  }
  
  public void esconderVillano(final Villano villano) {
    this.setOkupa(villano);
  }
}
