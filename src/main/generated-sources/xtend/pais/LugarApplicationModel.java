package pais;

import Juego.Juego;
import java.util.List;
import pais.Lugar;
import pais.Pais;
import persona.Detective;
import persona.Villano;

@SuppressWarnings("all")
public class LugarApplicationModel {
  private Juego _juego = Juego.getInstance();
  
  public Juego getJuego() {
    return this._juego;
  }
  
  public void setJuego(final Juego juego) {
    this._juego = juego;
  }
  
  private Lugar _lugar;
  
  public Lugar getLugar() {
    return this._lugar;
  }
  
  public void setLugar(final Lugar lugar) {
    this._lugar = lugar;
  }
  
  public LugarApplicationModel(final Lugar l) {
    this.setLugar(l);
  }
  
  public String ocupanteInforma() {
    Lugar _lugar = this.getLugar();
    return _lugar.ocupanteInforma();
  }
  
  public void setPaisEnLista() {
    Juego _juego = this.getJuego();
    Villano _villano = _juego.getVillano();
    List<Pais> _planDeEscape = _villano.getPlanDeEscape();
    Juego _juego_1 = this.getJuego();
    Detective _detective = _juego_1.getDetective();
    Pais _paisActual = _detective.getPaisActual();
    boolean _contains = _planDeEscape.contains(_paisActual);
    if (_contains) {
      Juego _juego_2 = this.getJuego();
      Detective _detective_1 = _juego_2.getDetective();
      _detective_1.agregarRecoCriminal();
    } else {
      Juego _juego_3 = this.getJuego();
      Detective _detective_2 = _juego_3.getDetective();
      _detective_2.agregarDestinosFallidos();
    }
  }
  
  public boolean isGano() {
    Juego _juego = this.getJuego();
    Lugar _lugar = this.getLugar();
    return _juego.gano(_lugar);
  }
}
