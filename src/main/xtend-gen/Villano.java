import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("all")
public class Villano {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private String _sexo;
  
  public String getSexo() {
    return this._sexo;
  }
  
  public void setSexo(final String sexo) {
    this._sexo = sexo;
  }
  
  private List<String> _hobbie;
  
  public List<String> getHobbie() {
    return this._hobbie;
  }
  
  public void setHobbie(final List<String> hobbie) {
    this._hobbie = hobbie;
  }
  
  private List<String> _señas;
  
  public List<String> getSeñas() {
    return this._señas;
  }
  
  public void setSeñas(final List<String> señas) {
    this._señas = señas;
  }
  
  private List<Pais> _planDeEscape;
  
  public List<Pais> getPlanDeEscape() {
    return this._planDeEscape;
  }
  
  public void setPlanDeEscape(final List<Pais> planDeEscape) {
    this._planDeEscape = planDeEscape;
  }
  
  public Villano() {
  }
  
  public Villano(final String n, final String s, final List<String> h, final List<String> señas, final List<Pais> planDeEscape) {
    this._nombre = n;
    this._sexo = s;
    this._hobbie = h;
    this._señas = señas;
    this._planDeEscape = planDeEscape;
  }
  
  public void visitarPais() {
    List<Pais> _planDeEscape = this.getPlanDeEscape();
    final Consumer<Pais> _function = new Consumer<Pais>() {
      public void accept(final Pais it) {
        it.visitar(Villano.this);
      }
    };
    _planDeEscape.forEach(_function);
  }
}
