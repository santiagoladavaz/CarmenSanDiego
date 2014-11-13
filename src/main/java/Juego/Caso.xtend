package Juego

import org.uqbar.commons.utils.Observable
import java.io.Serializable

@Observable
class Caso implements Serializable{
	@Property 
	String nombre
	
	@Property
	String descripcion
	 
	
	new(String nomb, String desc, String nombrePais, String desc2){
		this.nombre= nomb
		this.descripcion = desc + nombrePais + desc2
	}
	
}