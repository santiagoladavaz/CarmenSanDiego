package pais;

import java.util.List;
import pais.Lugar;
import persona.Cuidador;
import persona.Villano;

@SuppressWarnings("all")
public class Banco extends Lugar {
  public Banco(final String nom) {
    this._nombre = nom;
    Cuidador _cuidador = new Cuidador();
    this._okupa = _cuidador;
  }
  
  public String toString() {
    return this.getNombre();
  }
  
  public void pasoLadron(final Villano villano, final List<String> pistas) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
