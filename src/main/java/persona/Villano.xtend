package persona
import java.util.List
import org.uqbar.commons.utils.Observable
import pais.Pais
import java.util.ArrayList
import org.uqbar.commons.model.ObservableUtils

@Observable
class Villano extends Persona{
	
	@Property String nombre
	@Property String sexo
	@Property List<String> hobbie
	@Property List<String> señas
	@Property List<Pais> planDeEscape; 
	 
	 new (String n, String s,List<String> hobbies,List<String>señas,List<Pais> plan){
		_nombre = n
		_sexo = s
		_hobbie = hobbies 
		_señas = señas  
		_planDeEscape = plan 
	}
	

	new (){
		_hobbie = new ArrayList<String> 
		_señas = new ArrayList<String>  
		_planDeEscape = new ArrayList<Pais> 
	}
	
	new (String n, String s){
		_nombre = n
		_sexo = s
		_hobbie = new ArrayList<String> 
		_señas = new ArrayList<String>  
		_planDeEscape = new ArrayList<Pais> 
	}
	
	/**
	 * @METODOS DEL DOMINIO
	 */
	
	def visitarPais(){
		planDeEscape.forEach[visitar(this)]
	}
	
	override def toString(){
		return _nombre
	}
	
	def obtenerSiguientePais(Pais p){
		val x = planDeEscape.indexOf(p)
		if(x < planDeEscape.length - 1){
			return planDeEscape.get(x+1)
		}
		return null
	}
	
	def dameLasPistas(){
		//modificar para elegir pistas de manera aleatoria
		val lista = newArrayList
		lista.add(señas.get(0))
		lista.add(señas.get(1))
		lista
	}
	
	override informar() {
		print ("Felicidades me atrapaste")
	}
	
	/**
	 * @METODOS DE LA INTERFAZ
	 */
	
	def agregarValor(String s,String propertyName, List<String> lista){
		if( !(s == null) && !(s.startsWith(" "))){
			lista+=s
			ObservableUtils.firePropertyChanged(this,propertyName,lista)
			ObservableUtils.firePropertyChanged(this,"consistente",consistente)
		}
	}
	
	def eliminarValor(String s,String propertyName, List<String> lista){
		if(lista.contains(s))
			lista-=s
		ObservableUtils.firePropertyChanged(this,propertyName,lista);
		ObservableUtils.firePropertyChanged(this,"consistente",consistente)
	}
	
	def cumpleCondicion(String n){
		return (n == "Femenino" || n == "Masculino" || n == "Hermafrodita") && n !=null
	}
	
	def setSexo(String n){
		_sexo = n
		ObservableUtils.firePropertyChanged(this,sexo,sexo);
		ObservableUtils.firePropertyChanged(this,"consistente",consistente)
	}
	// PREGUNTAR COMO CREAR UN CARTELITO QUE MUESTRE LA EXCEPCION
	//else
	//		throw new RuntimeException("El sexo debe ser 'Masculino', 'Femenino' o 'Hermafrodita'")
	
	
	def setNombre(String n){
			_nombre = n
			ObservableUtils.firePropertyChanged(this,nombre,nombre);
			ObservableUtils.firePropertyChanged(this,"consistente",consistente)
	}	
	
	def isConsistente(){
		return nombre !=null && cumpleCondicion(sexo) && !señas.empty && !hobbie.empty
	}

}