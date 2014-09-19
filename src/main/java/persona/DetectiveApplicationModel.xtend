package persona

import Juego.Juego
import pais.Pais
import org.uqbar.commons.utils.Observable

@Observable
class DetectiveApplicationModel {
	
	@Property
	Juego juego = Juego.getInstance
	
	@Property
	Pais nuevoDestino 
	
	
	new(){}
	
	def setNuevoDestino(){
		juego.detective.setPaisActual(nuevoDestino)
		
	}
	
}