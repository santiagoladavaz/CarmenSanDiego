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
import pais.Caracteristica
import org.uqbar.commons.model.Entity

@Observable
class Juego extends Entity implements Serializable {
		
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
		//ARGENTINA
		val ArrayList<Caracteristica> listArg = new ArrayList<Caracteristica>
		listArg.add(new Caracteristica("Grande"))
		listArg.add(new Caracteristica("Inseguro"))
		listArg.add(new Caracteristica("Que tiene una provincia Llamada Buenos Aires"))
		listArg.add(new Caracteristica("Donde se creen el centro del mundo"))
		arg.caract(listArg)
		arg.conexiones(newArrayList(uru,bra))
		arg.setLugares(newArrayList(new Banco,new Biblioteca,new Club))
		
		//BRASIL
		val ArrayList<Caracteristica> listBra = new ArrayList<Caracteristica>
		listBra.add(new Caracteristica("Caluroso"))
		listBra.add(new Caracteristica("Festivo"))
		listBra.add(new Caracteristica("Donde hablan Portugues"))
		listBra.add(new Caracteristica("Son morenos"))
		listBra.add(new Caracteristica("Donde usan Reales"))
		bra.caract(listBra)
		bra.conexiones(newArrayList(arg,hai))
		bra.setLugares(newArrayList(new Club,new Biblioteca,new Banco))
		
		//URUGUAY
		val ArrayList<Caracteristica> listUru = new ArrayList<Caracteristica>
		listUru.add(new Caracteristica("Matero"))
		listUru.add(new Caracteristica("Con muchas playas"))
		listUru.add(new Caracteristica("Donde dicen 'bo'"))
		listUru.add(new Caracteristica("Donde esta Forlan"))
		uru.caract(listUru)
		uru.conexiones(newArrayList(arg,cro))
		uru.setLugares(newArrayList(new Biblioteca,new Club,new Banco))
		
		//HAITI
		val ArrayList<Caracteristica> listHai = new ArrayList<Caracteristica>
		listHai.add(new Caracteristica("Pobre"))
		listHai.add(new Caracteristica("Con poca poblacion"))
		listHai.add(new Caracteristica("Que cultiva cocos"))
		listHai.add(new Caracteristica("Que tuvo un terremoto"))
		hai.caract(listHai)
		hai.conexiones(newArrayList(bra,ita))
		hai.setLugares(newArrayList(new Club,new Banco,new Biblioteca))
		
		//ITALIA
		val ArrayList<Caracteristica> listIta = new ArrayList<Caracteristica>
		listIta.add(new Caracteristica("Con forma de bota"))
		listIta.add(new Caracteristica("Donde comen pizza"))
		listIta.add(new Caracteristica("Donde suele haber mafiosos"))
		ita.caract(listIta)
		ita.conexiones(newArrayList(cro,hai))
		ita.setLugares(newArrayList(new Club ,new Biblioteca,new Banco))
		
		//CROACIA
		val ArrayList<Caracteristica> listCro = new ArrayList<Caracteristica>
		listCro.add(new Caracteristica("Que su capital es Zagreb"))
		listCro.add(new Caracteristica("Su camiseta de futbol parece un mantel"))
		cro.conexiones(newArrayList(uru,ita))
		cro.caract(listCro)
		cro.setLugares(newArrayList(new Biblioteca,new Club,new Banco))
		
