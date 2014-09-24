package persona

import Juego.Juego
import pais.Pais
import org.uqbar.commons.utils.Observable

@Observable
class ViajarApplicationModel {

	@Property
	Juego juego

	@Property
	Pais nuevoDestino

	new(Juego j) {
		_juego = j
	}

	def viajar() {
		juego.detective.setPaisActual(nuevoDestino)
	}

	def volver() {
		juego.detective.volver
	}

}
