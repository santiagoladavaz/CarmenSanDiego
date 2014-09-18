package pais;

import java.util.ArrayList;
import java.util.List;
import pais.Lugar;
import persona.Cuidador;
import persona.Informante;
import persona.Villano;

@SuppressWarnings("all")
public class Biblioteca extends Lugar {
  public Biblioteca() {
    this._nombre = "Biblioteca";
    Cuidador _cuidador = new Cuidador();
    this._okupa = _cuidador;
  }
  
  public void pasoLadron(final Villano villano, final List<String> pistas) {
    final ArrayList<String> x = villano.dameLasPistas();
    for (final String p : pistas) {
      x.add(p);
    }
    Informante _informante = new Informante(x);
    this.setOkupa(_informante);
  }
}
