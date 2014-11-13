package pais

import Juego.Juego
import java.io.Serializable

class LugarApplicationModel  implements Serializable{
	
	@Property 
	Juego juego = Juego.getInstance
	
	@Property
	Lugar lugar
	
	
	new(Lugar l){
		lugar = l
	}
	
	
	def ocupanteInforma(){
		lugar.ocupanteInforma()
	}
		
	
	def setPaisEnLista(){
		if(juego.villano.planDeEscape.contains(juego.detective.paisActual)){
			juego.detective.agregarRecoCriminal
		}else{
			juego.detective.agregarDestinosFallidos
		}
	}
	
	def isGano() {
		juego.gano(lugar)
	}
	
	
}