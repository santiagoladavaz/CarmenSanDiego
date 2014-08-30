



abstract class Lugar {
	
	@Property protected String nombre
	@Property protected Persona okupa
	
	def abstract void pasoLadron(Villano villano)
	
}