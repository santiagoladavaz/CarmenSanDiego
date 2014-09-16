package pais;

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
    Pais _paisModel = this.getPaisModel();
    Pais _paisElegido = this.getPaisElegido();
    _paisModel.agregarConexion(_paisElegido);
  }
  
  public void eliminarConexion() {
    Pais _paisModel = this.getPaisModel();
    Pais _paisElegido = this.getPaisElegido();
    _paisModel.eliminarConexion(_paisElegido);
  }
  
  public void agregarLugar() {
    Pais _paisModel = this.getPaisModel();
    Lugar _lugarElegido = this.getLugarElegido();
    _paisModel.agregarLugar(_lugarElegido);
  }
  
  public void eliminarLugar() {
    Pais _paisModel = this.getPaisModel();
    Lugar _lugarElegido = this.getLugarElegido();
    _paisModel.eliminarLugar(_lugarElegido);
  }
}
