package pais;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
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
  
  private Pais _paisElegido;
  
  public Pais getPaisElegido() {
    return this._paisElegido;
  }
  
  public void setPaisElegido(final Pais paisElegido) {
    this._paisElegido = paisElegido;
  }
  
  private Lugar _lugarElegido;
  
  public Lugar getLugarElegido() {
    return this._lugarElegido;
  }
  
  public void setLugarElegido(final Lugar lugarElegido) {
    this._lugarElegido = lugarElegido;
  }
  
  public Pais() {
  }
  
  public Pais(final String string) {
    this.setNombre(string);
  }
  
  public void visitar(final Villano villano) {
    List<Lugar> _lugares = this.getLugares();
    final Procedure1<Lugar> _function = new Procedure1<Lugar>() {
      public void apply(final Lugar it) {
        it.pasoLadron(villano);
      }
    };
    IterableExtensions.<Lugar>forEach(_lugares, _function);
  }
  
  public void agregarCaract(final String c) {
    boolean _and = false;
    boolean _equals = Objects.equal(c, null);
    boolean _not = (!_equals);
    if (!_not) {
      _and = false;
    } else {
      boolean _startsWith = c.startsWith(" ");
      boolean _not_1 = (!_startsWith);
      _and = _not_1;
    }
    if (_and) {
      List<String> _caract = this.getCaract();
      _caract.add(c);
      List<String> _caract_1 = this.getCaract();
      ObservableUtils.firePropertyChanged(this, "caract", _caract_1);
    }
  }
  
  public void agregarLugar(final Lugar l) {
    List<Lugar> _lugares = this.getLugares();
    _lugares.add(l);
    List<Lugar> _lugares_1 = this.getLugares();
    ObservableUtils.firePropertyChanged(this, "lugares", _lugares_1);
  }
  
  public void eliminarCaract(final String c) {
    List<String> _caract = this.getCaract();
    boolean _contains = _caract.contains(c);
    if (_contains) {
      List<String> _caract_1 = this.getCaract();
      _caract_1.remove(c);
    }
    List<String> _caract_2 = this.getCaract();
    ObservableUtils.firePropertyChanged(this, "caract", _caract_2);
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
  }
  
  public void agregarConexion(final Pais p) {
    boolean _equals = Objects.equal(p, null);
    boolean _not = (!_equals);
    if (_not) {
      List<Pais> _conexiones = this.getConexiones();
      _conexiones.add(p);
      List<Pais> _conexiones_1 = this.getConexiones();
      ObservableUtils.firePropertyChanged(this, "conexiones", _conexiones_1);
    }
  }
  
  public String toString() {
    return this.getNombre();
  }
  
  public boolean eliminarLugar(final Lugar lugar) {
    List<Lugar> _lugares = this.getLugares();
    return _lugares.remove(lugar);
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
