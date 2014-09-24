package Juego

import org.uqbar.commons.utils.Observable
import pais.Pais

@Observable
class JuegoAppModel {
	
	@Property
	Juego juego = Juego.getInstance()
	
	@Property
	Pais paisSeleccionado
	
	def eliminarPais() {
		juego.eliminarPais(this.paisSeleccionado)
	}
	
}