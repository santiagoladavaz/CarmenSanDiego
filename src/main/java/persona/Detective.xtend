package persona

import pais.Pais
import java.util.List
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.ObservableUtils
import org.uqbar.commons.model.UserException

@Observable
class Detective {
	
	@Property
	Pais paisActual
	
	@Property
	Pais paisAnterior = null
	
	@Property
	Villano ordenDeArresto
	
	@Property
	List<String> recorridoCriminal = newArrayList
	
	@Property
	List<String> destinosFallidos = newArrayList
	
	def setPaisActual(Pais p){
		_paisAnterior = paisActual
		_paisActual = p
		_recorridoCriminal += p.nombre
		ObservableUtils.firePropertyChanged(this,"paisActual",paisActual);
		ObservableUtils.firePropertyChanged(this,"recorridoCriminal",recorridoCriminal)		
	}


	def volver(){
		if(paisAnterior != null){
			setPaisActual(paisAnterior)
		}else{
			throw new UserException ("Es el primer pais que visita !")
		}
		
	}
	
}