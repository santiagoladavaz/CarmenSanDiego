import java.util.ArrayList

class Embajada extends Lugar {
	
	new(String nom){
		_nombre = nom
		_okupa = new Cuidador()

	}
	
	override pasoLadron(Villano villano) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}