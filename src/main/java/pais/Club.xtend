package pais 
import persona.Cuidador
import persona.Villano
import java.util.List
import persona.Informante
import java.util.ArrayList
import java.io.Serializable

class Club extends Lugar implements Serializable {
	
	new(){
		_nombre = "Club"
		_okupa = new Cuidador()
	}

	
	
	override pasoLadron(Villano villano,List<String>pistas){
			val x = villano.dameLasPistas
			okupa = new Informante(x)
	}

	def static void main(String[] args) {
		val club = new Club()
		val embajada = new Embajada()
		val embajada2 = new Embajada()
		val biblio = new Biblioteca()
		val lugaress = new ArrayList<Lugar>()
		lugaress+=club
		lugaress+=embajada2
		lugaress+=biblio
		
		val lugaresSinPasar= new ArrayList<Lugar>()
		lugaresSinPasar+=embajada
		val pais = new Pais() =>[lugares = lugaress
				 nombre = "Argentina"
				 caract.add("hablan español")
				 caract.add("son gays")
		]
		val pais2 = new Pais() =>[ nombre = "sarasa"
								   lugares = lugaresSinPasar
								   caract.add("sarasa1")
								   caract.add("sarasa2")
		]
		val villano = new Villano() => [nombre="Pepe"
										sexo="Masculino"
										hobbie = #["el ladron juega tennis"," el ladron come manzanas"]	
										señas = #["es un nabo ","no tiene idea de la vida"]
										planDeEscape = #[pais,pais2]
					]
		villano.visitarPais()
		club.ocupanteInforma()
		embajada2.ocupanteInforma()
		biblio.ocupanteInforma()
		print("\n")
		print(embajada + "\n")
		embajada.ocupanteInforma
	}	
	
}