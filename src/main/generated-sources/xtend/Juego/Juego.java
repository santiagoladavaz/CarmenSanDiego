package Juego;

import Juego.Caso;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;
import pais.Banco;
import pais.Lugar;
import pais.Pais;
import persona.Detective;
import persona.Villano;

@Observable
@SuppressWarnings("all")
public class Juego {
  private static Juego JUEGO = new Juego();
  
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
  
  private List<Villano> _villanos = new ArrayList<Villano>();
  
  public List<Villano> getVillanos() {
    return this._villanos;
  }
  
  public void setVillanos(final List<Villano> villanos) {
    this._villanos = villanos;
  }
  
  private List<Caso> _casos = new ArrayList<Caso>();
  
  public List<Caso> getCasos() {
    return this._casos;
  }
  
  public void setCasos(final List<Caso> casos) {
    this._casos = casos;
  }
  
  private Caso _casoSeleccionado;
  
  public Caso getCasoSeleccionado() {
    return this._casoSeleccionado;
  }
  
  public void setCasoSeleccionado(final Caso casoSeleccionado) {
    this._casoSeleccionado = casoSeleccionado;
  }
  
  private Detective _detective;
  
  public Detective getDetective() {
    return this._detective;
  }
  
  public void setDetective(final Detective detective) {
    this._detective = detective;
  }
  
  public static Juego getInstance() {
    return Juego.JUEGO;
  }
  
  public Juego() {
    List<Pais> _conexiones = this.getConexiones();
    final Procedure1<List<Pais>> _function = new Procedure1<List<Pais>>() {
      public void apply(final List<Pais> it) {
        Pais _pais = new Pais("Argentina");
        it.add(_pais);
        Pais _pais_1 = new Pais("Brasil");
        it.add(_pais_1);
        Pais _pais_2 = new Pais("Uruguay");
        it.add(_pais_2);
      }
    };
    ObjectExtensions.<List<Pais>>operator_doubleArrow(_conexiones, _function);
    List<Lugar> _lugares = this.getLugares();
    final Procedure1<List<Lugar>> _function_1 = new Procedure1<List<Lugar>>() {
      public void apply(final List<Lugar> it) {
        Banco _banco = new Banco("BANCO - Provincia");
        it.add(_banco);
        Banco _banco_1 = new Banco("BIBLIOTECA - Quilmes");
        it.add(_banco_1);
      }
    };
    ObjectExtensions.<List<Lugar>>operator_doubleArrow(_lugares, _function_1);
    final ArrayList<String> hobbies1 = CollectionLiterals.<String>newArrayList("Jugar tenis", "Pintar Cuadros");
    final ArrayList<String> señas1 = CollectionLiterals.<String>newArrayList("Alta", "Flaca");
    final ArrayList<String> hobbies2 = CollectionLiterals.<String>newArrayList("comer pizza", "extorsionar");
    final ArrayList<String> señas2 = CollectionLiterals.<String>newArrayList("barrigon", "pelado");
    List<Villano> _villanos = this.getVillanos();
    final Procedure1<List<Villano>> _function_2 = new Procedure1<List<Villano>>() {
      public void apply(final List<Villano> it) {
        Villano _villano = new Villano("Bonnie", "Femenino", hobbies1, señas1, Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList()));
        it.add(_villano);
        Villano _villano_1 = new Villano("Al Capone", "Masculino", hobbies2, señas2, Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList()));
        it.add(_villano_1);
      }
    };
    ObjectExtensions.<List<Villano>>operator_doubleArrow(_villanos, _function_2);
    List<Caso> _casos = this.getCasos();
    final Procedure1<List<Caso>> _function_3 = new Procedure1<List<Caso>>() {
      public void apply(final List<Caso> it) {
        Caso _caso = new Caso("Robo del trillon", "Se robaron un trillon de dolares");
        it.add(_caso);
        Caso _caso_1 = new Caso("Robo al rey de copas - INDEPENDIENTE", "Se robaron la libertadores");
        it.add(_caso_1);
      }
    };
    ObjectExtensions.<List<Caso>>operator_doubleArrow(_casos, _function_3);
    this.seleccionarCaso();
    Detective _detective = new Detective();
    this.setDetective(_detective);
    Detective _detective_1 = this.getDetective();
    List<Pais> _conexiones_1 = this.getConexiones();
    Pais _get = _conexiones_1.get(0);
    _detective_1.setPaisActual(_get);
  }
  
  public Pais buscarPais(final Pais string) {
    Pais _xblockexpression = null;
    {
      InputOutput.<Pais>print(string);
      List<Pais> _conexiones = this.getConexiones();
      final Function1<Pais, Boolean> _function = new Function1<Pais, Boolean>() {
        public Boolean apply(final Pais p) {
          String _nombre = p.getNombre();
          String _nombre_1 = string.getNombre();
          return Boolean.valueOf(Objects.equal(_nombre, _nombre_1));
        }
      };
      Iterable<Pais> _filter = IterableExtensions.<Pais>filter(_conexiones, _function);
      _xblockexpression = ((Pais[])Conversions.unwrapArray(_filter, Pais.class))[0];
    }
    return _xblockexpression;
  }
  
  public void eliminarPais(final Pais pais) {
    List<Pais> _conexiones = this.getConexiones();
    boolean _contains = _conexiones.contains(pais);
    if (_contains) {
      List<Pais> _conexiones_1 = this.getConexiones();
      _conexiones_1.remove(pais);
      List<Pais> _conexiones_2 = this.getConexiones();
      ObservableUtils.firePropertyChanged(this, "conexiones", _conexiones_2);
    }
  }
  
  public void agregarPais(final Pais pais) {
    List<Pais> _conexiones = this.getConexiones();
    _conexiones.add(pais);
    List<Pais> _conexiones_1 = this.getConexiones();
    ObservableUtils.firePropertyChanged(this, "conexiones", _conexiones_1);
  }
  
  public void agregarVillano(final Villano villano) {
    List<Villano> _villanos = this.getVillanos();
    _villanos.add(villano);
    List<Villano> _villanos_1 = this.getVillanos();
    ObservableUtils.firePropertyChanged(this, "villanos", _villanos_1);
  }
  
  public void seleccionarCaso() {
    double _random = Math.random();
    List<Caso> _casos = this.getCasos();
    int _size = _casos.size();
    double _multiply = (_random * _size);
    final int x = ((int) _multiply);
    List<Caso> _casos_1 = this.getCasos();
    Caso _get = _casos_1.get(x);
    this.setCasoSeleccionado(_get);
  }
}
