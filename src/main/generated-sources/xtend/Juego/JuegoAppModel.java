package Juego;

import Juego.Juego;
import org.uqbar.commons.utils.Observable;
import pais.Pais;
import persona.Villano;

@Observable
@SuppressWarnings("all")
public class JuegoAppModel {
  private Juego _juego = Juego.getInstance();
  
  public Juego getJuego() {
    return this._juego;
  }
  
  public void setJuego(final Juego juego) {
    this._juego = juego;
  }
  
  private Pais _paisSeleccionado;
  
  public Pais getPaisSeleccionado() {
    return this._paisSeleccionado;
  }
  
  public void setPaisSeleccionado(final Pais paisSeleccionado) {
    this._paisSeleccionado = paisSeleccionado;
  }
  
  private Villano _expedienteSeleccionado;
  
  public Villano getExpedienteSeleccionado() {
    return this._expedienteSeleccionado;
  }
  
  public void setExpedienteSeleccionado(final Villano expedienteSeleccionado) {
    this._expedienteSeleccionado = expedienteSeleccionado;
  }
  
  public boolean eliminarPais() {
    Juego _juego = this.getJuego();
    Pais _paisSeleccionado = this.getPaisSeleccionado();
    return _juego.eliminarPais(_paisSeleccionado);
  }
}
