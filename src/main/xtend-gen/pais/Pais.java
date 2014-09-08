package pais;

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
  
  private Pais _PaisElegido;
  
  public Pais getPaisElegido() {
    return this._PaisElegido;
  }
  
  public void setPaisElegido(final Pais PaisElegido) {
    this._PaisElegido = PaisElegido;
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
    List<String> _caract = this.getCaract();
    _caract.add(c);
    List<String> _caract_1 = this.getCaract();
    ObservableUtils.firePropertyChanged(this, "caract", _caract_1);
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
  
  public void agregarConexion(final Pais p) {
    List<Pais> _conexiones = this.getConexiones();
    _conexiones.add(p);
    List<Pais> _conexiones_1 = this.getConexiones();
    ObservableUtils.firePropertyChanged(this, "conexiones", _conexiones_1);
  }
  
  public String toString() {
    return this.getNombre();
  }
}
