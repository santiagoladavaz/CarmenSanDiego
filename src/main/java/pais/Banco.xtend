package pais 
import java.util.ArrayList
import persona.Cuidador
import persona.Villano
import java.util.List

class Banco extends Lugar {
	
	new(String nom){
		_nombre = nom
		_okupa = new Cuidador()
	}

	

	
	override toString(){
		return nombre
	}
	
	override pasoLadron(Villano villano, List<String> pistas) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	

}