package pais 
import java.util.ArrayList
import persona.Cuidador
import persona.Villano

class Banco extends Lugar {
	
	new(String nom){
		_nombre = nom
		_okupa = new Cuidador()
	}

	
	
	override dameLasPistas(Villano villano){
		val pistas = new ArrayList<String>()
		pistas+=villano.señas.get(0)
		//Dar pista sobre el proximo pais a visitar
		return pistas
	}
	

}