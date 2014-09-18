package persona

import pais.Pais
import java.util.List
import org.uqbar.commons.utils.Observable

@Observable
class Detective {
	
	@Property
	Pais paisActual
	
	@Property
	Villano ordenDeArresto
	
	@Property
	List<String> recorridoCriminal
	
	@Property
	List<String> destinosFallidos
	
	
	
}