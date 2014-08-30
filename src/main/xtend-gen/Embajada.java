@SuppressWarnings("all")
public class Embajada extends Lugar {
  public Embajada(final String nom) {
    this._nombre = nom;
    Cuidador _cuidador = new Cuidador();
    this._okupa = _cuidador;
  }
  
  public void pasoLadron(final Villano villano) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
