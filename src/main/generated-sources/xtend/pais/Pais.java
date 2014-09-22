package pais;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;
import pais.Lugar;
import persona.Villano;

@Observable
@SuppressWarnings("all")
public class Pais {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  private List<String> _caract = CollectionLiterals.<String>newArrayList();
  
  public List<String> getCaract() {
    return this._caract;
  }
  
  public void setCaract(final List<String> caract) {
    this._caract = caract;
  }
  
  private List<Pais> _conexiones = CollectionLiterals.<Pais>newArrayList();
  
  public List<Pais> getConexiones() {
    return this._conexiones;
  }
  
  public void setConexiones(final List<Pais> conexiones) {
    this._conexiones = conexiones;
  }
  
  private List<Lugar> _lugares = new ArrayList<Lugar>();
  
  public List<Lugar> getLugares() {
    return this._lugares;
  }
  
  public void setLugares(final List<Lugar> lugares) {
    this._lugares = lugares;
  }
  
  private String _caracteristica;
  
  public String getCaracteristica() {
    return this._caracteristica;
  }
  
  public void setCaracteristica(final String caracteristica) {
    this._caracteristica = caracteristica;
  }
  
  public Pais(final String n, final List<String> caracts, final List<Pais> conex, final List<Lugar> l) {
    this._nombre = n;
    this._caract = caracts;
    this._conexiones = conex;
    this._lugares = l;
  }
  
  public Pais() {
  }
  
  public Pais(final String string) {
    this._nombre = string;
  }
  
  public String toString() {
    return this.getNombre();
  }
  
  /**
   * @METODOS DEL DOMINIO
   */
  public void visitar(final Villano villano) {
    final Pais pais = villano.obtenerSiguientePais(this);
    boolean _notEquals = (!Objects.equal(pais, null));
    if (_notEquals) {
      List<Lugar> _lugares = this.getLugares();
      final Consumer<Lugar> _function = new Consumer<Lugar>() {
        public void accept(final Lugar it) {
          List<String> _dame2Pistas = pais.dame2Pistas();
          it.pasoLadron(villano, _dame2Pistas);
        }
      };
      _lugares.forEach(_function);
    } else {
      List<Lugar> _lugares_1 = this.getLugares();
      Lugar _get = _lugares_1.get(0);
      _get.esconderVillano(villano);
    }
  }
  
