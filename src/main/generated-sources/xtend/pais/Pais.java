package pais;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
  
  private Lugar _primerLugar;
  
  public Lugar getPrimerLugar() {
    return this._primerLugar;
  }
  
  private Lugar _segundoLugar;
  
  public Lugar getSegundoLugar() {
    return this._segundoLugar;
  }
  
  private Lugar _tercerLugar;
  
  public Lugar getTercerLugar() {
    return this._tercerLugar;
  }
  
  public Pais(final String n, final List<String> caracts, final List<Pais> conex, final List<Lugar> l) {
    this.setNombre(n);
    this.setCaract(caracts);
    this.setConexiones(conex);
    this.setLugares(l);
    Lugar _get = l.get(0);
    this.setPrimerLugar(_get);
    Lugar _get_1 = l.get(1);
    this.setSegundoLugar(_get_1);
    Lugar _get_2 = l.get(2);
    this.setTercerLugar(_get_2);
  }
  
  public Lugar setLugares(final List<Lugar> l) {
    Lugar _xblockexpression = null;
    {
      this._lugares = l;
      Lugar _get = l.get(0);
      this._primerLugar = _get;
      Lugar _get_1 = l.get(1);
      this._segundoLugar = _get_1;
      Lugar _get_2 = l.get(2);
      _xblockexpression = this._tercerLugar = _get_2;
    }
    return _xblockexpression;
  }
  
  public Pais(final String string) {
    this._nombre = string;
  }
  
  public Pais() {
  }
  
  public String toString() {
    return this.getNombre();
  }
  
  public void setPrimerLugar(final Lugar l) {
    this._primerLugar = l;
    Lugar _primerLugar = this.getPrimerLugar();
    ObservableUtils.firePropertyChanged(this, "primerLugar", _primerLugar);
  }
  
  public void setSegundoLugar(final Lugar l) {
    this._segundoLugar = l;
    Lugar _segundoLugar = this.getSegundoLugar();
    ObservableUtils.firePropertyChanged(this, "segundoLugar", _segundoLugar);
  }
  
  public void setTercerLugar(final Lugar l) {
    this._tercerLugar = l;
    Lugar _tercerLugar = this.getTercerLugar();
    ObservableUtils.firePropertyChanged(this, "tercerLugar", _tercerLugar);
  }
  
  /**
   * @METODOS DEL DOMINIO
   */
  public void visitar(final Villano villano) {
    final Pais pais = villano.obtenerSiguientePais(this);
    boolean _notEquals = (!Objects.equal(pais, null));
    if (_notEquals) {
      List<Lugar> _lugares = this.getLugares();
      final Procedure1<Lugar> _function = new Procedure1<Lugar>() {
        public void apply(final Lugar it) {
          List<String> _dame2Pistas = pais.dame2Pistas();
          it.pasoLadron(villano, _dame2Pistas);
        }
      };
      IterableExtensions.<Lugar>forEach(_lugares, _function);
    } else {
      this.esconderLadron(villano);
    }
  }
  
  private void esconderLadron(final Villano v) {
    double _random = Math.random();
    List<Lugar> _lugares = this.getLugares();
    int _size = _lugares.size();
    double _multiply = (_random * _size);
    final int i = ((int) _multiply);
    switch (i) {
      case 0:
        Lugar _primerLugar = this.getPrimerLugar();
        _primerLugar.esconderVillano(v);
        Lugar _segundoLugar = this.getSegundoLugar();
        _segundoLugar.avisarEmboscada();
        Lugar _tercerLugar = this.getTercerLugar();
        _tercerLugar.avisarEmboscada();
        break;
      case 1:
        Lugar _primerLugar_1 = this.getPrimerLugar();
        _primerLugar_1.avisarEmboscada();
        Lugar _segundoLugar_1 = this.getSegundoLugar();
        _segundoLugar_1.esconderVillano(v);
        Lugar _tercerLugar_1 = this.getTercerLugar();
        _tercerLugar_1.avisarEmboscada();
        break;
      default:
        {
          Lugar _primerLugar_2 = this.getPrimerLugar();
          _primerLugar_2.avisarEmboscada();
          Lugar _segundoLugar_2 = this.getSegundoLugar();
          _segundoLugar_2.avisarEmboscada();
          Lugar _tercerLugar_2 = this.getTercerLugar();
          _tercerLugar_2.esconderVillano(v);
        }
        break;
    }
  }
  
  private List<Integer> dame2Randoms() {
    double _random = Math.random();
    List<String> _caract = this.getCaract();
    int _size = _caract.size();
    double _multiply = (_random * _size);
    final int i = ((int) _multiply);
    double _random_1 = Math.random();
    List<String> _caract_1 = this.getCaract();
    int _size_1 = _caract_1.size();
    double _multiply_1 = (_random_1 * _size_1);
    final int y = ((int) _multiply_1);
    if ((y != i)) {
      return Collections.<Integer>unmodifiableList(Lists.<Integer>newArrayList(Integer.valueOf(y), Integer.valueOf(i)));
    }
    List<String> _caract_2 = this.getCaract();
    int _size_2 = _caract_2.size();
    int _minus = (_size_2 - 1);
    return Collections.<Integer>unmodifiableList(Lists.<Integer>newArrayList(Integer.valueOf(0), Integer.valueOf(_minus)));
  }
  
  public List<String> dame2Pistas() {
    final List<Integer> n = this.dame2Randoms();
    List<String> _caract = this.getCaract();
    Integer _get = n.get(0);
    final String p1 = _caract.get((_get).intValue());
    List<String> _caract_1 = this.getCaract();
    Integer _get_1 = n.get(1);
    final String p2 = _caract_1.get((_get_1).intValue());
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(((((("Caracteristica del pais: " + p1) + "\n") + "Caracteristica del pais: ") + p2) + "\n")));
  }
  
  /**
   * @METODOS DE LA INTERFAZ
   */
  public void agregarCaract(final String caracteristica) {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(caracteristica, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _startsWith = caracteristica.startsWith(" ");
      boolean _not = (!_startsWith);
      _and = _not;
    }
    if (_and) {
      List<String> _caract = this.getCaract();
      _caract.add(caracteristica);
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
  
  public void eliminarCaract(final String caracteristica) {
    List<String> _caract = this.getCaract();
    boolean _contains = _caract.contains(caracteristica);
    if (_contains) {
      List<String> _caract_1 = this.getCaract();
      _caract_1.remove(caracteristica);
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
      int _size = _lugares.size();
      boolean _equals = Integer.valueOf(_size).equals(Integer.valueOf(3));
      _and_1 = _equals;
    }
    if (!_and_1) {
      _and = false;
    } else {
      List<Pais> _conexiones = this.getConexiones();
      boolean _isEmpty_1 = _conexiones.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      _and = _not_1;
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
