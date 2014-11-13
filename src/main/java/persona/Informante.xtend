package persona

import java.util.List
import java.io.Serializable

class Informante extends Persona implements Serializable{
	
	@Property List<String> pistas
	
	new(List<String> strings) {
		_pistas = strings
	}
	
	
	override informar() {
		var s = "" 
		for(p:pistas){
			s = s+" "+p
		}
		return s
	}
	
	override avisarEmboscada() {
		_pistas = #["El ladron se encuentra en la ciudad"]
	}
	
}