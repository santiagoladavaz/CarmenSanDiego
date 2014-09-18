package persona;

import Juego.Juego;
import org.uqbar.commons.utils.Observable;
import pais.Pais;
import persona.Detective;

@Observable
@SuppressWarnings("all")
public class DetectiveApplicationModel {
  private Juego _juego = Juego.getInstance();
  
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
  
  public DetectiveApplicationModel() {
  }
  
  public void setNuevoDestino() {
    Juego _juego = this.getJuego();
    Detective _detective = _juego.getDetective();
    Pais _nuevoDestino = this.getNuevoDestino();
    _detective.setPaisActual(_nuevoDestino);
  }
}
