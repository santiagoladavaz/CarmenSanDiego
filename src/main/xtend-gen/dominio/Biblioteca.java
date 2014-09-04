package dominio;

import dominio.Cuidador;
import dominio.Lugar;
import dominio.Villano;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Biblioteca extends Lugar {
  public Biblioteca(final String nom) {
    this._nombre = nom;
    Cuidador _cuidador = new Cuidador();
    this._okupa = _cuidador;
  }
  
  public List<String> dameLasPistas(final Villano villano) {
    final ArrayList<String> list = new ArrayList<String>();
    List<String> _señas = villano.getSeñas();
    String _get = _señas.get(0);
    list.add(_get);
    return list;
  }
}
