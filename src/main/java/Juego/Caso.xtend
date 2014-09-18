package Juego

import org.uqbar.commons.utils.Observable

@Observable
class Caso {
	@Property 
	String nombre
	
	@Property
	String descripcion
	
	new(String nomb, String desc){
		this.nombre= nomb
		this.descripcion = desc
	}
	
}