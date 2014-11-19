package Juego

import org.uqbar.commons.utils.Observable
import pais.Pais
import java.io.Serializable
import persona.Villano
import pais.Lugar
import org.uqbar.commons.model.UserException
import java.util.List
import pais.Caracteristica
import org.uqbar.commons.model.Entity

@Observable
class JuegoAppModel  extends Entity  implements Serializable {

	@Property Juego juego = Juego.getInstance()

	@Property Pais paisSeleccionado
	@Property Pais paisElegido
	
	@Property Villano villanoSeleccionado

	@Property Caracteristica caracteristicaAAgregar
	@Property Caracteristica caracteristicaAEliminar

	@Property Caracteristica señaSeleccionada 
	@Property Caracteristica hobbieSeleccionado
	
	@Property Lugar lugarElegido

	def eliminarHobbie(){
		villanoSeleccionado.eliminarHobbie(this.hobbieSeleccionado)
	}
	
	def eliminarSeña(){
		villanoSeleccionado.eliminarSeña(this.señaSeleccionada)
	}

	def eliminarPais() {
		juego.eliminarPais(this.paisSeleccionado)
	}

	def eliminarVillano() {
		juego.eliminarVillano(this.villanoSeleccionado)
	}

	def agregarLugar() {
		paisSeleccionado.agregarLugar(lugarElegido)
	}

	def eliminarLugar() {
		if (lugarElegido != null) {
			paisSeleccionado.eliminarLugar(lugarElegido)
		} else
			throw new UserException("Debes seleccionar un lugar antes de eliminar")
	}

	def agregarCaract() {
		if (caracteristicaAAgregar != null) {
			paisSeleccionado.agregarCaract(caracteristicaAAgregar)
			caracteristicaAAgregar = null
		}
	}

	def eliminarCaract() {
		if (caracteristicaAEliminar != null) {
			paisSeleccionado.eliminarCaract(caracteristicaAEliminar)
		}
	}

		
	def agregarConexion(){
		if (paisElegido != null){
			paisSeleccionado.agregarConexion(paisElegido)
			paisElegido.agregarConexion(paisSeleccionado)
			paisElegido = null
		}else
			throw new UserException("Debes seleccionar un pais para agregar")
	}
	
	def eliminarConexion(){
		val p = paisElegido
		if (p != null){
			paisSeleccionado.eliminarConexion(p)
			p.eliminarConexion(paisSeleccionado)
		}else
			throw new UserException ("Debes seleccionar un pais antes de eliminar")
	}

}
