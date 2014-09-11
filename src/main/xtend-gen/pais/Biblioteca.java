package pais;

import java.util.List;
import pais.Lugar;
import persona.Cuidador;
import persona.Informante;
import persona.Villano;

@SuppressWarnings("all")
public class Biblioteca extends Lugar {
  public Biblioteca(final String nom) {
    this._nombre = nom;
    Cuidador _cuidador = new Cuidador();
    this._okupa = _cuidador;
  }
  
  public void pasoLadron(final Villano villano, final List<String> pistas) {
    final List<String> x = villano.dameLasPistas();
    x.addAll(pistas);
    Informante _informante = new Informante(x);
    this.setOkupa(_informante);
  }
}
