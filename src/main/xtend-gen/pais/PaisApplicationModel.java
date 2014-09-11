package pais;

import pais.Lugar;
import pais.Pais;

@SuppressWarnings("all")
public class PaisApplicationModel {
  private Pais _paisElegido;
  
  public Pais getPaisElegido() {
    return this._paisElegido;
  }
  
  public void setPaisElegido(final Pais paisElegido) {
    this._paisElegido = paisElegido;
  }
  
  private Pais _paisAEliminar;
  
  public Pais getPaisAEliminar() {
    return this._paisAEliminar;
  }
  
  public void setPaisAEliminar(final Pais paisAEliminar) {
    this._paisAEliminar = paisAEliminar;
  }
  
  private Lugar _lugarElegido;
  
  public Lugar getLugarElegido() {
    return this._lugarElegido;
  }
  
  public void setLugarElegido(final Lugar lugarElegido) {
    this._lugarElegido = lugarElegido;
  }
  
  private Lugar _lugarAEliminar;
  
  public Lugar getLugarAEliminar() {
    return this._lugarAEliminar;
  }
  
  public void setLugarAEliminar(final Lugar lugarAEliminar) {
    this._lugarAEliminar = lugarAEliminar;
  }
  
  private String _caractElegida;
  
  public String getCaractElegida() {
    return this._caractElegida;
  }
  
  public void setCaractElegida(final String caractElegida) {
    this._caractElegida = caractElegida;
  }
  
  private String _caractAEliminar;
  
  public String getCaractAEliminar() {
    return this._caractAEliminar;
  }
  
  public void setCaractAEliminar(final String caractAEliminar) {
    this._caractAEliminar = caractAEliminar;
  }
}
