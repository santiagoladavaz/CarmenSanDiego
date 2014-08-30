import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("all")
public class Pais {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private List<String> _caract;
  
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
  
  public void visitar(final Villano villano) {
    List<Lugar> _lugares = this.getLugares();
    final Consumer<Lugar> _function = new Consumer<Lugar>() {
      public void accept(final Lugar it) {
        it.pasoLadron(villano);
      }
    };
    _lugares.forEach(_function);
  }
}
