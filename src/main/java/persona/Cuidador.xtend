package persona


class Cuidador extends Persona {
	
	String dialogo = "El ladron no paso por aqui"
	
	override informar() {
		return dialogo
	}
	
	override avisarEmboscada() {
		dialogo = "Ten cuidado! El ladron esta en la ciudad"
	}
	
}