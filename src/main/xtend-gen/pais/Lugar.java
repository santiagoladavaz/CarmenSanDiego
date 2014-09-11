package pais;

import java.util.List;
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
  
  public String ocupanteInforma() {
    return this._okupa.informar();
  }
}
