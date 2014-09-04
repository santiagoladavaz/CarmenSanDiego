package pais
import java.util.ArrayList
import persona.Cuidador
import persona.Villano

class Biblioteca extends Lugar {
	
	new(String nom){
		_nombre = nom
		_okupa = new Cuidador

	}
	
	override dameLasPistas(Villano villano){
		val list = new ArrayList<String>()
		list+=villano.señas.get(0)
		// Da una pista sobre el proximo destino
		// 50% da una pista de Hobbie -> list+=villano.hobbie.get(0)
		return list
	}
	
}