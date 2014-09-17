package Juego

import pais.Pais
import java.util.List
import java.util.ArrayList
import org.uqbar.commons.utils.Observable
import pais.Lugar
import pais.Banco
import persona.Villano
import org.uqbar.commons.model.ObservableUtils

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
		 val hobbies1 = newArrayList("Jugar tenis","Pintar Cuadros")
		 val señas1 = newArrayList("Alta","Flaca")
		 val hobbies2 = newArrayList("comer pizza","extorsionar")
		 val señas2 = newArrayList("barrigon","pelado")
		villanos =>[
				add(new Villano("Bonnie","Femenino",hobbies1,señas1,#[]))
				add(new Villano("Al Capone","Masculino",hobbies2,señas2,#[]))
				//add(new Villano("Gordo Valor","Masculino",#["Andar en bici"],#["Tartamudo","Bajito"],#[]))
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
	
	def agregarPais(Pais pais) {
		conexiones += pais
		ObservableUtils.firePropertyChanged(this,"conexiones",conexiones)
	}
	
	def agregarVillano(Villano villano) {
		villanos += villano
		ObservableUtils.firePropertyChanged(this,"villanos",villanos)
	}
	
	
}