package persona
import java.util.List
import org.uqbar.commons.utils.Observable
import pais.Pais
import java.util.ArrayList
import org.uqbar.commons.model.ObservableUtils

@Observable
class Villano {
	
	@Property String nombre
	@Property String sexo
	@Property List<String> hobbie
	@Property List<String> señas
	@Property List<Pais> planDeEscape; 
	@Property String valor

	new (){
		_hobbie = new ArrayList<String> 
		_señas = new ArrayList<String>  
		_planDeEscape = new ArrayList<Pais> 
		
		
	}
	
	new (String n, String s){
		_nombre = n
		_sexo = s
		_hobbie = new ArrayList<String> 
		_señas = new ArrayList<String>  
		_planDeEscape = new ArrayList<Pais> 
	}
	
	def visitarPais(){
		planDeEscape.forEach[visitar(this)]
	}
	
	def agregarValor(String s,String propertyName, List<String> lista){
		lista+=s
		ObservableUtils.firePropertyChanged(this,propertyName,lista);
	}
	
	def eliminarValor(String s,String propertyName, List<String> lista){
		if(lista.contains(s))
			lista-=s
		ObservableUtils.firePropertyChanged(this,propertyName,lista);
	}
	

	
}