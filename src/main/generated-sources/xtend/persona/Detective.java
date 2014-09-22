package persona;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
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
  
  private Pais _paisAnterior = null;
  
  public Pais getPaisAnterior() {
    return this._paisAnterior;
  }
  
  public void setPaisAnterior(final Pais paisAnterior) {
    this._paisAnterior = paisAnterior;
  }
  
  private Villano _ordenDeArresto;
  
  public Villano getOrdenDeArresto() {
    return this._ordenDeArresto;
  }
  
  public void setOrdenDeArresto(final Villano ordenDeArresto) {
    this._ordenDeArresto = ordenDeArresto;
  }
  
  private List<String> _recorridoCriminal = CollectionLiterals.<String>newArrayList();
  
  public List<String> getRecorridoCriminal() {
    return this._recorridoCriminal;
  }
  
  public void setRecorridoCriminal(final List<String> recorridoCriminal) {
    this._recorridoCriminal = recorridoCriminal;
  }
  
  private List<String> _destinosFallidos = CollectionLiterals.<String>newArrayList();
  
  public List<String> getDestinosFallidos() {
    return this._destinosFallidos;
  }
  
  public void setDestinosFallidos(final List<String> destinosFallidos) {
    this._destinosFallidos = destinosFallidos;
  }
  
  public void setPaisActual(final Pais p) {
    Pais _paisActual = this.getPaisActual();
    this._paisAnterior = _paisActual;
    this._paisActual = p;
    String _nombre = p.getNombre();
    this._recorridoCriminal.add(_nombre);
    Pais _paisActual_1 = this.getPaisActual();
    ObservableUtils.firePropertyChanged(this, "paisActual", _paisActual_1);
    List<String> _recorridoCriminal = this.getRecorridoCriminal();
    ObservableUtils.firePropertyChanged(this, "recorridoCriminal", _recorridoCriminal);
  }
  
  public void volver() {
    Pais _paisAnterior = this.getPaisAnterior();
    boolean _notEquals = (!Objects.equal(_paisAnterior, null));
    if (_notEquals) {
      Pais _paisAnterior_1 = this.getPaisAnterior();
      this.setPaisActual(_paisAnterior_1);
    } else {
      throw new UserException("Es el primer pais que visita !");
    }
  }
}
