package persona

import Juego.Juego
import java.util.List
import org.uqbar.commons.utils.Observable
import java.io.Serializable

@Observable
class VillanoApplicationModel implements Serializable {
	
	
	@Property Villano villano	
	@Property String valorAAgregar
	@Property String valorAEliminar
	@Property Juego juego = Juego.getInstance
	
	new(){
		
	}
	new(Villano villano){
		this.villano = villano
	}
	
	def agregarValor(String propertyName,List<String> lista ){
		this.villano.agregarValor(this.valorAAgregar,propertyName,lista)	
		valorAAgregar = null	
	}
	
	def eliminarValor(String propertyName,List<String> lista ){
		villano.eliminarValor(this.valorAEliminar,propertyName,lista)
		
	}
	
}