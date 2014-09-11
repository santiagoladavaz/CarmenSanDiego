package pais 
import persona.Cuidador
import persona.Villano
import java.util.List
import persona.Informante
import java.util.ArrayList

class Club extends Lugar {
	
	new(String nom){
		_nombre = nom
		_okupa = new Cuidador()
	}
	
	override pasoLadron(Villano villano,List<String>pistas){
			val x = villano.dameLasPistas
			this.setOkupa(new Informante(x))
	}

	def static void main(String[] args) {
		val club = new Club("lala")
		val embajada = new Embajada("tranca")
		val lugaress = new ArrayList<Lugar>()
		lugaress+=club
		val lugaresSinPasar= new ArrayList<Lugar>()
		lugaresSinPasar+=embajada
		val pais = new Pais() =>[lugares = lugaress]
		pais => [nombre = "Argentina"]
		val pais2 = new Pais() =>[lugares = lugaresSinPasar]
		val villano = new Villano() => [nombre="Pepe"
										sexo="Masculino"
										hobbie = #["juego tennis"]	
										señas = #["soy un trolaso ","no tengo idea de la vida"]
										planDeEscape = #[pais]
					]
		villano.visitarPais()
		club.ocupanteInforma()
		embajada.ocupanteInforma()
	}	
	
}