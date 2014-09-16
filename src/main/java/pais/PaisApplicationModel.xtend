package pais

import org.uqbar.commons.utils.Observable

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
		paisModel.agregarConexion(paisElegido)
	}
	
	def eliminarConexion(){
		paisModel.eliminarConexion(paisElegido)
	}
	
	def agregarLugar(){
		paisModel.agregarLugar(lugarElegido)
	}
	
	def eliminarLugar(){
		paisModel.eliminarLugar(lugarElegido)
	}
}