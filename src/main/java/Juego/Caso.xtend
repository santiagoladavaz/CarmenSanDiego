package Juego

import org.uqbar.commons.utils.Observable

@Observable
class Caso {
	@Property 
	String nombre
	
	@Property
	String descripcion
	 
	
	new(String nomb, String desc, String nombrePais, String desc2){
		this.nombre= nomb
		this.descripcion = desc + nombrePais + desc2
	}
	
}