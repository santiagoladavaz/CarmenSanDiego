package pais;

import java.util.List;
import pais.Lugar;
import persona.Cuidador;
import persona.Informante;
import persona.Villano;

@SuppressWarnings("all")
public class Embajada extends Lugar {
  public Embajada(final String nom) {
    this._nombre = nom;
    Cuidador _cuidador = new Cuidador();
    this._okupa = _cuidador;
  }
  
  public void pasoLadron(final Villano villano, final List<String> pistas) {
    Informante _informante = new Informante(pistas);
    this.setOkupa(_informante);
  }
}
