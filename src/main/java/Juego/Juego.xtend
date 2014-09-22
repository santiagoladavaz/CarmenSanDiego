package Juego

import pais.Pais
import java.util.List
import java.util.ArrayList
import org.uqbar.commons.utils.Observable
import pais.Lugar
import pais.Banco
import persona.Villano
import org.uqbar.commons.model.ObservableUtils
import persona.Detective
import pais.Biblioteca
import pais.Club
import pais.Embajada

@Observable
class Juego {
		
	private static Juego JUEGO = new Juego
	@Property  List<Pais> conexiones = new ArrayList<Pais>
	@Property List<Lugar>lugares = new ArrayList<Lugar>
	@Property List<Villano> villanos = new ArrayList<Villano>
 	@Property List<Caso> casos = new ArrayList<Caso>
 	@Property Caso casoSeleccionado
	@Property Detective detective 	
	@Property Villano villano
 	
  def static Juego getInstance(){
 	return  JUEGO
 }
	
	
	new(){
		this.crearPaises		
		lugares =>[ 
					addAll(new Banco,new Biblioteca,new Club,new Embajada)
				  ]
		
		
		villanos =>[
				add(new Villano
				("Bonnie","Femenino",newArrayList("Jugar tenis","Pintar Cuadros"),newArrayList("Alta","Flaca"),newArrayList(seleccionarPais("Argentina"),seleccionarPais("Brasil"),seleccionarPais("Haiti"))))
				add(new Villano
					("Al Capone","Masculino",newArrayList("comer pizza","extorsionar"),newArrayList("barrigon","pelado"),newArrayList(seleccionarPais("Argentina"),seleccionarPais("Uruguay"),seleccionarPais("Croacia"))))
				add(new Villano
					("Gordo Valor","Masculino",newArrayList("Andar en bici"),newArrayList("Tartamudo","Bajito"),newArrayList(seleccionarPais("Italia"),seleccionarPais("Haiti"),seleccionarPais("Brasil"))))
			       ]
			
		casos => [
			add(new Caso("Robo del billete del Trillon", "A las 9 de la mañana en la ciudad de Springfield se robaron el billete del trillon de dolares.
						  El criminal fue muy prolijo y la escena del crimen no contaba con pista alguna,su mision como detective
						  es desifrar el responsable de tal crimen y apresarlo"))
			add(new Caso("Robo de las joyas" , "A las 4 de la tarde en la ciudad de Asuncion se robaron unas valiosas joyas.
						  El criminal fue muy prolijo y la escena del crimen no contaba con pista alguna,su mision como detective
						  es desifrar el responsable de tal crimen y apresarlo") )
			]
		
		//Seleccion aleatoriamente un caso
		seleccionarCaso
		
		detective = new Detective()
		this.seleccionarVillano
		this.iniciarJuego

	}
	
	def crearPaises(){
		val arg = new Pais("Argentina")
		val bra = new Pais("Brasil")
		val cro = new Pais("Croacia")
		val hai = new Pais("Haiti")
		val ita = new Pais("Italia")
		val uru = new Pais("Uruguay")
		arg.caract(newArrayList("Grande","Inseguro","Tiene una provincia Llamada Buenos Aires","se creen el centro del mundo"))
		arg.conexiones(newArrayList(uru,bra))
		arg.lugares(newArrayList(new Banco,new Biblioteca,new Club))
		bra.caract(newArrayList("Caluroso","Festivo","Hablan Portugues","Son Grones!","Usan Reales"))
		bra.conexiones(newArrayList(arg,hai))
		bra.lugares(newArrayList(new Embajada,new Biblioteca,new Club))
		uru.caract(newArrayList("Materos","Con muchas playas","Dicen 'vo'", "tienen a Forlan"))
		uru.conexiones(newArrayList(arg,cro))
		uru.lugares(newArrayList(new Embajada,new Club,new Biblioteca))
		hai.caract(newArrayList("Pobre","Poca poblacion","Cultivan cocos","Les cabio un terremoto"))
		hai.conexiones(newArrayList(bra,ita))
		hai.lugares(newArrayList(new Embajada,new Club,new Biblioteca))
		ita.caract(newArrayList("Forma de bota","Comen pizza","Son Mafiosos"))
		ita.conexiones(newArrayList(cro,hai))
		ita.lugares(newArrayList(new Embajada,new Banco,new Biblioteca))
		cro.conexiones(newArrayList(uru,ita))
		cro.caract(newArrayList("Son croatas", "no se que mas poner porque no se nada de croacia"))
		cro.lugares(newArrayList(new Embajada,new Biblioteca,new Club))
		
		this.conexiones += arg
		this.conexiones += ita
		this.conexiones += bra
		this.conexiones += hai
		this.conexiones += cro
		this.conexiones += uru
		
	}
	
	
	
	def Pais buscarPais(Pais string) {
		conexiones.filter[p| p.nombre == string.nombre].get(0)
	}
	
	def eliminarPais(Pais pais) {
		if(this.conexiones.contains(pais)){
			this.conexiones.remove(pais)
			ObservableUtils.firePropertyChanged(this,"conexiones",conexiones)
		}			
	}
	
	def agregarPais(Pais pais) {
		conexiones += pais
		ObservableUtils.firePropertyChanged(this,"conexiones",conexiones)
	}
	
	def agregarVillano(Villano villano) {
		villanos += villano
		ObservableUtils.firePropertyChanged(this,"villanos",villanos)
	}
	
	def seleccionarCaso(){
		val x =  (Math.random * casos.size) as int
		casoSeleccionado = casos.get(x)
	}
	
	def seleccionarPais(String n){
		conexiones.filter[it | it.nombre == n].get(0)
	}
	
	def seleccionarVillano(){
		 _villano = villanos.get((Math.random * villanos.size) as int)
	}
	
	def iniciarJuego(){
		detective.paisActual=villano.planDeEscape.get(0)
		villano.visitarPais
	}
		
	
}