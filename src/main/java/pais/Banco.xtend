package pais

import java.util.List
import persona.Cuidador
import persona.Villano
import persona.Informante

class Banco extends Lugar {
	
	new(){
		_nombre = "Banco"
		_okupa = new Cuidador()
	}
	
	override pasoLadron(Villano villano, List<String> pistas) {
		okupa = new Informante(pistas)
	}
	

}