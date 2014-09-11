package persona

import java.util.List
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.ObservableUtils

@Observable
class VillanoApplicationModel {
	
	
	@Property 
	Villano villano
	
	@Property 
	String valorAAgregar
	
	@Property 
	String valorAEliminar
	
	
	new(Villano villano){
		this.villano = villano
	}
	
	def agregarValor(String propertyName,List<String> lista ){
		this.villano.agregarValor(this.valorAAgregar,propertyName,lista)
		this.valorAAgregar = null
		
		
	}
	
	def eliminarValor(String propertyName,List<String> lista ){
		this.villano.eliminarValor(this.valorAEliminar,propertyName,lista)
		
	}
	
}