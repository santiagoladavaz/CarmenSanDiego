package persona

import java.io.Serializable

class Cuidador extends Persona  implements Serializable{
	
	@Property String dialogo = "El ladron no paso por aqui"
	
	override informar() {
		return dialogo
	}
	
	override avisarEmboscada() {
		dialogo = "Ten cuidado! El ladron esta en la ciudad"
	}
	
}