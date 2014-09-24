
package pais

import java.util.List
import org.uqbar.commons.model.ObservableUtils
import org.uqbar.commons.utils.Observable
import persona.Villano
import java.util.ArrayList
import org.uqbar.commons.model.UserException
import org.uqbar.arena.bindings.ObservableProperty

@Observable
class Pais {
	
	@Property String nombre
	@Property List<String> caract = newArrayList
	@Property List<Pais> conexiones = newArrayList
	@Property List<Lugar> lugares = new ArrayList<Lugar>()
	@Property Lugar primerLugar 
	@Property Lugar segundoLugar 
	@Property Lugar tercerLugar 	
	
	// Constructor completo para pais
	new(String n,List<String> caracts,List<Pais>conex,List<Lugar>l){
		nombre = n
		caract = caracts
		conexiones = conex
		lugares = l
		primerLugar = l.get(0)
		segundoLugar = l.get(1)
		tercerLugar = l.get(2)
	}
	
	def setLugares(List<Lugar>l){
		_lugares = l
		_primerLugar = l.get(0)
		_segundoLugar = l.get(1)
		_tercerLugar = l.get(2)
	}
	
	
	new(String string) {
		_nombre=string
	}
	
	new() {
	}
	
	
	override toString(){
		return nombre
	}
	
	def setPrimerLugar(Lugar l){
		_primerLugar = l
		ObservableUtils.firePropertyChanged(this,"primerLugar",primerLugar)
	}
	
	def setSegundoLugar(Lugar l){
		_segundoLugar = l
		ObservableUtils.firePropertyChanged(this,"segundoLugar",segundoLugar)
	}
	
	def setTercerLugar(Lugar l){
		_tercerLugar = l
		ObservableUtils.firePropertyChanged(this,"tercerLugar",tercerLugar)
	}
	
	/**
	 * @METODOS DEL DOMINIO
	 */

	
	def void visitar(Villano villano){
		val pais = villano.obtenerSiguientePais(this)
		if(pais != null)
			lugares.forEach[pasoLadron(villano,pais.dame2Pistas)]
		else
			esconderLadron(villano)
	}
	
	private def esconderLadron(Villano v){
		val i = (Math.random * lugares.size) as int
		switch i {
			case 0 :{			     
						primerLugar.esconderVillano(v)
						segundoLugar.avisarEmboscada
						tercerLugar.avisarEmboscada
			}
		    case 1  :{
		   	 		    primerLugar.avisarEmboscada
		   	 		    segundoLugar.esconderVillano(v)
		   	 		    tercerLugar.avisarEmboscada
		    }
		    default :{
		   				primerLugar.avisarEmboscada
		   				segundoLugar.avisarEmboscada
		   				tercerLugar.esconderVillano(v)
		    } 
			
		}
	}
	
	private def dame2Randoms(){
		val i = (Math.random * caract.size) as int
		val y = (Math.random * caract.size) as int
		if ( y != i)
			return #[y,i]
		return #[0,caract.size-1]
	}
	
   def  dame2Pistas(){
   		val n = dame2Randoms
   		val p1 = caract.get(n.get(0))
   		val p2 = caract.get(n.get(1))
   		return #["Caracteristica del pais: "+p1+"\n"+"Caracteristica del pais: "+p2+"\n"]
   }
   
   /**
    * @METODOS DE LA INTERFAZ
    */
	
	def void agregarCaract(String caracteristica){
		if ( caracteristica!=null && !caracteristica.startsWith(" ")){
			caract+=caracteristica
			ObservableUtils.firePropertyChanged(this,"caract",caract);
			ObservableUtils.firePropertyChanged(this,"consistente",consistente)
		}
   }
   
   
   
   def void agregarLugar(Lugar l){
   		if (l != null && lugares.size<3 && !lugares.contains(l)){
   			lugares+=l
   			ObservableUtils.firePropertyChanged(this,"lugares",lugares)
   			ObservableUtils.firePropertyChanged(this,"consistente",consistente)
   		}
   		else{
   			throw new UserException("Los lugares deben ser 3 y no deben estar repetidos")
   		}
   	}
   		
	def void eliminarCaract(String caracteristica){
		if(caract.contains(caracteristica)){
			caract.remove(caracteristica)
			ObservableUtils.firePropertyChanged(this,"caract",caract)
			ObservableUtils.firePropertyChanged(this,"consistente",consistente)
 		}else
 			throw new UserException("No existe caracteristica")
	}
	
	def conexionesToString(){
		conexiones.map[p|p.nombre]
	}
	
	def eliminarConexion(Pais p){
		conexiones -= p
		ObservableUtils.firePropertyChanged(this,"conexiones",conexiones)
		ObservableUtils.firePropertyChanged(this,"consistente",consistente)
	}
	
	def agregarConexion(Pais p) {
		if (!conexiones.contains(p)){
			conexiones+=p
			ObservableUtils.firePropertyChanged(this,"conexiones",conexiones)
			ObservableUtils.firePropertyChanged(this,"consistente",consistente)
		}else
			throw new UserException("El pais '"+p.nombre+"' "+ "ya existe")
	}
	
	
	
	def setNombre(String nombre){
		_nombre = nombre
		ObservableUtils.firePropertyChanged(this,"consistente",consistente)
	}
	
	def eliminarLugar(Lugar lugar) {
		if (lugar != null){
			val l = lugares.filter[it | it.toString() == lugar.toString]
			if (! l.empty){
				lugares.remove(l.get(0))
				ObservableUtils.firePropertyChanged(this,"lugares",lugares)
				ObservableUtils.firePropertyChanged(this,"consistente",consistente)
			}
		}
	}
	
	def isConsistente(){
		return nombre != null
     		   && !caract.empty 
     		   && lugares.size.equals(3)
     		   &&  !conexiones.empty
	}
	
	def caract(ArrayList<String> strings) {
		_caract = strings
	}
	
	def conexiones(ArrayList<Pais> paises) {
		_conexiones = paises
	}
	
	def lugares(ArrayList<Lugar> lugars) {
		_lugares = lugars
	}
	
	
	
	
	
}