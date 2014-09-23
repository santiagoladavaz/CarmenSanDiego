package Juego

import pais.Pais
import persona.Villano
import org.uqbar.commons.utils.Observable

@Observable
class JuegoAppModel {
	
	@Property
	Juego juego = Juego.getInstance()
	
	@Property
	Pais paisSeleccionado
	
	@Property
	Villano expedienteSeleccionado
	
	def eliminarPais() {
			juego.eliminarPais(this.paisSeleccionado)
	}
	
	
}