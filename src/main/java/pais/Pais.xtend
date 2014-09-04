
package pais
import java.util.List
import org.uqbar.commons.utils.Observable
import java.util.ArrayList
import org.uqbar.commons.model.ObservableUtils
import persona.Villano

@Observable
class Pais {
	
	@Property String nombre
	@Property List<String> caract = new ArrayList<String>()
	@Property List<String> conexiones
	@Property List<Lugar> lugares
	@Property String caractAAgregar
	
	
	def void visitar(Villano villano){
		lugares.forEach[pasoLadron(villano)]
	}
	
	
	def void agregarCaract(String c){
		caract+=c
		ObservableUtils.firePropertyChanged(this,"caract",caract);
	}
	
	
	
	def void eliminarCaract(String c){
		caract-=c
	}
	
	
	
	
}