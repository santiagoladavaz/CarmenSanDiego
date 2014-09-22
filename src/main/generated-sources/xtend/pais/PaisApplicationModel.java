package pais;

import com.google.common.base.Objects;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;
import pais.Lugar;
import pais.Pais;

@Observable
@SuppressWarnings("all")
public class PaisApplicationModel {
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
  
  private Pais _paisModel;
  
  public Pais getPaisModel() {
    return this._paisModel;
  }
  
  public void setPaisModel(final Pais paisModel) {
    this._paisModel = paisModel;
  }
  
  private String _caracteristica;
  
  public String getCaracteristica() {
    return this._caracteristica;
  }
  
  public void setCaracteristica(final String caracteristica) {
    this._caracteristica = caracteristica;
  }
  
  public PaisApplicationModel(final Pais p) {
    this.setPaisModel(p);
  }
  
  public void agregarConexion() {
    Pais _paisElegido = this.getPaisElegido();
    boolean _notEquals = (!Objects.equal(_paisElegido, null));
    if (_notEquals) {
      Pais _paisModel = this.getPaisModel();
      Pais _paisElegido_1 = this.getPaisElegido();
      _paisModel.agregarConexion(_paisElegido_1);
      Pais _paisElegido_2 = this.getPaisElegido();
      Pais _paisModel_1 = this.getPaisModel();
      _paisElegido_2.agregarConexion(_paisModel_1);
      this.setPaisElegido(null);
    } else {
      throw new UserException("Debes seleccionar un pais para agregar");
    }
  }
  
  public void eliminarConexion() {
    final Pais p = this.getPaisElegido();
    boolean _notEquals = (!Objects.equal(p, null));
    if (_notEquals) {
      Pais _paisModel = this.getPaisModel();
      _paisModel.eliminarConexion(p);
      Pais _paisModel_1 = this.getPaisModel();
      p.eliminarConexion(_paisModel_1);
    } else {
      throw new UserException("Debes seleccionar un pais antes de eliminar");
    }
  }
  
  public void agregarLugar() {
    Pais _paisModel = this.getPaisModel();
    Lugar _lugarElegido = this.getLugarElegido();
    _paisModel.agregarLugar(_lugarElegido);
  }
  
  public void eliminarLugar() {
    Lugar _lugarElegido = this.getLugarElegido();
    boolean _notEquals = (!Objects.equal(_lugarElegido, null));
    if (_notEquals) {
      Pais _paisModel = this.getPaisModel();
      Lugar _lugarElegido_1 = this.getLugarElegido();
      _paisModel.eliminarLugar(_lugarElegido_1);
    } else {
      throw new UserException("Debes seleccionar un lugar antes de eliminar");
    }
  }
}
