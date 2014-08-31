import java.util.List;

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
