package pais

import java.util.List
import persona.Persona
import persona.Villano
import java.io.Serializable

abstract class Lugar  implements Serializable{
	
	@Property protected String nombre
	@Property protected Persona okupa
	
    def abstract void pasoLadron(Villano villano,List<String>pistas)
	
	def ocupanteInforma(){
		_okupa.informar
	}
	
	def void esconderVillano(Villano villano){
		okupa = villano
	}
	
	def avisarEmboscada(){
		okupa.avisarEmboscada
	}
	
}