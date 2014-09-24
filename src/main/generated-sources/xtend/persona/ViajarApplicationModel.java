package persona;

import Juego.Juego;
import org.uqbar.commons.utils.Observable;
import pais.Pais;
import persona.Detective;

@Observable
@SuppressWarnings("all")
public class ViajarApplicationModel {
  private Juego _juego;
  
  public Juego getJuego() {
    return this._juego;
  }
  
  public void setJuego(final Juego juego) {
    this._juego = juego;
  }
  
  private Pais _nuevoDestino;
  
  public Pais getNuevoDestino() {
    return this._nuevoDestino;
  }
  
  public void setNuevoDestino(final Pais nuevoDestino) {
    this._nuevoDestino = nuevoDestino;
  }
  
  public ViajarApplicationModel(final Juego j) {
    this._juego = j;
  }
  
  public void viajar() {
    Juego _juego = this.getJuego();
    Detective _detective = _juego.getDetective();
    Pais _nuevoDestino = this.getNuevoDestino();
    _detective.setPaisActual(_nuevoDestino);
  }
  
  public void volver() {
    Juego _juego = this.getJuego();
    Detective _detective = _juego.getDetective();
    _detective.volver();
  }
}
