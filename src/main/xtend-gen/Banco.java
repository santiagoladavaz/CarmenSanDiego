import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Banco extends Lugar {
  public Banco(final String nom) {
    this._nombre = nom;
    Cuidador _cuidador = new Cuidador();
    this._okupa = _cuidador;
  }
  
  public List<String> dameLasPistas(final Villano villano) {
    final ArrayList<String> pistas = new ArrayList<String>();
    List<String> _señas = villano.getSeñas();
    String _get = _señas.get(0);
    pistas.add(_get);
    return pistas;
  }
}
