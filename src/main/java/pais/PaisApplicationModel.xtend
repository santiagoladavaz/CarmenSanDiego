package pais

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.UserException

@Observable
class PaisApplicationModel {
	
	@Property Pais paisElegido
	@Property Lugar lugarElegido
	@Property Pais paisModel
	@Property String caracteristica // por el momento no se usa, despues se tiene que usar esta y borrarla de la clase
									// pais
	
	
	new (Pais p){
		paisModel = p
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
}
