import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow
import java.awt.Color

class PaisView extends MainWindow<Pais> {
	
	new() {
		super(new Pais)
	}	
	
	
		override createContents(Panel mainPanel) {
		this.setTitle("MapaMundi - Nuevo Pais")
		mainPanel.setLayout(new VerticalLayout)	
		
	
	
	new Label(mainPanel).setText("Nombre:")
	
	new TextBox(mainPanel).bindValueToProperty("nombre")
	
	new Label(mainPanel).setText("Caracteristicas:")
	
	new Button(mainPanel) => [ 
			caption = "Editar Caracteristicas"
			onClick [ | ]
			//bindEnabled(new NotNullObservable("conversion"))
		]	
	
	new Label(mainPanel).setText("Caracteristicas:").setBackground(Color.CYAN)
	new TextBox(mainPanel)//.bindValueToProperty("nombre") A QUE SE BINDEA
	


	new Label(mainPanel).setText("Conexiones:")
	
	new Button(mainPanel) => [ 
			caption = "Editar Conexiones"
			onClick [ | ]
			
		]
	
	new Label(mainPanel).setText("Conexiones:").setBackground(Color.CYAN)
	new TextBox(mainPanel)//.bindValueToProperty("nombre") A QUE SE BINDEA
	

	new Label(mainPanel).setText("Lugares:")
	
	new Button(mainPanel) => [ 
			caption = "Editar Lugares"
			onClick [ | ]
			
		]
	
	new Label(mainPanel).setText("Lugares:").setBackground(Color.CYAN)
	new TextBox(mainPanel)//.bindValueToProperty("nombre") A QUE SE BINDEA
	
	
		new Button(mainPanel) => [ 
			caption = "Aceptar"
			onClick [ | ]
			
		]
	
	
   }
	
	
  def static main(String[] args) {
		new PaisView().startApplication
	}
	
	
	
	
	
	
	
}