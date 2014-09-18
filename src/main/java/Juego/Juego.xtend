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
 	
  def static Juego getInstance(){
 	return  JUEGO
 }
	
	
	new(){
		conexiones =>[
			val arg = new Pais("Argentina",
								   newArrayList("Grande","Inseguro"),
								   newArrayList(),
								   newArrayList(new Banco("Rio"),new Biblioteca("Moreno"),new Club("E3D")))
			
			val bra = new Pais("Brasil",
								   newArrayList("Caluroso","Festivo"),
								   newArrayList(arg),
								   newArrayList(new Banco("Brasuca"),new Biblioteca("Pele"),new Embajada("Garoto")))
			
			
			val cro = new Pais("Croacia",
								   newArrayList("Lluvioso","Extensos campos"),
								   newArrayList(arg),
								   newArrayList(new Banco("Croat"),new Club("Clubic"),new Biblioteca("Suker")))
			
				
			val hai =new Pais("Haiti",
								   newArrayList("Pobre","Poca poblacion","Cultivan cocos"),
								   newArrayList(bra,arg),
								   newArrayList(new Embajada("Hatianos"),new Club("Pobreton"),new Biblioteca("Sin Libros")))
			
			
			val ita =new Pais("Italia",
								   newArrayList("Forma de bota","Comen pizza"),
								   newArrayList(cro,hai),
								   newArrayList(new Embajada("Ita"),new Banco("Mama mia"),new Biblioteca("Buffon")))
			
			
			val uru = new Pais("Uruguay",
								   newArrayList("Materos","Con muchas playas"),
								   newArrayList(ita),
								   newArrayList(new Embajada("Uru"),new Club("La yerba"),new Biblioteca("Luisito Suarez")))
			
			
			addAll(arg,bra,cro,hai,ita,uru)
		]
		
		
		lugares =>[ add(new Banco("BANCO - Provincia"))
					add(new Biblioteca("BIBLIOTECA - Quilmes"))
					//add(new Club("CLUB - Un Club"))
					//add(new Embajada("EMBAJADA - La Embajada"))
				
				  ]
		
		villanos =>[
				add(new Villano
				("Bonnie","Femenino",newArrayList("Jugar tenis","Pintar Cuadros"),newArrayList("Alta","Flaca"),#[]))
				add(new Villano
					("Al Capone","Masculino",newArrayList("comer pizza","extorsionar"),newArrayList("barrigon","pelado"),#[]))
				add(new Villano
					("Gordo Valor","Masculino",newArrayList("Andar en bici"),newArrayList("Tartamudo","Bajito"),#[]))
			       ]
			
		casos => [
			add(new Caso("Robo del billete del Trillon", "A las 9 de la mañana en la ciudad de Springfield se robaron un trillon de dolares.
						  El criminal fue muy prolijo y la escena del crimen no contaba con pista alguna,su mision como detective
						  es desifrar el responsable de tal crimen y apresarlo"))
			add(new Caso("Robo de las joyas" , "A las 4 de la tarde en la ciudad de Asuncion se robaron unas valiosas joyas.
						  El criminal fue muy prolijo y la escena del crimen no contaba con pista alguna,su mision como detective
						  es desifrar el responsable de tal crimen y apresarlo") )
			]
		
		//Seleccion aleatoriamente un caso
		seleccionarCaso
		
		detective = new Detective()
		detective.paisActual = this.conexiones.get(0)
		detective.recorridoCriminal.addAll("Brasil,Uruguay")  // Puesto para probar !
		detective.destinosFallidos.addAll("Japon","Alemania") // Puesto para probar !
	}
	
	def Pais buscarPais(Pais string) {
		print(string)
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
	
	
}