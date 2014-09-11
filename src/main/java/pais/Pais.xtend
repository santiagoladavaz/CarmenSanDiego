
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
	
	/**
	 * @METODOS DEL DOMINIO
	 */

	
	def void visitar(Villano villano){
		val pais = villano.obtenerSiguientePais(this)
		if(pais != null)
			lugares.forEach[pasoLadron(villano,pais.dame2Pistas)]
		else
			lugares.get(0).esconderVillano(villano)
	}
	
   def  dame2Pistas(){
   		return #[caract.get(0), caract.get(1)]
   }
   
   /**
    * @METODOS DE LA INTERFAZ
    */
	
	def void agregarCaract(){
		if (! (this.caracteristica==null) && !this.caracteristica.startsWith(" ")){
			caract+=this.caracteristica
			this.caracteristica = null
			ObservableUtils.firePropertyChanged(this,"caract",caract);
			ObservableUtils.firePropertyChanged(this,"consistente",consistente)
		}
   }
   
   
   
   def void agregarLugar(Lugar l){
   		if (l != null){
   			lugares+=l
   			ObservableUtils.firePropertyChanged(this,"lugares",lugares)
   			ObservableUtils.firePropertyChanged(this,"consistente",consistente)
   		}
   	}
   		
	def void eliminarCaract(){
		if(caract.contains(this.caracteristica))
			caract.remove(this.caracteristica)
		ObservableUtils.firePropertyChanged(this,"caract",caract)
		ObservableUtils.firePropertyChanged(this,"consistente",consistente)
 
	}
	
	def conexionesToString(){
		conexiones.map[p|p.nombre]
	}
	
	def eliminarConexion(Pais p){
		conexiones -=p
		ObservableUtils.firePropertyChanged(this,"conexiones",conexiones)
		ObservableUtils.firePropertyChanged(this,"consistente",consistente)
	}
	
	def agregarConexion(Pais p) {
		if (! (p == null)){
			conexiones+=p
			ObservableUtils.firePropertyChanged(this,"conexiones",conexiones)
			ObservableUtils.firePropertyChanged(this,"consistente",consistente)
		}
	}
	
	override toString(){
		return nombre
	}
	
	def setNombre(String nombre){
		_nombre = nombre
		ObservableUtils.firePropertyChanged(this,"consistente",consistente)
	}
	
	def eliminarLugar(Lugar lugar) {
		lugares.remove(lugar)
		ObservableUtils.firePropertyChanged(this,"consistente",consistente)
	}
	
	def isConsistente(){
		return nombre != null && ! caract.empty &&
			   ! lugares.empty && ! conexiones.empty
	}
	
	
	
}