import dominio.Pais

class EditarPaisView extends VentanaPaisView {
	
	new(dominio.Pais model) {
		super(model)
	}
	
	override getTitle() {
		return "MapaMundi - Editar Pais"
	}
	
	def static main(String[] args) {
		new EditarPaisView(new Pais).startApplication
	}
	
}