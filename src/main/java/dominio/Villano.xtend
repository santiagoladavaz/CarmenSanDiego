package dominio
import java.util.List
import org.uqbar.commons.utils.Observable

@Observable
class Villano {
	
	@Property String nombre
	@Property String sexo
	@Property List<String> hobbie
	@Property List<String> señas
	@Property List<Pais> planDeEscape; 

	new (){
		
		
	}
	
	new (String n, String s, List<String> h, List<String> señas,List<Pais>planDeEscape){
		_nombre = n
		_sexo = s
		_hobbie = h
		_señas = señas 
		_planDeEscape =planDeEscape
	}
	
	def visitarPais(){
		planDeEscape.forEach[visitar(this)]
	}
	
	
	
	
	def dameLasPistas(){
		
	}
	
	
}