package Juego

import pais.Pais
import java.util.List
import java.util.ArrayList
import org.uqbar.commons.utils.Observable
import pais.Lugar
import pais.Banco
import persona.Villano

@Observable
class Juego {
		
	private static Juego JUEGO = new Juego
	@Property  List<Pais> conexiones = new ArrayList<Pais>
	@Property List<Lugar>lugares = new ArrayList<Lugar>
	@Property List<Villano> villanos = new ArrayList<Villano>
 	
  def static Juego getInstance(){
 	return  JUEGO
 }
	
	
	new(){
		conexiones =>[
			add(new Pais("Argentina"))
			add(new Pais("Brasil"))
			add(new Pais("Uruguay"))
		]
		lugares =>[ add(new Banco("BANCO - Provincia"))
					add(new Banco("BIBLIOTECA - Quilmes"))
			
		            ]
		villanos =>[
				add(new Villano("Bonnie","Femenino",#["Jugar tenis","Pintar cuadros"],#["Alta","Flaca"],#[]))
				add(new Villano("Al Capone","Masculino",#["Comer pizza","Extorcionar"],#["Barrigon","Pelado"],#[]))
				add(new Villano("Gordo Valor","Masculino",#["Andar en bici"],#["Tartamudo","Bajito"],#[]))
			]
		
	}
	
	def Pais buscarPais(Pais string) {
		print(string)
		conexiones.filter[p| p.nombre == string.nombre].get(0)
	}
	
	def eliminarPais(Pais pais) {
			
			if(this.conexiones.contains(pais)){
				this.conexiones.remove(pais)
			}
				
		}
	
	
}