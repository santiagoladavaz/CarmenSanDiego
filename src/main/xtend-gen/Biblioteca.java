import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Biblioteca extends Lugar {
  public Biblioteca(final String nom) {
    this._nombre = nom;
    Cuidador _cuidador = new Cuidador();
    this._okupa = _cuidador;
  }
  
  public void pasoLadron(final Villano villano) {
    ArrayList<String> pistas = this.dameLasPistas(villano);
    Informante _informante = new Informante(pistas);
    this._okupa = _informante;
  }
  
  public ArrayList<String> dameLasPistas(final Villano villano) {
    final ArrayList<String> list = new ArrayList<String>();
    List<String> _señas = villano.getSeñas();
    String _get = _señas.get(0);
    list.add(_get);
    List<String> _señas_1 = villano.getSeñas();
    String _get_1 = _señas_1.get(1);
    list.add(_get_1);
    List<String> _hobbie = villano.getHobbie();
    String _get_2 = _hobbie.get(0);
    list.add(_get_2);
    return list;
  }
}