  public List<String> dame2Pistas() {
    List<String> _caract = this.getCaract();
    String _get = _caract.get(0);
    String _plus = ("Caracteristica del pais: " + _get);
    List<String> _caract_1 = this.getCaract();
    String _get_1 = _caract_1.get(1);
    String _plus_1 = ("Caracteristica del pais: " + _get_1);
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(_plus, _plus_1));
  }
  
  /**
   * @METODOS DE LA INTERFAZ
   */
  public void agregarCaract() {
    boolean _and = false;
    String _caracteristica = this.getCaracteristica();
    boolean _equals = Objects.equal(_caracteristica, null);
    boolean _not = (!_equals);
    if (!_not) {
      _and = false;
    } else {
      String _caracteristica_1 = this.getCaracteristica();
      boolean _startsWith = _caracteristica_1.startsWith(" ");
      boolean _not_1 = (!_startsWith);
      _and = _not_1;
    }
    if (_and) {
      List<String> _caract = this.getCaract();
      String _caracteristica_2 = this.getCaracteristica();
      _caract.add(_caracteristica_2);
      this.setCaracteristica(null);
      List<String> _caract_1 = this.getCaract();
      ObservableUtils.firePropertyChanged(this, "caract", _caract_1);
      boolean _isConsistente = this.isConsistente();
      ObservableUtils.firePropertyChanged(this, "consistente", Boolean.valueOf(_isConsistente));
    }
  }
  
  public void agregarLugar(final Lugar l) {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _notEquals = (!Objects.equal(l, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      List<Lugar> _lugares = this.getLugares();
      int _size = _lugares.size();
      boolean _lessThan = (_size < 3);
      _and_1 = _lessThan;
    }
    if (!_and_1) {
      _and = false;
    } else {
      List<Lugar> _lugares_1 = this.getLugares();
      boolean _contains = _lugares_1.contains(l);
      boolean _not = (!_contains);
      _and = _not;
    }
    if (_and) {
      List<Lugar> _lugares_2 = this.getLugares();
      _lugares_2.add(l);
      List<Lugar> _lugares_3 = this.getLugares();
      ObservableUtils.firePropertyChanged(this, "lugares", _lugares_3);
      boolean _isConsistente = this.isConsistente();
      ObservableUtils.firePropertyChanged(this, "consistente", Boolean.valueOf(_isConsistente));
    } else {
      throw new UserException("Los lugares deben ser 3 y no deben estar repetidos");
    }
  }
  
  public void eliminarCaract() {
    List<String> _caract = this.getCaract();
    String _caracteristica = this.getCaracteristica();
    boolean _contains = _caract.contains(_caracteristica);
    if (_contains) {
      List<String> _caract_1 = this.getCaract();
      String _caracteristica_1 = this.getCaracteristica();
      _caract_1.remove(_caracteristica_1);
      List<String> _caract_2 = this.getCaract();
      ObservableUtils.firePropertyChanged(this, "caract", _caract_2);
      boolean _isConsistente = this.isConsistente();
      ObservableUtils.firePropertyChanged(this, "consistente", Boolean.valueOf(_isConsistente));
    } else {
      throw new UserException("No existe caracteristica");
    }
  }
  
  public List<String> conexionesToString() {
    List<Pais> _conexiones = this.getConexiones();
    final Function1<Pais, String> _function = new Function1<Pais, String>() {
      public String apply(final Pais p) {
        return p.getNombre();
      }
    };
    return ListExtensions.<Pais, String>map(_conexiones, _function);
  }
  
  public void eliminarConexion(final Pais p) {
    List<Pais> _conexiones = this.getConexiones();
    _conexiones.remove(p);
    List<Pais> _conexiones_1 = this.getConexiones();
    ObservableUtils.firePropertyChanged(this, "conexiones", _conexiones_1);
    boolean _isConsistente = this.isConsistente();
    ObservableUtils.firePropertyChanged(this, "consistente", Boolean.valueOf(_isConsistente));
  }
  
  public void agregarConexion(final Pais p) {
    List<Pais> _conexiones = this.getConexiones();
    boolean _contains = _conexiones.contains(p);
    boolean _not = (!_contains);
    if (_not) {
      List<Pais> _conexiones_1 = this.getConexiones();
      _conexiones_1.add(p);
      List<Pais> _conexiones_2 = this.getConexiones();
      ObservableUtils.firePropertyChanged(this, "conexiones", _conexiones_2);
      boolean _isConsistente = this.isConsistente();
      ObservableUtils.firePropertyChanged(this, "consistente", Boolean.valueOf(_isConsistente));
    } else {
      String _nombre = p.getNombre();
      String _plus = ("El pais \'" + _nombre);
      String _plus_1 = (_plus + "\' ");
      String _plus_2 = (_plus_1 + "ya existe");
      throw new UserException(_plus_2);
    }
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
    boolean _isConsistente = this.isConsistente();
    ObservableUtils.firePropertyChanged(this, "consistente", Boolean.valueOf(_isConsistente));
  }
  
  public void eliminarLugar(final Lugar lugar) {
    boolean _notEquals = (!Objects.equal(lugar, null));
    if (_notEquals) {
      List<Lugar> _lugares = this.getLugares();
      final Function1<Lugar, Boolean> _function = new Function1<Lugar, Boolean>() {
        public Boolean apply(final Lugar it) {
          String _string = it.toString();
          String _string_1 = lugar.toString();
          return Boolean.valueOf(Objects.equal(_string, _string_1));
        }
      };
      final Iterable<Lugar> l = IterableExtensions.<Lugar>filter(_lugares, _function);
      boolean _isEmpty = IterableExtensions.isEmpty(l);
      boolean _not = (!_isEmpty);
      if (_not) {
        List<Lugar> _lugares_1 = this.getLugares();
        Object _get = ((Object[])Conversions.unwrapArray(l, Object.class))[0];
        _lugares_1.remove(_get);
        List<Lugar> _lugares_2 = this.getLugares();
        ObservableUtils.firePropertyChanged(this, "lugares", _lugares_2);
        boolean _isConsistente = this.isConsistente();
        ObservableUtils.firePropertyChanged(this, "consistente", Boolean.valueOf(_isConsistente));
      }
    }
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
      List<String> _caract = this.getCaract();
      boolean _isEmpty = _caract.isEmpty();
      boolean _not = (!_isEmpty);
      _and_2 = _not;
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      List<Lugar> _lugares = this.getLugares();
      boolean _isEmpty_1 = _lugares.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      _and_1 = _not_1;
    }
    if (!_and_1) {
      _and = false;
    } else {
      List<Pais> _conexiones = this.getConexiones();
      boolean _isEmpty_2 = _conexiones.isEmpty();
      boolean _not_2 = (!_isEmpty_2);
      _and = _not_2;
    }
    return _and;
  }
  
  public List<String> caract(final ArrayList<String> strings) {
    return this._caract = strings;
  }
  
  public List<Pais> conexiones(final ArrayList<Pais> paises) {
    return this._conexiones = paises;
  }
  
  public List<Lugar> lugares(final ArrayList<Lugar> lugars) {
    return this._lugares = lugars;
  }
}
