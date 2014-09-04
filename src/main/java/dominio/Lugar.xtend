package dominio
import java.util.List

abstract class Lugar {
	
	@Property protected String nombre
	@Property protected Persona okupa
	
	def pasoLadron(Villano villano) {
		var pistas = villano.dameLasPistas
//		_okupa = new Informante(pistas);
	}
	
	def ocupanteInforma(){
		_okupa.informar()
	}
	
	
	def abstract List<String> dameLasPistas(Villano villano)
	
}