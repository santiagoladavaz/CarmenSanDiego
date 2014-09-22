package pais

import java.util.List
import persona.Cuidador
import persona.Informante
import persona.Villano

class Biblioteca extends Lugar {
	
	new(){
		_nombre = "Biblioteca"
		_okupa = new Cuidador

	}

	
	override pasoLadron(Villano villano, List<String> pistas) {
		val x = villano.dameLasPistas
	    for (p:pistas){
	    	x.add(p)
	    }
		okupa= new Informante(x)
	}
	

	
}