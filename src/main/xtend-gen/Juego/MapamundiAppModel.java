package Juego;

import pais.Pais;

@SuppressWarnings("all")
public class MapamundiAppModel {
  private Pais _paisSeleccionado;
  
  public Pais getPaisSeleccionado() {
    return this._paisSeleccionado;
  }
  
  public void setPaisSeleccionado(final Pais paisSeleccionado) {
    this._paisSeleccionado = paisSeleccionado;
  }
  
  public Object eliminarPais() {
    return null;
  }
}
