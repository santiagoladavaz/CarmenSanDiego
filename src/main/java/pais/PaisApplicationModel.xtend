package pais

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.UserException
import java.io.Serializable

@Observable
class PaisApplicationModel  implements Serializable{
	
	@Property Pais paisElegido
	@Property Lugar lugarElegido
	@Property Pais paisModel
	@Property Caracteristica caracteristicaAAgregar
	@Property Caracteristica caracteristicaAEliminar
	
	new (Pais p){
		paisModel = p
	}
	
	new(){
		
	}
	
	def agregarConexion(){
		if (paisElegido != null){
			paisModel.agregarConexion(paisElegido)
			paisElegido.agregarConexion(paisModel)
			paisElegido = null
		}else
			throw new UserException("Debes seleccionar un pais para agregar")
	}
	
	def eliminarConexion(){
		val p = paisElegido
		if (p != null){
			paisModel.eliminarConexion(p)
			p.eliminarConexion(paisModel)
		}else
			throw new UserException ("Debes seleccionar un pais antes de eliminar")
	}
	
	def agregarLugar(){
		paisModel.agregarLugar(lugarElegido)
	}
	
	
	
	def eliminarLugar(){
		if (lugarElegido != null){
			paisModel.eliminarLugar(lugarElegido)
		}
		else
			throw new UserException("Debes seleccionar un lugar antes de eliminar")
	}
	
	
	
	def agregarCaract(){
		if(caracteristicaAAgregar != null){
			paisModel.agregarCaract(caracteristicaAAgregar)
			caracteristicaAAgregar = null
		}
	}
	
	def eliminarCaract(){
		if(caracteristicaAEliminar != null){
			paisModel.eliminarCaract(caracteristicaAEliminar)
		}
	}



}
