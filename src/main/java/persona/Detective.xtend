package persona

import pais.Pais
import java.util.List
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.ObservableUtils

@Observable
class Detective {
	
	@Property
	Pais paisActual
	
	@Property
	Villano ordenDeArresto
	
	@Property
	List<String> recorridoCriminal = newArrayList
	
	@Property
	List<String> destinosFallidos = newArrayList
	
	def setPaisActual(Pais p){
		_paisActual = p
		_recorridoCriminal += p.nombre
		ObservableUtils.firePropertyChanged(this,"paisActual",paisActual);
		ObservableUtils.firePropertyChanged(this,"recorridoCriminal",recorridoCriminal)		
	}

	
}