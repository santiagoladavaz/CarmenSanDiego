
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
	@Property List<Pais> conexiones = new ArrayList<Pais>()
	@Property List<Lugar> lugares = new ArrayList<Lugar>()
	@Property String caracteristica 
	@Property Pais paisElegido
	@Property Lugar lugarElegido   // por el momento agregada para que sea polimorfico el selector
	
	
	new(){
		
	}
	new(String string) {
		nombre=string
	}

	
	def void visitar(Villano villano){
		lugares.forEach[pasoLadron(villano)]
	}
	
	
	def void agregarCaract(){
		if (! (this.caracteristica==null) && !this.caracteristica.startsWith(" ")){
			caract+=this.caracteristica
			ObservableUtils.firePropertyChanged(this,"caract",caract);
		}
		
   }
   
   
   def void agregarLugar(Lugar l){
   		lugares+=l
   		ObservableUtils.firePropertyChanged(this,"lugares",lugares)
   }
	
	def void eliminarCaract(){
		if(caract.contains(this.caracteristica))
			caract.remove(this.caracteristica)
		ObservableUtils.firePropertyChanged(this,"caract",caract);
 
	}
	
	def conexionesToString(){
		conexiones.map[p|p.nombre]
	}
	
	def eliminarConexion(Pais p){
		conexiones -=p
		ObservableUtils.firePropertyChanged(this,"conexiones",conexiones)
	}
	
	def agregarConexion(Pais p) {
		if (! (p == null)){
			conexiones+=p
			ObservableUtils.firePropertyChanged(this,"conexiones",conexiones)
		}
	}
	
	override toString(){
		return nombre
	}
	
	def eliminarLugar(Lugar lugar) {
		lugares.remove(lugar)
	}
	
	
	
	
}