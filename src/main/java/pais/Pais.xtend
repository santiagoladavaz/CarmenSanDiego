
package pais

import java.util.List
import org.uqbar.commons.model.ObservableUtils
import org.uqbar.commons.utils.Observable
import persona.Villano
import java.util.ArrayList
import org.uqbar.commons.model.UserException

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
		_nombre = n
		_caract = caracts
		_conexiones = conex
		_lugares = l
		primerLugar = lugares.get(0)
		segundoLugar = lugares.get(1)
		tercerLugar = lugares.get(2)
	}
	
	new(){
		
	}
	
	
	new(String string) {
		_nombre=string
	}
	
	
	override toString(){
		return nombre
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
   		return #["Caracteristica del pais: "+caract.get(0),"Caracteristica del pais: " + caract.get(1)]
   }
   
   /**
    * @METODOS DE LA INTERFAZ
    */
	
	def void agregarCaract(String caracteristica){
		if (! (caracteristica==null) && !caracteristica.startsWith(" ")){
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
		return nombre != null && ! caract.empty &&
			   ! lugares.empty && ! conexiones.empty
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