package Juego;

import Juego.Caso;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;
import pais.Banco;
import pais.Biblioteca;
import pais.Club;
import pais.Embajada;
import pais.Lugar;
import pais.Pais;
import persona.Detective;
import persona.Villano;

@Observable
@SuppressWarnings("all")
public class Juego {
  private static Juego JUEGO = new Juego();
  
  private List<Pais> _conexiones = new ArrayList<Pais>();
  
  public List<Pais> getConexiones() {
    return this._conexiones;
  }
  
  public void setConexiones(final List<Pais> conexiones) {
    this._conexiones = conexiones;
  }
  
  private List<Lugar> _lugares = new ArrayList<Lugar>();
  
  public List<Lugar> getLugares() {
    return this._lugares;
  }
  
  public void setLugares(final List<Lugar> lugares) {
    this._lugares = lugares;
  }
  
  private List<Villano> _villanos = new ArrayList<Villano>();
  
  public List<Villano> getVillanos() {
    return this._villanos;
  }
  
  public void setVillanos(final List<Villano> villanos) {
    this._villanos = villanos;
  }
  
  private List<Caso> _casos = new ArrayList<Caso>();
  
  public List<Caso> getCasos() {
    return this._casos;
  }
  
  public void setCasos(final List<Caso> casos) {
    this._casos = casos;
  }
  
  private Caso _casoSeleccionado;
  
  public Caso getCasoSeleccionado() {
    return this._casoSeleccionado;
  }
  
  public void setCasoSeleccionado(final Caso casoSeleccionado) {
    this._casoSeleccionado = casoSeleccionado;
  }
  
  private Detective _detective;
  
  public Detective getDetective() {
    return this._detective;
  }
  
  public void setDetective(final Detective detective) {
    this._detective = detective;
  }
  
  public static Juego getInstance() {
    return Juego.JUEGO;
  }
  
