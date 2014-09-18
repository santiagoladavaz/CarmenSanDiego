package pais

import persona.Cuidador
import persona.Villano
import java.util.List
import persona.Informante

class Embajada extends Lugar {
	
	new(){
		_nombre = "Embajada"
		_okupa = new Cuidador()

	}
	
	override pasoLadron(Villano villano, List<String> pistas) {
		okupa = new Informante(pistas)
	}


	
}