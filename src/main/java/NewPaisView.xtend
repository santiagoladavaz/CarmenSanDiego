import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow
import java.awt.Color
import dominio.Pais

class NewPaisView extends VentanaPaisView{
	
	new() {
		super(new Pais)
	}
	
	override getTitle() {
		return "MapaMundi - Nuevo Pais"
	}

	
	
  def static main(String[] args) {
		new NewPaisView().startApplication
	}
}