package persona;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;
import pais.Lugar;
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
    this.setPaisAnterior(_paisActual);
    this._paisActual = p;
    List<Lugar> _lugares = p.getLugares();
    Lugar _get = _lugares.get(0);
    p.setPrimerLugar(_get);
    List<Lugar> _lugares_1 = p.getLugares();
    Lugar _get_1 = _lugares_1.get(1);
    p.setSegundoLugar(_get_1);
    List<Lugar> _lugares_2 = p.getLugares();
    Lugar _get_2 = _lugares_2.get(2);
    p.setTercerLugar(_get_2);
    Pais _paisActual_1 = this.getPaisActual();
    ObservableUtils.firePropertyChanged(this, "paisActual", _paisActual_1);
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
  
  public void agregarRecoCriminal() {
    List<String> _recorridoCriminal = this.getRecorridoCriminal();
    Pais _paisActual = this.getPaisActual();
    String _nombre = _paisActual.getNombre();
    boolean _contains = _recorridoCriminal.contains(_nombre);
    boolean _not = (!_contains);
    if (_not) {
      List<String> _recorridoCriminal_1 = this.getRecorridoCriminal();
      Pais _paisActual_1 = this.getPaisActual();
      String _nombre_1 = _paisActual_1.getNombre();
      _recorridoCriminal_1.add(_nombre_1);
      List<String> _recorridoCriminal_2 = this.getRecorridoCriminal();
      ObservableUtils.firePropertyChanged(this, "recorridoCriminal", _recorridoCriminal_2);
    }
  }
  
  public void agregarDestinosFallidos() {
    List<String> _destinosFallidos = this.getDestinosFallidos();
    Pais _paisActual = this.getPaisActual();
    String _nombre = _paisActual.getNombre();
    boolean _contains = _destinosFallidos.contains(_nombre);
    boolean _not = (!_contains);
    if (_not) {
      List<String> _destinosFallidos_1 = this.getDestinosFallidos();
      Pais _paisActual_1 = this.getPaisActual();
      String _nombre_1 = _paisActual_1.getNombre();
      _destinosFallidos_1.add(_nombre_1);
      List<String> _destinosFallidos_2 = this.getDestinosFallidos();
      ObservableUtils.firePropertyChanged(this, "destinosFallidos", _destinosFallidos_2);
    }
  }
}
