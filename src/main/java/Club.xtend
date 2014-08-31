import java.util.ArrayList


class Club extends Lugar {
	
	new(String nom){
		_nombre = nom
		_okupa = new Cuidador()
	}
	
	
	override dameLasPistas(Villano villano){
		val list = new ArrayList<String>()
		list+=villano.señas.get(0)
		list+=villano.señas.get(1)
		list+=villano.hobbie.get(0)
		return list
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	def static void main(String[] args) {
		val club = new Club("lala")
		val club2 = new Club("tranca")
		val lugaress = new ArrayList<Lugar>()
		lugaress+=club
		val lugaresSinPasar= new ArrayList<Lugar>()
		lugaresSinPasar+=club2
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
		club2.ocupanteInforma()
	}
	
		
	
	
}