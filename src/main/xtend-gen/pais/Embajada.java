package pais;

import java.util.List;
import pais.Lugar;
import persona.Cuidador;
import persona.Villano;

@SuppressWarnings("all")
public class Embajada extends Lugar {
  public Embajada(final String nom) {
    this._nombre = nom;
    Cuidador _cuidador = new Cuidador();
    this._okupa = _cuidador;
  }
  
  public List<String> dameLasPistas(final Villano villano) {
    return null;
  }
}
