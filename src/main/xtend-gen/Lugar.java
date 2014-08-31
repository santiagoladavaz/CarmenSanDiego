import java.util.List;

@SuppressWarnings("all")
public abstract class Lugar {
  protected String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  protected Persona _okupa;
  
  public Persona getOkupa() {
    return this._okupa;
  }
  
  public void setOkupa(final Persona okupa) {
    this._okupa = okupa;
  }
  
  public Persona pasoLadron(final Villano villano) {
    Persona _xblockexpression = null;
    {
      List<String> pistas = this.dameLasPistas(villano);
      Informante _informante = new Informante(pistas);
      _xblockexpression = this._okupa = _informante;
    }
    return _xblockexpression;
  }
  
  public String ocupanteInforma() {
    return this._okupa.informar();
  }
  
  public abstract List<String> dameLasPistas(final Villano villano);
}
