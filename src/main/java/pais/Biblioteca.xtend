package pais
import java.util.ArrayList
import persona.Cuidador
import persona.Villano
import java.util.List
import persona.Informante

class Biblioteca extends Lugar {
	
	new(String nom){
		_nombre = nom
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