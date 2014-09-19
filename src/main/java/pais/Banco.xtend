package pais

import java.util.List
import persona.Cuidador
import persona.Villano

class Banco extends Lugar {
	
	new(){
		_nombre = "Banco"
		_okupa = new Cuidador()
	}

	
	override pasoLadron(Villano villano, List<String> pistas) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	

}