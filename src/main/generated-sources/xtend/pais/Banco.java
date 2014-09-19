package pais;

import java.util.List;
import pais.Lugar;
import persona.Cuidador;
import persona.Villano;

@SuppressWarnings("all")
public class Banco extends Lugar {
  public Banco() {
    this._nombre = "Banco";
    Cuidador _cuidador = new Cuidador();
    this._okupa = _cuidador;
  }
  
  public void pasoLadron(final Villano villano, final List<String> pistas) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
