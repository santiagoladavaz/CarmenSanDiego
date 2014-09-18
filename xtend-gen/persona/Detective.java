package persona;

import java.util.List;
import org.uqbar.commons.utils.Observable;
import pais.Pais;
import persona.Villano;

@Observable
@SuppressWarnings("all")
public class Detective {
  private Pais _paisActual;
  
  public Pais getPaisActual() {
    return this._paisActual;
  }
  
  public void setPaisActual(final Pais paisActual) {
    this._paisActual = paisActual;
  }
  
  private Villano _ordenDeArresto;
  
  public Villano getOrdenDeArresto() {
    return this._ordenDeArresto;
  }
  
  public void setOrdenDeArresto(final Villano ordenDeArresto) {
    this._ordenDeArresto = ordenDeArresto;
  }
  
  private List<String> _recorridoCriminal;
  
  public List<String> getRecorridoCriminal() {
    return this._recorridoCriminal;
  }
  
  public void setRecorridoCriminal(final List<String> recorridoCriminal) {
    this._recorridoCriminal = recorridoCriminal;
  }
  
  private List<String> _destinosFallidos;
  
  public List<String> getDestinosFallidos() {
    return this._destinosFallidos;
  }
  
  public void setDestinosFallidos(final List<String> destinosFallidos) {
    this._destinosFallidos = destinosFallidos;
  }
}
