package persona
import java.util.List
import org.uqbar.commons.utils.Observable
import pais.Pais
import java.util.ArrayList
import org.uqbar.commons.model.ObservableUtils
import java.io.Serializable
import pais.Caracteristica

@Observable
class Villano extends Persona implements Serializable{
	
	@Property String nombre
	@Property String sexo
	@Property List<Caracteristica> hobbie
	@Property List<Caracteristica> senias
	@Property List<Pais> planDeEscape; 
	 
	 new (String n, String s,List<Caracteristica> hobbies,List<Caracteristica> señasl,List<Pais> plan){
		_nombre = n
		_sexo = s
		_hobbie = hobbies 
		_senias = señasl  
		_planDeEscape = plan 
	}
	

	new (){
		_hobbie = new ArrayList<Caracteristica> 
		_senias = new ArrayList<Caracteristica>  
		_planDeEscape = new ArrayList<Pais> 
	}
	
	new (String n, String s){
		_nombre = n
		_sexo = s
		_hobbie = new ArrayList<Caracteristica> 
		_senias = new ArrayList<Caracteristica>  
		_planDeEscape = new ArrayList<Pais> 
	}
	
	new(String n){
		_nombre = n
		_hobbie = new ArrayList<Caracteristica> 
		_senias = new ArrayList<Caracteristica>  
		_planDeEscape = new ArrayList<Pais>
	}
	
	
	/**
	 * @METODOS DEL DOMINIO
	 */
	 
	override avisarEmboscada() {
		/**
		 * DO NOTHING
		 */
	}
	
	
	def visitarPais(){
		planDeEscape.forEach[visitar(this)]
	}
	

	
	def obtenerSiguientePais(Pais p){
		val x = planDeEscape.indexOf(p)
		if(x < planDeEscape.length - 1){
			return planDeEscape.get(x+1)
		}
		return null
	}
	

	
	def dameLasPistas(){
		val i = (Math.random * senias.size) as int
		val y = (Math.random * hobbie.size) as int
		val lista = newArrayList
		lista.add("Una de sus señas es: "+ senias.get(i)+ "\n")
		lista.add("Uno de sus Hobbies es: "+ hobbie.get(y) + "\n")
		lista
	}
	
	override informar() {
		return "ALTO AHI" 
	}
	
	
	/**
	 * @METODOS DE LA INTERFAZ
	 */
	
	def agregarValor(Caracteristica s, List<Caracteristica> lista){
		if( !(s == null) ){
			lista+=s
			//ObservableUtils.firePropertyChanged(this,propertyName,lista)
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
	
	
	
	def setNombre(String n){
			_nombre = n
			ObservableUtils.firePropertyChanged(this,nombre,nombre);
			ObservableUtils.firePropertyChanged(this,"consistente",consistente)
	}	
	
	
	def isConsistente(){
		return nombre !=null && cumpleCondicion(sexo) && !senias.empty && !hobbie.empty
	}
	
	def eliminarHobbie(Caracteristica hobbie) {
		if(this.hobbie.contains(hobbie)){
			this.hobbie.remove(hobbie)
			ObservableUtils.firePropertyChanged(this,"hobbie",hobbie)
			}	 	
	}
	
	def eliminarSeña(Caracteristica seña) {
		if(this.senias.contains(seña)){
			this.senias.remove(seña)
			ObservableUtils.firePropertyChanged(this,"señas",senias)
			
		}
	}
	
}