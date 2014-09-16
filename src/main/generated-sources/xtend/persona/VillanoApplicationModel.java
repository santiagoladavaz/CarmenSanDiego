package persona;

import java.util.List;
import org.uqbar.commons.utils.Observable;
import persona.Villano;

@Observable
@SuppressWarnings("all")
public class VillanoApplicationModel {
  private Villano _villano;
  
  public Villano getVillano() {
    return this._villano;
  }
  
  public void setVillano(final Villano villano) {
    this._villano = villano;
  }
  
  private String _valorAAgregar;
  
  public String getValorAAgregar() {
    return this._valorAAgregar;
  }
  
  public void setValorAAgregar(final String valorAAgregar) {
    this._valorAAgregar = valorAAgregar;
  }
  
  private String _valorAEliminar;
  
  public String getValorAEliminar() {
    return this._valorAEliminar;
  }
  
  public void setValorAEliminar(final String valorAEliminar) {
    this._valorAEliminar = valorAEliminar;
  }
  
  public VillanoApplicationModel(final Villano villano) {
    this.setVillano(villano);
  }
  
  public void agregarValor(final String propertyName, final List<String> lista) {
    Villano _villano = this.getVillano();
    String _valorAAgregar = this.getValorAAgregar();
    _villano.agregarValor(_valorAAgregar, propertyName, lista);
  }
  
  public void eliminarValor(final String propertyName, final List<String> lista) {
    Villano _villano = this.getVillano();
    String _valorAEliminar = this.getValorAEliminar();
    _villano.eliminarValor(_valorAEliminar, propertyName, lista);
  }
}
