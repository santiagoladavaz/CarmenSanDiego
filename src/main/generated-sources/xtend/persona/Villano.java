package persona;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;
import pais.Pais;
import persona.Persona;

@Observable
@SuppressWarnings("all")
public class Villano extends Persona {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  private String _sexo;
  
  public String getSexo() {
    return this._sexo;
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
  
  public Villano(final String n, final String s, final List<String> hobbies, final List<String> señas, final List<Pais> plan) {
    this._nombre = n;
    this._sexo = s;
    this._hobbie = hobbies;
    this._señas = señas;
    this._planDeEscape = plan;
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
  
  /**
   * @METODOS DEL DOMINIO
   */
  public void visitarPais() {
    List<Pais> _planDeEscape = this.getPlanDeEscape();
    final Consumer<Pais> _function = new Consumer<Pais>() {
      public void accept(final Pais it) {
        it.visitar(Villano.this);
      }
    };
    _planDeEscape.forEach(_function);
  }
  
  public String toString() {
    return this._nombre;
  }
  
  public Pais obtenerSiguientePais(final Pais p) {
    List<Pais> _planDeEscape = this.getPlanDeEscape();
    final int x = _planDeEscape.indexOf(p);
    List<Pais> _planDeEscape_1 = this.getPlanDeEscape();
    int _length = ((Object[])Conversions.unwrapArray(_planDeEscape_1, Object.class)).length;
    int _minus = (_length - 1);
    boolean _lessThan = (x < _minus);
    if (_lessThan) {
      List<Pais> _planDeEscape_2 = this.getPlanDeEscape();
      return _planDeEscape_2.get((x + 1));
    }
    return null;
  }
  
  public ArrayList<String> dameLasPistas() {
    ArrayList<String> _xblockexpression = null;
    {
      final ArrayList<String> lista = CollectionLiterals.<String>newArrayList();
      List<String> _señas = this.getSeñas();
      String _get = _señas.get(0);
      String _plus = ("Una de mis señas es: " + _get);
      lista.add(_plus);
      List<String> _señas_1 = this.getSeñas();
      String _get_1 = _señas_1.get(1);
      String _plus_1 = ("Una de mis Señas es: " + _get_1);
      lista.add(_plus_1);
      _xblockexpression = lista;
    }
    return _xblockexpression;
  }
  
  public String informar() {
    return "Felicidades me atrapaste";
  }
  
  /**
   * @METODOS DE LA INTERFAZ
   */
  public void agregarValor(final String s, final String propertyName, final List<String> lista) {
    boolean _and = false;
    boolean _equals = Objects.equal(s, null);
    boolean _not = (!_equals);
    if (!_not) {
      _and = false;
    } else {
      boolean _startsWith = s.startsWith(" ");
      boolean _not_1 = (!_startsWith);
      _and = _not_1;
    }
    if (_and) {
      lista.add(s);
      ObservableUtils.firePropertyChanged(this, propertyName, lista);
      boolean _isConsistente = this.isConsistente();
      ObservableUtils.firePropertyChanged(this, "consistente", Boolean.valueOf(_isConsistente));
    }
  }
  
  public void eliminarValor(final String s, final String propertyName, final List<String> lista) {
    boolean _contains = lista.contains(s);
    if (_contains) {
      lista.remove(s);
    }
    ObservableUtils.firePropertyChanged(this, propertyName, lista);
    boolean _isConsistente = this.isConsistente();
    ObservableUtils.firePropertyChanged(this, "consistente", Boolean.valueOf(_isConsistente));
  }
  
  public boolean cumpleCondicion(final String n) {
    boolean _and = false;
    boolean _or = false;
    boolean _or_1 = false;
    boolean _equals = Objects.equal(n, "Femenino");
    if (_equals) {
      _or_1 = true;
    } else {
      boolean _equals_1 = Objects.equal(n, "Masculino");
      _or_1 = _equals_1;
    }
    if (_or_1) {
      _or = true;
    } else {
      boolean _equals_2 = Objects.equal(n, "Hermafrodita");
      _or = _equals_2;
    }
    if (!_or) {
      _and = false;
    } else {
      boolean _notEquals = (!Objects.equal(n, null));
      _and = _notEquals;
    }
    return _and;
  }
  
  public void setSexo(final String n) {
    this._sexo = n;
    String _sexo = this.getSexo();
    String _sexo_1 = this.getSexo();
    ObservableUtils.firePropertyChanged(this, _sexo, _sexo_1);
    boolean _isConsistente = this.isConsistente();
    ObservableUtils.firePropertyChanged(this, "consistente", Boolean.valueOf(_isConsistente));
  }
  
  public void setNombre(final String n) {
    this._nombre = n;
    String _nombre = this.getNombre();
    String _nombre_1 = this.getNombre();
    ObservableUtils.firePropertyChanged(this, _nombre, _nombre_1);
    boolean _isConsistente = this.isConsistente();
    ObservableUtils.firePropertyChanged(this, "consistente", Boolean.valueOf(_isConsistente));
  }
  
  public boolean isConsistente() {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    String _nombre = this.getNombre();
    boolean _notEquals = (!Objects.equal(_nombre, null));
    if (!_notEquals) {
      _and_2 = false;
    } else {
      String _sexo = this.getSexo();
      boolean _cumpleCondicion = this.cumpleCondicion(_sexo);
      _and_2 = _cumpleCondicion;
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      List<String> _señas = this.getSeñas();
      boolean _isEmpty = _señas.isEmpty();
      boolean _not = (!_isEmpty);
      _and_1 = _not;
    }
    if (!_and_1) {
      _and = false;
    } else {
      List<String> _hobbie = this.getHobbie();
      boolean _isEmpty_1 = _hobbie.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      _and = _not_1;
    }
    return _and;
  }
}
