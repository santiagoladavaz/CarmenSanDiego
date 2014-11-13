package persona

import java.io.Serializable

abstract class Persona implements Serializable{
	
	
	def abstract String informar()
	
	def abstract void avisarEmboscada()
	
	
}