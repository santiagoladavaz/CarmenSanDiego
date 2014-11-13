package Juego

import org.uqbar.commons.utils.Observable
import pais.Pais
import java.io.Serializable

@Observable
class JuegoAppModel implements Serializable {
	
	@Property
	Juego juego = Juego.getInstance()
	
	@Property
	Pais paisSeleccionado
	
	def eliminarPais() {
		juego.eliminarPais(this.paisSeleccionado)
	}
	
}