package pais

import persona.Cuidador
import persona.Villano
import java.util.List
import persona.Informante
import java.io.Serializable

class Embajada extends Lugar implements Serializable {
	
	new(){
		_nombre = "Embajada"
		_okupa = new Cuidador()

	}
	
	override pasoLadron(Villano villano, List<String> pistas) {
		okupa = new Informante(pistas)
	}


	
}