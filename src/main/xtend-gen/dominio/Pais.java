package dominio;

import dominio.Lugar;
import dominio.Villano;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

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
  
  private List<String> _conexiones;
  
  public List<String> getConexiones() {
    return this._conexiones;
  }
  
  public void setConexiones(final List<String> conexiones) {
    this._conexiones = conexiones;
  }
  
  private List<Lugar> _lugares;
  
  public List<Lugar> getLugares() {
    return this._lugares;
  }
  
  public void setLugares(final List<Lugar> lugares) {
    this._lugares = lugares;
  }
  
  private String _caractAAgregar;
  
  public String getCaractAAgregar() {
    return this._caractAAgregar;
  }
  
  public void setCaractAAgregar(final String caractAAgregar) {
    this._caractAAgregar = caractAAgregar;
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
    _caract.remove(c);
  }
}
