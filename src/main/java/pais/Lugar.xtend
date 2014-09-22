package pais
import java.util.List
import persona.Persona
import persona.Villano
import org.uqbar.commons.utils.Observable


abstract class Lugar {
	
	@Property protected String nombre
	@Property protected Persona okupa
	
    def abstract void pasoLadron(Villano villano,List<String>pistas)
	
	override toString(){
		return nombre
	}
	
	def ocupanteInforma(){
		_okupa.informar()
	}
	
	def void esconderVillano(Villano villano){
		okupa = villano
	}
	

	
}