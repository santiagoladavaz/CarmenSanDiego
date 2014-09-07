package persona;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;
import pais.Pais;

@Observable
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
  
  private String _valor;
  
  public String getValor() {
    return this._valor;
  }
  
  public void setValor(final String valor) {
    this._valor = valor;
  }
  
  public Villano() {
    ArrayList<String> _arrayList = new ArrayList<String>();
    this._hobbie = _arrayList;
    ArrayList<String> _arrayList_1 = new ArrayList<String>();
    this._señas = _arrayList_1;
    ArrayList<Pais> _arrayList_2 = new ArrayList<Pais>();
    this._planDeEscape = _arrayList_2;
  }
  
  public Villano(final String n, final String s) {
    this._nombre = n;
    this._sexo = s;
    ArrayList<String> _arrayList = new ArrayList<String>();
    this._hobbie = _arrayList;
    ArrayList<String> _arrayList_1 = new ArrayList<String>();
    this._señas = _arrayList_1;
    ArrayList<Pais> _arrayList_2 = new ArrayList<Pais>();
    this._planDeEscape = _arrayList_2;
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
  
  public Object dameLasPistas() {
    return null;
  }
  
  public void agregarValor(final String s, final String propertyName, final List<String> lista) {
    lista.add(s);
    ObservableUtils.firePropertyChanged(this, propertyName, lista);
  }
  
  public void eliminarValor(final String s, final List<String> lista) {
    boolean _contains = lista.contains(s);
    if (_contains) {
      lista.remove(s);
    }
    ObservableUtils.firePropertyChanged(this, "lista", lista);
  }
}
