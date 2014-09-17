package pais;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.uqbar.commons.model.ObservableUtils;
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
  
  private List<String> _caract = new ArrayList<String>();
  
  public List<String> getCaract() {
    return this._caract;
  }
  
  public void setCaract(final List<String> caract) {
    this._caract = caract;
  }
  
  private List<Pais> _conexiones = new ArrayList<Pais>();
  
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
  
  public Pais() {
  }
  
  public Pais(final String string) {
    this.setNombre(string);
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
    List<String> _caract_1 = this.getCaract();
    String _get_1 = _caract_1.get(1);
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(_get, _get_1));
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
    boolean _notEquals = (!Objects.equal(l, null));
    if (_notEquals) {
      List<Lugar> _lugares = this.getLugares();
      _lugares.add(l);
      List<Lugar> _lugares_1 = this.getLugares();
      ObservableUtils.firePropertyChanged(this, "lugares", _lugares_1);
      boolean _isConsistente = this.isConsistente();
      ObservableUtils.firePropertyChanged(this, "consistente", Boolean.valueOf(_isConsistente));
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
    }
    List<String> _caract_2 = this.getCaract();
    ObservableUtils.firePropertyChanged(this, "caract", _caract_2);
    boolean _isConsistente = this.isConsistente();
    ObservableUtils.firePropertyChanged(this, "consistente", Boolean.valueOf(_isConsistente));
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
    boolean _equals = Objects.equal(p, null);
    boolean _not = (!_equals);
    if (_not) {
      List<Pais> _conexiones = this.getConexiones();
      _conexiones.add(p);
      List<Pais> _conexiones_1 = this.getConexiones();
      ObservableUtils.firePropertyChanged(this, "conexiones", _conexiones_1);
      boolean _isConsistente = this.isConsistente();
      ObservableUtils.firePropertyChanged(this, "consistente", Boolean.valueOf(_isConsistente));
    }
  }
  
  public String toString() {
    return this.getNombre();
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
    boolean _isConsistente = this.isConsistente();
    ObservableUtils.firePropertyChanged(this, "consistente", Boolean.valueOf(_isConsistente));
  }
  
  public void eliminarLugar(final Lugar lugar) {
    List<Lugar> _lugares = this.getLugares();
    _lugares.remove(lugar);
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
}