  public Juego() {
    List<Pais> _conexiones = this.getConexiones();
    final Procedure1<List<Pais>> _function = new Procedure1<List<Pais>>() {
      public void apply(final List<Pais> it) {
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("Grande", "Inseguro");
        ArrayList<Pais> _newArrayList_1 = CollectionLiterals.<Pais>newArrayList();
        Banco _banco = new Banco("Rio");
        Biblioteca _biblioteca = new Biblioteca("Moreno");
        Club _club = new Club("E3D");
        ArrayList<Lugar> _newArrayList_2 = CollectionLiterals.<Lugar>newArrayList(_banco, _biblioteca, _club);
        final Pais arg = new Pais("Argentina", _newArrayList, _newArrayList_1, _newArrayList_2);
        ArrayList<String> _newArrayList_3 = CollectionLiterals.<String>newArrayList("Caluroso", "Festivo");
        ArrayList<Pais> _newArrayList_4 = CollectionLiterals.<Pais>newArrayList(arg);
        Banco _banco_1 = new Banco("Brasuca");
        Biblioteca _biblioteca_1 = new Biblioteca("Pele");
        Embajada _embajada = new Embajada("Garoto");
        ArrayList<Lugar> _newArrayList_5 = CollectionLiterals.<Lugar>newArrayList(_banco_1, _biblioteca_1, _embajada);
        final Pais bra = new Pais("Brasil", _newArrayList_3, _newArrayList_4, _newArrayList_5);
        ArrayList<String> _newArrayList_6 = CollectionLiterals.<String>newArrayList("Lluvioso", "Extensos campos");
        ArrayList<Pais> _newArrayList_7 = CollectionLiterals.<Pais>newArrayList(arg);
        Banco _banco_2 = new Banco("Croat");
        Club _club_1 = new Club("Clubic");
        Biblioteca _biblioteca_2 = new Biblioteca("Suker");
        ArrayList<Lugar> _newArrayList_8 = CollectionLiterals.<Lugar>newArrayList(_banco_2, _club_1, _biblioteca_2);
        final Pais cro = new Pais("Croacia", _newArrayList_6, _newArrayList_7, _newArrayList_8);
        ArrayList<String> _newArrayList_9 = CollectionLiterals.<String>newArrayList("Pobre", "Poca poblacion", "Cultivan cocos");
        ArrayList<Pais> _newArrayList_10 = CollectionLiterals.<Pais>newArrayList(bra, arg);
        Embajada _embajada_1 = new Embajada("Hatianos");
        Club _club_2 = new Club("Pobreton");
        Biblioteca _biblioteca_3 = new Biblioteca("Sin Libros");
        ArrayList<Lugar> _newArrayList_11 = CollectionLiterals.<Lugar>newArrayList(_embajada_1, _club_2, _biblioteca_3);
        final Pais hai = new Pais("Haiti", _newArrayList_9, _newArrayList_10, _newArrayList_11);
        ArrayList<String> _newArrayList_12 = CollectionLiterals.<String>newArrayList("Forma de bota", "Comen pizza");
        ArrayList<Pais> _newArrayList_13 = CollectionLiterals.<Pais>newArrayList(cro, hai);
        Embajada _embajada_2 = new Embajada("Ita");
        Banco _banco_3 = new Banco("Mama mia");
        Biblioteca _biblioteca_4 = new Biblioteca("Buffon");
        ArrayList<Lugar> _newArrayList_14 = CollectionLiterals.<Lugar>newArrayList(_embajada_2, _banco_3, _biblioteca_4);
        final Pais ita = new Pais("Italia", _newArrayList_12, _newArrayList_13, _newArrayList_14);
        ArrayList<String> _newArrayList_15 = CollectionLiterals.<String>newArrayList("Materos", "Con muchas playas");
        ArrayList<Pais> _newArrayList_16 = CollectionLiterals.<Pais>newArrayList(ita);
        Embajada _embajada_3 = new Embajada("Uru");
        Club _club_3 = new Club("La yerba");
        Biblioteca _biblioteca_5 = new Biblioteca("Luisito Suarez");
        ArrayList<Lugar> _newArrayList_17 = CollectionLiterals.<Lugar>newArrayList(_embajada_3, _club_3, _biblioteca_5);
        final Pais uru = new Pais("Uruguay", _newArrayList_15, _newArrayList_16, _newArrayList_17);
        CollectionExtensions.<Pais>addAll(it, arg, bra, cro, hai, ita, uru);
      }
    };
    ObjectExtensions.<List<Pais>>operator_doubleArrow(_conexiones, _function);
    List<Lugar> _lugares = this.getLugares();
    final Procedure1<List<Lugar>> _function_1 = new Procedure1<List<Lugar>>() {
      public void apply(final List<Lugar> it) {
        Banco _banco = new Banco("BANCO - Provincia");
        it.add(_banco);
        Biblioteca _biblioteca = new Biblioteca("BIBLIOTECA - Quilmes");
        it.add(_biblioteca);
      }
    };
    ObjectExtensions.<List<Lugar>>operator_doubleArrow(_lugares, _function_1);
    List<Villano> _villanos = this.getVillanos();
    final Procedure1<List<Villano>> _function_2 = new Procedure1<List<Villano>>() {
      public void apply(final List<Villano> it) {
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("Jugar tenis", "Pintar Cuadros");
        ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList("Alta", "Flaca");
        Villano _villano = new Villano("Bonnie", "Femenino", _newArrayList, _newArrayList_1, Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList()));
        it.add(_villano);
        ArrayList<String> _newArrayList_2 = CollectionLiterals.<String>newArrayList("comer pizza", "extorsionar");
        ArrayList<String> _newArrayList_3 = CollectionLiterals.<String>newArrayList("barrigon", "pelado");
        Villano _villano_1 = new Villano("Al Capone", "Masculino", _newArrayList_2, _newArrayList_3, Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList()));
        it.add(_villano_1);
        ArrayList<String> _newArrayList_4 = CollectionLiterals.<String>newArrayList("Andar en bici");
        ArrayList<String> _newArrayList_5 = CollectionLiterals.<String>newArrayList("Tartamudo", "Bajito");
        Villano _villano_2 = new Villano("Gordo Valor", "Masculino", _newArrayList_4, _newArrayList_5, Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList()));
        it.add(_villano_2);
      }
    };
    ObjectExtensions.<List<Villano>>operator_doubleArrow(_villanos, _function_2);
    List<Caso> _casos = this.getCasos();
    final Procedure1<List<Caso>> _function_3 = new Procedure1<List<Caso>>() {
      public void apply(final List<Caso> it) {
        Caso _caso = new Caso("Robo del billete del Trillon", "A las 9 de la mañana en la ciudad de Springfield se robaron un trillon de dolares.\n\t\t\t\t\t\t  El criminal fue muy prolijo y la escena del crimen no contaba con pista alguna,su mision como detective\n\t\t\t\t\t\t  es desifrar el responsable de tal crimen y apresarlo");
        it.add(_caso);
        Caso _caso_1 = new Caso("Robo de las joyas", "A las 4 de la tarde en la ciudad de Asuncion se robaron unas valiosas joyas.\n\t\t\t\t\t\t  El criminal fue muy prolijo y la escena del crimen no contaba con pista alguna,su mision como detective\n\t\t\t\t\t\t  es desifrar el responsable de tal crimen y apresarlo");
        it.add(_caso_1);
      }
    };
    ObjectExtensions.<List<Caso>>operator_doubleArrow(_casos, _function_3);
    this.seleccionarCaso();
    Detective _detective = new Detective();
    this.setDetective(_detective);
    Detective _detective_1 = this.getDetective();
    List<Pais> _conexiones_1 = this.getConexiones();
    Pais _get = _conexiones_1.get(0);
    _detective_1.setPaisActual(_get);
    Detective _detective_2 = this.getDetective();
    List<String> _recorridoCriminal = _detective_2.getRecorridoCriminal();
    CollectionExtensions.<String>addAll(_recorridoCriminal, "Brasil,Uruguay");
    Detective _detective_3 = this.getDetective();
    List<String> _destinosFallidos = _detective_3.getDestinosFallidos();
    CollectionExtensions.<String>addAll(_destinosFallidos, "Japon", "Alemania");
  }
  
  public Pais buscarPais(final Pais string) {
    Pais _xblockexpression = null;
    {
      InputOutput.<Pais>print(string);
      List<Pais> _conexiones = this.getConexiones();
      final Function1<Pais, Boolean> _function = new Function1<Pais, Boolean>() {
        public Boolean apply(final Pais p) {
          String _nombre = p.getNombre();
          String _nombre_1 = string.getNombre();
          return Boolean.valueOf(Objects.equal(_nombre, _nombre_1));
        }
      };
      Iterable<Pais> _filter = IterableExtensions.<Pais>filter(_conexiones, _function);
      _xblockexpression = ((Pais[])Conversions.unwrapArray(_filter, Pais.class))[0];
    }
    return _xblockexpression;
  }
  
  public void eliminarPais(final Pais pais) {
    List<Pais> _conexiones = this.getConexiones();
    boolean _contains = _conexiones.contains(pais);
    if (_contains) {
      List<Pais> _conexiones_1 = this.getConexiones();
      _conexiones_1.remove(pais);
      List<Pais> _conexiones_2 = this.getConexiones();
      ObservableUtils.firePropertyChanged(this, "conexiones", _conexiones_2);
    }
  }
  
  public void agregarPais(final Pais pais) {
    List<Pais> _conexiones = this.getConexiones();
    _conexiones.add(pais);
    List<Pais> _conexiones_1 = this.getConexiones();
    ObservableUtils.firePropertyChanged(this, "conexiones", _conexiones_1);
  }
  
  public void agregarVillano(final Villano villano) {
    List<Villano> _villanos = this.getVillanos();
    _villanos.add(villano);
    List<Villano> _villanos_1 = this.getVillanos();
    ObservableUtils.firePropertyChanged(this, "villanos", _villanos_1);
  }
  
  public void seleccionarCaso() {
    double _random = Math.random();
    List<Caso> _casos = this.getCasos();
    int _size = _casos.size();
    double _multiply = (_random * _size);
    final int x = ((int) _multiply);
    List<Caso> _casos_1 = this.getCasos();
    Caso _get = _casos_1.get(x);
    this.setCasoSeleccionado(_get);
  }
}
