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
		paisAnterior = paisActual
		_paisActual = p
		p.primerLugar = p.lugares.get(0)
		p.segundoLugar = p.lugares.get(1)
		p.tercerLugar = p.lugares.get(2)
		ObservableUtils.firePropertyChanged(this,"paisActual",paisActual);	
	}


	def volver(){
		if(paisAnterior != null){
			setPaisActual(paisAnterior)
		}else{
			throw new UserException ("Es el primer pais que visita !")
		}
	}
	
	
	def agregarRecoCriminal(){
		if(!recorridoCriminal.contains(paisActual.nombre)){
			recorridoCriminal+=paisActual.nombre
			ObservableUtils.firePropertyChanged(this,"recorridoCriminal",recorridoCriminal)	
		}
	}
	
	
	def agregarDestinosFallidos(){
		if(!destinosFallidos.contains(paisActual.nombre)){
			destinosFallidos+=paisActual.nombre
			ObservableUtils.firePropertyChanged(this,"destinosFallidos",destinosFallidos)	
		}
	}
	
}