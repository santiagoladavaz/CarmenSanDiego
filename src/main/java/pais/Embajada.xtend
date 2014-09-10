package pais

import persona.Cuidador
import persona.Villano

class Embajada extends Lugar {
	
	new(String nom){
		_nombre = nom
		_okupa = new Cuidador()

	}
	

	override dameLasPistas(Villano villano) {
		//Dar 2 pistas sobre el proximo destino
		// prueba para que vea marcos
	}

	
}