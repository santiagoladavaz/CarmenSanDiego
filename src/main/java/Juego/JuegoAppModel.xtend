package Juego

import pais.Pais
import persona.Villano

class JuegoAppModel {
	@Property
	Juego juego
	
	@Property
	Pais paisSeleccionado
	
	@Property
	Villano expedienteSeleccionado
	
	def eliminarPais() {
			juego.eliminarPais(this.paisSeleccionado)
	}
	
	
}