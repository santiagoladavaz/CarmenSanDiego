

import java.util.List

class Pais {
	
	@Property String nombre
	@Property List<String> caract
	@Property List<String> conexiones
	@Property List<Lugar> lugares
	
	
	def void visitar(Villano villano){
		lugares.forEach[pasoLadron(villano)]
	}
	
	
	
	
	
}