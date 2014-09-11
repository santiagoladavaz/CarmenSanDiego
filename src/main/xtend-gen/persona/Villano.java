package persona;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
    final Procedure1<Pais> _function = new Procedure1<Pais>() {
      public void apply(final Pais it) {
        it.visitar(Villano.this);
      }
    };
    IterableExtensions.<Pais>forEach(_planDeEscape, _function);
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
      this.setValor(null);
      ObservableUtils.firePropertyChanged(this, propertyName, lista);
    }
  }
  
  public void eliminarValor(final String s, final String propertyName, final List<String> lista) {
    boolean _contains = lista.contains(s);
    if (_contains) {
      lista.remove(s);
    }
    ObservableUtils.firePropertyChanged(this, propertyName, lista);
  }
  
  public List<String> dameLasPistas() {
    List<String> _hobbie = this.getHobbie();
    String _get = _hobbie.get(0);
    List<String> _señas = this.getSeñas();
    String _get_1 = _señas.get(0);
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(_get, _get_1));
  }
}
