package Juego;

import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Caso {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private String _descripcion;
  
  public String getDescripcion() {
    return this._descripcion;
  }
  
  public void setDescripcion(final String descripcion) {
    this._descripcion = descripcion;
  }
  
  public Caso(final String nomb, final String desc, final String nombrePais, final String desc2) {
    this.setNombre(nomb);
    this.setDescripcion(((desc + nombrePais) + desc2));
  }
}
