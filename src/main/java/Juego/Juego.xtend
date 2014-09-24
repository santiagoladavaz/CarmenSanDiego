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
	
	
	//Crea todo el juego
	new(){
		crearPaises		
		crearLugares
		crearVillanos
		crearCasos
		crearDetective
		
		//Seleccion aleatoriamente un caso
		seleccionarCaso
		
		//Selecciona una villano aleatoriamente
		seleccionarVillano
		iniciarJuego

	}
	
	
	//Crea los respectivos paises del juego
	def crearPaises(){
		val arg = new Pais("Argentina")
		val bra = new Pais("Brasil")
		val cro = new Pais("Croacia")
		val hai = new Pais("Haiti")
		val ita = new Pais("Italia")
		val uru = new Pais("Uruguay")
		arg.caract(newArrayList("Grande","Inseguro","Tiene una provincia Llamada Buenos Aires","Se creen el centro del mundo"))
		arg.conexiones(newArrayList(uru,bra))
		arg.setLugares(newArrayList(new Banco,new Biblioteca,new Club))
		bra.caract(newArrayList("Caluroso","Festivo","Hablan Portugues","Son Grones!","Usan Reales"))
		bra.conexiones(newArrayList(arg,hai))
		bra.setLugares(newArrayList(new Club,new Biblioteca,new Embajada))
		uru.caract(newArrayList("Materos","Con muchas playas","Dicen 'bo'", "Tienen a Forlan"))
		uru.conexiones(newArrayList(arg,cro))
		uru.setLugares(newArrayList(new Embajada,new Club,new Banco))
		hai.caract(newArrayList("Pobre","Poca poblacion","Cultivan cocos","Tuvieron un terremoto"))
		hai.conexiones(newArrayList(bra,ita))
		hai.setLugares(newArrayList(new Club,new Embajada,new Biblioteca))
		ita.caract(newArrayList("Forma de bota","Comen pizza","Son Mafiosos"))
		ita.conexiones(newArrayList(cro,hai))
		ita.setLugares(newArrayList(new Embajada,new Biblioteca,new Banco))
		cro.conexiones(newArrayList(uru,ita))
		cro.caract(newArrayList("Su capital es Zagreb", "Su camiseta de futbol parece un mantel"))
		cro.setLugares(newArrayList(new Biblioteca,new Club,new Embajada))
		
		conexiones.addAll(arg,ita,bra,hai,cro,uru)
	}
	
	
	//Crea los villanos del juego
	def crearVillanos(){
		val bonnie = new Villano
						("Bonnie","Femenino",
						newArrayList("Jugar tenis","Pintar Cuadros"),
						newArrayList("Alta","Flaca"),
						newArrayList(seleccionarPais("Argentina"),seleccionarPais("Brasil"),seleccionarPais("Haiti")))
		
		val capone = new Villano
					("Al Capone","Masculino",
					newArrayList("Comer pizza","Extorsionar"),
					newArrayList("Barrigon","Pelado"),
					newArrayList(seleccionarPais("Argentina"),seleccionarPais("Uruguay"),seleccionarPais("Croacia")))
				
		val gordo = new Villano
					("Gordo Valor","Masculino",
						newArrayList("Andar en bici"),
						newArrayList("Tartamudo","Bajito"),
						newArrayList(seleccionarPais("Italia"),seleccionarPais("Haiti"),seleccionarPais("Brasil")))
						
		val burns = new Villano
					("Sr. Burns","Masculino",
						newArrayList("Presumir su fortuna","Menospreciar pobres"),
						newArrayList("Rico","Tiene el sindrome de los 3 chiflados","Dueño de una planta nuclear"),
						newArrayList(seleccionarPais("Croacia"),seleccionarPais("Uruguay"),seleccionarPais("Argentina")))
		
		val moria = new Villano
					("Moria Casan","Femenino",
						newArrayList("Pelearse delante de las camaras","Modelar"),
						newArrayList("Usa peluca","Se opero 32 veces"),
						newArrayList(seleccionarPais("Haiti"),seleccionarPais("Italia"),seleccionarPais("Croacia")))
		
		villanos.addAll(bonnie,capone,gordo,burns,moria)		
	}
	
	
	def crearCasos(){
		val caso1 = new Caso("Robo del billete del Trillon", "A las 9 de la mañana en la ciudad de Springfield se robaron el billete del trillon de dolares.
						  El criminal fue muy prolijo y la escena del crimen no contaba con pista alguna,su mision como detective
						  es descifrar el responsable de tal crimen y apresarlo")
		
		val caso2 = new Caso("Robo de las joyas" , "A las 4 de la tarde en la ciudad de Asuncion se robaron unas valiosas joyas.
						  El criminal fue muy prolijo y la escena del crimen no contaba con pista alguna,su mision como detective
						  es descifrar el responsable de tal crimen y apresarlo")
		
		casos.addAll(caso1,caso2)
	}
	
	
	def crearDetective(){
		detective = new Detective
	}
	
	
	def crearLugares(){
		lugares.addAll(new Banco,new Biblioteca,new Club,new Embajada)
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
		 villano = villanos.get((Math.random * villanos.size) as int)
	}
	
	
	/*
	 * Dado un pais me dice si es el ultimo destino del viallano
	 */
	def ultimoPaisDelVillano(Pais p){
		villano.planDeEscape.last.equals(p)
	}
	
	/*
	 * Devuelve True si el villano que hizo el robo es el de la orden de arresto
	 */
	def villanoCorrecto(){
		villano.equals(detective.ordenDeArresto)
	}
	
	def gano(Pais p,Lugar lugar){
		ultimoPaisDelVillano(p) && villanoCorrecto && lugar.okupa.equals(villano)
	}
	
	def perdio(Pais p,Lugar lugar){
		ultimoPaisDelVillano(p) && !villanoCorrecto && lugar.okupa.equals(villano)
	}
	
	
	def iniciarJuego(){
		detective.paisActual=villano.planDeEscape.get(0)
		print(villano)
		villano.visitarPais
	}
		
	
}