		conexiones.addAll(arg,ita,bra,hai,cro,uru)
	}
	
	
	//Crea los villanos del juego
	def crearVillanos(){
		val ArrayList<Caracteristica> listHobbieBonnie = new ArrayList<Caracteristica>
		listHobbieBonnie.add(new Caracteristica("Jugar tenis"))
		listHobbieBonnie.add(new Caracteristica("Pintar Cuadros"))
		val ArrayList<Caracteristica> listSeñaBonnie = new ArrayList<Caracteristica>
		listSeñaBonnie.add(new Caracteristica("Alta"))
		listSeñaBonnie.add(new Caracteristica("Flaca"))
		val bonnie = new Villano
						("Bonnie","Femenino", 
						listHobbieBonnie, 
						listSeñaBonnie,
						newArrayList(seleccionarPais("Argentina"),seleccionarPais("Brasil"),seleccionarPais("Haiti")))
		
		val ArrayList<Caracteristica> listHobbieCapone = new ArrayList<Caracteristica>
		listHobbieCapone.add(new Caracteristica("Comer pizza"))
		listHobbieCapone.add(new Caracteristica("Extorsionar"))
		val ArrayList<Caracteristica> listSeñaCapone = new ArrayList<Caracteristica>
		listSeñaCapone.add(new Caracteristica("Barrigon"))
		listSeñaCapone.add(new Caracteristica("Pelado"))
		val capone = new Villano
					("AlCapone","Masculino",
					listHobbieCapone,
					listSeñaCapone,
					newArrayList(seleccionarPais("Argentina"),seleccionarPais("Uruguay"),seleccionarPais("Croacia")))
		
		val ArrayList<Caracteristica> listHobbieGordo = new ArrayList<Caracteristica>
		listHobbieGordo.add(new Caracteristica("Andar en bici"))
		val ArrayList<Caracteristica> listSeñaGordo = new ArrayList<Caracteristica>
		listSeñaGordo.add(new Caracteristica("Tartamudo"))
		listSeñaGordo.add(new Caracteristica("Bajito"))		
		val gordo = new Villano
					("GordoValor","Masculino",
						listHobbieGordo,
						listSeñaGordo,
						newArrayList(seleccionarPais("Italia"),seleccionarPais("Haiti"),seleccionarPais("Brasil")))
		
		val ArrayList<Caracteristica> listHobbieBurns = new ArrayList<Caracteristica>
		listHobbieBurns.add(new Caracteristica("Presumir su fortuna"))
		listHobbieBurns.add(new Caracteristica("Menospreciar pobres"))
		val ArrayList<Caracteristica> listSeñaBurns = new ArrayList<Caracteristica>
		listSeñaBurns.add(new Caracteristica("Tiene el sindrome de los 3 chiflados"))
		listSeñaBurns.add(new Caracteristica("Rico"))
		listSeñaBurns.add(new Caracteristica("Dueño de una planta nuclear"))						
		val burns = new Villano
					("Sr.Burns","Masculino",
						listHobbieBurns,
						listSeñaBurns,
						newArrayList(seleccionarPais("Croacia"),seleccionarPais("Uruguay"),seleccionarPais("Argentina")))
		
		val ArrayList<Caracteristica> listHobbieMoria = new ArrayList<Caracteristica>
		listHobbieMoria.add(new Caracteristica("Pelearse delante de las camaras"))
		listHobbieMoria.add(new Caracteristica("Modelar"))
		val ArrayList<Caracteristica> listSeñaMoria = new ArrayList<Caracteristica>
		listSeñaMoria.add(new Caracteristica("Usa peluca"))
		listSeñaMoria.add(new Caracteristica("Se opero 32 veces"))
		val moria = new Villano
					("MoriaCasan","Femenino",
						listHobbieMoria,
						listSeñaMoria,
						newArrayList(seleccionarPais("Haiti"),seleccionarPais("Italia"),seleccionarPais("Croacia")))
		
		val ArrayList<Caracteristica> listHobbieBiffPasado = new ArrayList<Caracteristica>
		listHobbieBiffPasado.add(new Caracteristica("Decirle gallina a Martin"))
		listHobbieBiffPasado.add(new Caracteristica("Es medio boludo"))
		val ArrayList<Caracteristica> listSeñaBiffPasado = new ArrayList<Caracteristica>
		listSeñaBiffPasado.add(new Caracteristica("vive en 1950"))
		listSeñaBiffPasado.add(new Caracteristica("choco contra un camion de estiercol"))
		val biffPasado = new Villano ("BiffPasado","Masculino",
						listHobbieBiffPasado,
						listSeñaBiffPasado,
						newArrayList(seleccionarPais("Haiti"),seleccionarPais("Italia"),seleccionarPais("Croacia")))
						
		val ArrayList<Caracteristica> listHobbieBiffFuturo = new ArrayList<Caracteristica>
		listHobbieBiffFuturo.add(new Caracteristica("vive en un presente paralelo a 1985"))
		listHobbieBiffFuturo.add(new Caracteristica("tiene un casino"))
		val ArrayList<Caracteristica> listSeñaBiffFuturo = new ArrayList<Caracteristica>
		listSeñaBiffFuturo.add(new Caracteristica("esta casado con la mama de martin"))
		listSeñaBiffFuturo.add(new Caracteristica("esta en un jacuzzi con muchas modelos en una peli "))
		val biffFuturo = new Villano ("BiffPresenteAlterno","Masculino",
						listHobbieBiffFuturo,
						listSeñaBiffFuturo,
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
	
	def eliminarVillano(Villano villano) {
		if(this.villanos.contains(villano)){
			this.villanos.remove(villano)
			ObservableUtils.firePropertyChanged(this,"villanos",villanos)
			
		}	
	}
		
	
}