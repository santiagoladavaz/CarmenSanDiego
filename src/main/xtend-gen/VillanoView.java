import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class VillanoView extends MainWindow<Villano> {
  public VillanoView() {
    super(new Villano());
  }
  
  public void createContents(final Panel mainPanel) {
    this.setTitle("Expedientes - Nuevo Villano");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Label _label = new Label(mainPanel);
    _label.setText("Nombre:");
    TextBox _textBox = new TextBox(mainPanel);
    _textBox.<ControlBuilder>bindValueToProperty("nombre");
    Label _label_1 = new Label(mainPanel);
    _label_1.setText("Sexo:");
    TextBox _textBox_1 = new TextBox(mainPanel);
    _textBox_1.<ControlBuilder>bindValueToProperty("sexo");
    Label _label_2 = new Label(mainPanel);
    _label_2.setText("Señas Particulares:");
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Editar Señas Particulares");
        final Action _function = new Action() {
          public void execute() {
            VillanoView.this.getModelObject();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Label _label_3 = new Label(mainPanel);
    _label_3.setText("Seña");
    Label _label_4 = new Label(mainPanel);
    _label_4.setText("Hobbie:");
    Button _button_1 = new Button(mainPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            Villano _modelObject = VillanoView.this.getModelObject();
            String _nombre = _modelObject.getNombre();
            InputOutput.<String>print(_nombre);
            Villano _modelObject_1 = VillanoView.this.getModelObject();
            InputOutput.<Villano>print(_modelObject_1);
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
  }
  
  public static void main(final String[] args) {
    VillanoView _villanoView = new VillanoView();
    _villanoView.startApplication();
  }
}
