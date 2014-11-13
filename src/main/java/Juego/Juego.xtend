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
import org.uqbar.commons.model.UserException
import java.io.Serializable

@Observable
class Juego implements Serializable {
		
	private static Juego JUEGO = new Juego
	@Property  List<Pais> conexiones = new ArrayList<Pais>
	@Property List<Lugar>lugares = new ArrayList<Lugar>
	@Property List<Villano> villanos = new ArrayList<Villano>
 	@Property List<Caso> casos = new ArrayList<Caso>
 	@Property Caso casoSeleccionado
	@Property Detective detective 	
	@Property Villano villano
	@Property Pais paisActual
	@Property Villano autorDelRobo;
	@Property List<Pais> paisesFallidos = new ArrayList<Pais>;
	@Property List<Pais>recorridoCriminal = new ArrayList<Pais>;
	@Property String descripcionDeLaPista;
 	
  	
  	def static Juego getInstance(){
 		return  JUEGO
 	}
	
	
	//Crea todo el juego
	new(){
		crearPaises		
		crearLugares
		crearVillanos
		crearDetective
		
		
		//Selecciona una villano aleatoriamente
		seleccionarVillano
		crearCasos(villano.planDeEscape.get(0).nombre)
		paisActual = villano.planDeEscape.get(0)
		autorDelRobo = villano

		//Seleccion aleatoriamente un caso
		seleccionarCaso
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
		arg.caract(newArrayList("grande","inseguro","que tiene una provincia Llamada Buenos Aires","donde se creen el centro del mundo"))
		arg.conexiones(newArrayList(uru,bra))
		arg.setLugares(newArrayList(new Banco,new Biblioteca,new Club))
		bra.caract(newArrayList("caluroso","festivo","donde hablan Portugues","son morenos","donde usan Reales"))
		bra.conexiones(newArrayList(arg,hai))
		bra.setLugares(newArrayList(new Club,new Biblioteca,new Banco))
		uru.caract(newArrayList("matero","Con muchas playas","donde dicen 'bo'", "donde esta Forlan"))
		uru.conexiones(newArrayList(arg,cro))
		uru.setLugares(newArrayList(new Biblioteca,new Club,new Banco))
		hai.caract(newArrayList("pobre","con poca poblacion","que cultiva cocos","que tuvo un terremoto"))
		hai.conexiones(newArrayList(bra,ita))
		hai.setLugares(newArrayList(new Club,new Banco,new Biblioteca))
		ita.caract(newArrayList("con forma de bota","donde comen pizza","donde suele haber mafiosos"))
		ita.conexiones(newArrayList(cro,hai))
		ita.setLugares(newArrayList(new Club ,new Biblioteca,new Banco))
		cro.conexiones(newArrayList(uru,ita))
		cro.caract(newArrayList("que su capital es Zagreb", "su camiseta de futbol parece un mantel"))
		cro.setLugares(newArrayList(new Biblioteca,new Club,new Banco))
		
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
					("AlCapone","Masculino",
					newArrayList("Comer pizza","Extorsionar"),
					newArrayList("Barrigon","Pelado"),
					newArrayList(seleccionarPais("Argentina"),seleccionarPais("Uruguay"),seleccionarPais("Croacia")))
				
		val gordo = new Villano
					("GordoValor","Masculino",
						newArrayList("Andar en bici"),
						newArrayList("Tartamudo","Bajito"),
						newArrayList(seleccionarPais("Italia"),seleccionarPais("Haiti"),seleccionarPais("Brasil")))
						
		val burns = new Villano
					("Sr.Burns","Masculino",
						newArrayList("Presumir su fortuna","Menospreciar pobres"),
						newArrayList("Rico","Tiene el sindrome de los 3 chiflados","Dueño de una planta nuclear"),
						newArrayList(seleccionarPais("Croacia"),seleccionarPais("Uruguay"),seleccionarPais("Argentina")))
		
		val moria = new Villano
					("MoriaCasan","Femenino",
						newArrayList("Pelearse delante de las camaras","Modelar"),
						newArrayList("Usa peluca","Se opero 32 veces"),
						newArrayList(seleccionarPais("Haiti"),seleccionarPais("Italia"),seleccionarPais("Croacia")))
		
		
		val biffPasado = new Villano ("BiffPasado","Masculino",
						newArrayList("Decirle gallina a Martin","Es medio boludo"),
						newArrayList("vive en 1950","choco contra un camion de estiercol"),
						newArrayList(seleccionarPais("Haiti"),seleccionarPais("Italia"),seleccionarPais("Croacia")))
						
		
		val biffFuturo = new Villano ("BiffPresenteAlterno","Masculino",
						newArrayList("vive en un presente paralelo a 1985","tiene un casino"),
						newArrayList("esta casado con la mama de martin","esta en un jacuzzi con muchas modelos en una peli "),
						newArrayList(seleccionarPais("Haiti"),seleccionarPais("Italia"),seleccionarPais("Croacia")))				
		
		villanos.addAll(bonnie,capone,gordo,burns,moria,biffFuturo,biffPasado)		
	}
	
	
	def crearCasos(String nombre){
		val caso1 = new Caso("Robo del billete del Trillon", "A las 9 de la mañana  ", nombre ," se robaron el billete del trillon de dolares.
						  El criminal fue muy prolijo y la escena del crimen no contaba con pista alguna,su mision como detective
						  es descifrar el responsable de tal crimen y apresarlo")
		
		val caso2 = new Caso("Robo de las joyas" , "A las 4 de la tarde ", nombre , "se robaron unas valiosas joyas.
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
	
	def Pais buscarPais(String paisNombre){
		conexiones.filter[p|p.nombre == paisNombre].get(0)
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
		if(detective.ordenDeArresto == null){
			throw new UserException("Apurese a emitir una orden de arresto!")
		}else{
			villano.equals(detective.ordenDeArresto)
		}
		
	}
	
	def gano(Pais p,Lugar lugar){
		ultimoPaisDelVillano(p) && villanoCorrecto && lugar.okupa.equals(villano)
	}
	
	def gano(Lugar lugar) {
		gano(detective.paisActual, lugar)
	}
	
	def perdio(Pais p,Lugar lugar){
		ultimoPaisDelVillano(p) && !villanoCorrecto && lugar.okupa.equals(villano)
	}
	
	
	def iniciarJuego(){
		detective.paisActual=villano.planDeEscape.get(0)
		villano.visitarPais
	}
	
	def buscarVillano(String nombre){
		return villanos.filter[v | v.nombre.equals(nombre)].get(0);
	}
	
	def visitarLugar(String nombrePais,String nombreLugar){
		val p = buscarPais(nombrePais)
		val l = p.getLugar(nombreLugar)
		var x = l.ocupanteInforma
		print(x);
		if(x.startsWith("ALTO")){
			if(villano.nombre == autorDelRobo.nombre ){
				print(villano.nombre == autorDelRobo.nombre)
				x.concat("                               Felicidades Atrapaste al ladron!")
			}else
				x.concat("                    Mala suerte!, el villano al cual le emitiste la orden de arresto no coincide con
				el autor del crimen")
		}
		descripcionDeLaPista = x;	
		if(!recorridoCriminal.exists[pais | pais.nombre == nombrePais]){
			recorridoCriminal += p
		}
		if(descripcionDeLaPista.startsWith("El ladron no")){
			if(!paisesFallidos.exists[it | it.nombre == nombrePais ]){
				paisesFallidos += p
			}
		}	
	}
		
	
}