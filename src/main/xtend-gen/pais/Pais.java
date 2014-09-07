package pais;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
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
  
  private List<String> _conexiones = new ArrayList<String>();
  
  public List<String> getConexiones() {
    return this._conexiones;
  }
  
  public void setConexiones(final List<String> conexiones) {
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
  
  public void visitar(final Villano villano) {
    List<Lugar> _lugares = this.getLugares();
    final Consumer<Lugar> _function = new Consumer<Lugar>() {
      public void accept(final Lugar it) {
        it.pasoLadron(villano);
      }
    };
    _lugares.forEach(_function);
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
}
