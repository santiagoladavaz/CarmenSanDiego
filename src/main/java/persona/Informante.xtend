package persona

import java.util.List

class Informante extends Persona {
	
	@Property List<String> pistas
	
	new(List<String> strings) {
		_pistas = strings
	}
	
	
	override informar() {
		var s = "" 
		for(p:pistas){
			s = s+" , "+p
		}
		return s
	}
	
}