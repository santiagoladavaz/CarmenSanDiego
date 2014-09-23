package pais

import Juego.Juego


class LugarApplicationModel {
	
	@Property 
	Juego juego = Juego.getInstance
	
	@Property
	Lugar lugar
	
	
	new(Lugar l){
		lugar = l
	}
	
	
	def ocupanteInforma(){
		lugar.ocupanteInforma
	}
		
	
	def setPaisEnLista(){
		if(juego.villano.planDeEscape.contains(juego.detective.paisActual)){
			juego.detective.agregarRecoCriminal
		}else{
			juego.detective.agregarDestinosFallidos
		}
	}
	
	
}