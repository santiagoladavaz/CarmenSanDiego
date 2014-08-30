import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow

class VillanoView extends MainWindow<Villano>{

	
	new() {
		super(new Villano)
	}	


	override createContents(Panel mainPanel) {
		this.setTitle("Expedientes - Nuevo Villano")
		mainPanel.setLayout(new VerticalLayout)	
		
	
	
	new Label(mainPanel).setText("Nombre:")
	
	new TextBox(mainPanel).bindValueToProperty("nombre")
	
	new Label(mainPanel).setText("Sexo:")
	
	new TextBox(mainPanel).bindValueToProperty("sexo")
	
	new Label(mainPanel).setText("Señas Particulares:")
	
	new Button(mainPanel) => [ 
			caption = "Editar Señas Particulares"
			onClick [ | modelObject]
			//bindEnabled(new NotNullObservable("conversion"))
		]
	
	new Label(mainPanel).setText("Seña")
	
	
	
	new Label(mainPanel).setText("Hobbie:")
	
//	new Button(mainPanel) => [ 
//			caption = "Editar Hobbies"
//			//onClick [ | modelObject.convertir ]
//			//bindEnabled(new NotNullObservable("conversion"))
//		]	
	
	//Lista de hobbies
	
	
	new Button(mainPanel) => [ 
			caption = "Aceptar"
			onClick [ | print(modelObject.nombre)
				        print(modelObject)
			]
			//bindEnabled(new NotNullObservable("conversion"))
		]	
		
	}
	
	
	
	def static main(String[] args) {
		new VillanoView().startApplication
	}
	
}