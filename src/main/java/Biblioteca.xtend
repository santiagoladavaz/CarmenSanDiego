import java.util.ArrayList

class Biblioteca extends Lugar {
	
	new(String nom){
		_nombre = nom
		_okupa = new Cuidador

	}
	

	override pasoLadron(Villano villano) {
		var pistas = dameLasPistas(villano)
		_okupa = new Informante(pistas);
	}
	
	def dameLasPistas(Villano villano){
		val list = new ArrayList<String>()
		list+=villano.señas.get(0)
		list+=villano.señas.get(1)
		list+=villano.hobbie.get(0)
		return list
	}
	
}