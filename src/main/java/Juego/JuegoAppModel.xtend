package Juego

import org.uqbar.commons.utils.Observable
import pais.Pais
import java.io.Serializable
import persona.Villano

@Observable
class JuegoAppModel implements Serializable {
	
	@Property
	Juego juego = Juego.getInstance()
	
	@Property
	Pais paisSeleccionado
	
	@Property
	Villano villanoSeleccionado
	
	def eliminarPais() {
		juego.eliminarPais(this.paisSeleccionado)
	}
	
	def eliminarVillano() {
		juego.eliminarVillano(this.villanoSeleccionado)
	}
	
}