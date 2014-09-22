package Juego;

import Juego.Caso;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
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
  
  private Villano _villano;
  
  public Villano getVillano() {
    return this._villano;
  }
  
  public void setVillano(final Villano villano) {
    this._villano = villano;
  }
  
  public static Juego getInstance() {
    return Juego.JUEGO;
  }
  
  public Juego() {
    this.crearPaises();
    List<Lugar> _lugares = this.getLugares();
    final Procedure1<List<Lugar>> _function = new Procedure1<List<Lugar>>() {
      public void apply(final List<Lugar> it) {
        Banco _banco = new Banco();
        Biblioteca _biblioteca = new Biblioteca();
        Club _club = new Club();
        Embajada _embajada = new Embajada();
        CollectionExtensions.<Lugar>addAll(it, _banco, _biblioteca, _club, _embajada);
      }
    };
    ObjectExtensions.<List<Lugar>>operator_doubleArrow(_lugares, _function);
    List<Villano> _villanos = this.getVillanos();
    final Procedure1<List<Villano>> _function_1 = new Procedure1<List<Villano>>() {
      public void apply(final List<Villano> it) {
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("Jugar tenis", "Pintar Cuadros");
        ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList("Alta", "Flaca");
        Pais _seleccionarPais = Juego.this.seleccionarPais("Argentina");
        Pais _seleccionarPais_1 = Juego.this.seleccionarPais("Brasil");
        Pais _seleccionarPais_2 = Juego.this.seleccionarPais("Haiti");
        ArrayList<Pais> _newArrayList_2 = CollectionLiterals.<Pais>newArrayList(_seleccionarPais, _seleccionarPais_1, _seleccionarPais_2);
        Villano _villano = new Villano("Bonnie", "Femenino", _newArrayList, _newArrayList_1, _newArrayList_2);
        it.add(_villano);
        ArrayList<String> _newArrayList_3 = CollectionLiterals.<String>newArrayList("comer pizza", "extorsionar");
        ArrayList<String> _newArrayList_4 = CollectionLiterals.<String>newArrayList("barrigon", "pelado");
        Pais _seleccionarPais_3 = Juego.this.seleccionarPais("Argentina");
        Pais _seleccionarPais_4 = Juego.this.seleccionarPais("Uruguay");
        Pais _seleccionarPais_5 = Juego.this.seleccionarPais("Croacia");
        ArrayList<Pais> _newArrayList_5 = CollectionLiterals.<Pais>newArrayList(_seleccionarPais_3, _seleccionarPais_4, _seleccionarPais_5);
        Villano _villano_1 = new Villano("Al Capone", "Masculino", _newArrayList_3, _newArrayList_4, _newArrayList_5);
        it.add(_villano_1);
        ArrayList<String> _newArrayList_6 = CollectionLiterals.<String>newArrayList("Andar en bici");
        ArrayList<String> _newArrayList_7 = CollectionLiterals.<String>newArrayList("Tartamudo", "Bajito");
        Pais _seleccionarPais_6 = Juego.this.seleccionarPais("Italia");
        Pais _seleccionarPais_7 = Juego.this.seleccionarPais("Haiti");
        Pais _seleccionarPais_8 = Juego.this.seleccionarPais("Brasil");
        ArrayList<Pais> _newArrayList_8 = CollectionLiterals.<Pais>newArrayList(_seleccionarPais_6, _seleccionarPais_7, _seleccionarPais_8);
        Villano _villano_2 = new Villano("Gordo Valor", "Masculino", _newArrayList_6, _newArrayList_7, _newArrayList_8);
        it.add(_villano_2);
      }
    };
    ObjectExtensions.<List<Villano>>operator_doubleArrow(_villanos, _function_1);
    List<Caso> _casos = this.getCasos();
    final Procedure1<List<Caso>> _function_2 = new Procedure1<List<Caso>>() {
      public void apply(final List<Caso> it) {
        Caso _caso = new Caso("Robo del billete del Trillon", "A las 9 de la mañana en la ciudad de Springfield se robaron el billete del trillon de dolares.\n\t\t\t\t\t\t  El criminal fue muy prolijo y la escena del crimen no contaba con pista alguna,su mision como detective\n\t\t\t\t\t\t  es desifrar el responsable de tal crimen y apresarlo");
        it.add(_caso);
        Caso _caso_1 = new Caso("Robo de las joyas", "A las 4 de la tarde en la ciudad de Asuncion se robaron unas valiosas joyas.\n\t\t\t\t\t\t  El criminal fue muy prolijo y la escena del crimen no contaba con pista alguna,su mision como detective\n\t\t\t\t\t\t  es desifrar el responsable de tal crimen y apresarlo");
        it.add(_caso_1);
      }
    };
    ObjectExtensions.<List<Caso>>operator_doubleArrow(_casos, _function_2);
    this.seleccionarCaso();
    Detective _detective = new Detective();
    this.setDetective(_detective);
    this.seleccionarVillano();
    this.iniciarJuego();
  }
  
  public boolean crearPaises() {
    boolean _xblockexpression = false;
    {
      final Pais arg = new Pais("Argentina");
      final Pais bra = new Pais("Brasil");
      final Pais cro = new Pais("Croacia");
      final Pais hai = new Pais("Haiti");
      final Pais ita = new Pais("Italia");
      final Pais uru = new Pais("Uruguay");
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("Grande", "Inseguro", "Tiene una provincia Llamada Buenos Aires", "se creen el centro del mundo");
      arg.caract(_newArrayList);
      ArrayList<Pais> _newArrayList_1 = CollectionLiterals.<Pais>newArrayList(uru, bra);
      arg.conexiones(_newArrayList_1);
      Banco _banco = new Banco();
      Biblioteca _biblioteca = new Biblioteca();
      Club _club = new Club();
      ArrayList<Lugar> _newArrayList_2 = CollectionLiterals.<Lugar>newArrayList(_banco, _biblioteca, _club);
      arg.lugares(_newArrayList_2);
      ArrayList<String> _newArrayList_3 = CollectionLiterals.<String>newArrayList("Caluroso", "Festivo", "Hablan Portugues", "Son Grones!", "Usan Reales");
      bra.caract(_newArrayList_3);
      ArrayList<Pais> _newArrayList_4 = CollectionLiterals.<Pais>newArrayList(arg, hai);
      bra.conexiones(_newArrayList_4);
      Embajada _embajada = new Embajada();
      Biblioteca _biblioteca_1 = new Biblioteca();
      Club _club_1 = new Club();
      ArrayList<Lugar> _newArrayList_5 = CollectionLiterals.<Lugar>newArrayList(_embajada, _biblioteca_1, _club_1);
      bra.lugares(_newArrayList_5);
      ArrayList<String> _newArrayList_6 = CollectionLiterals.<String>newArrayList("Materos", "Con muchas playas", "Dicen \'vo\'", "tienen a Forlan");
      uru.caract(_newArrayList_6);
      ArrayList<Pais> _newArrayList_7 = CollectionLiterals.<Pais>newArrayList(arg, cro);
      uru.conexiones(_newArrayList_7);
      Embajada _embajada_1 = new Embajada();
      Club _club_2 = new Club();
      Biblioteca _biblioteca_2 = new Biblioteca();
      ArrayList<Lugar> _newArrayList_8 = CollectionLiterals.<Lugar>newArrayList(_embajada_1, _club_2, _biblioteca_2);
      uru.lugares(_newArrayList_8);
      ArrayList<String> _newArrayList_9 = CollectionLiterals.<String>newArrayList("Pobre", "Poca poblacion", "Cultivan cocos", "Les cabio un terremoto");
      hai.caract(_newArrayList_9);
      ArrayList<Pais> _newArrayList_10 = CollectionLiterals.<Pais>newArrayList(bra, ita);
      hai.conexiones(_newArrayList_10);
      Embajada _embajada_2 = new Embajada();
      Club _club_3 = new Club();
      Biblioteca _biblioteca_3 = new Biblioteca();
      ArrayList<Lugar> _newArrayList_11 = CollectionLiterals.<Lugar>newArrayList(_embajada_2, _club_3, _biblioteca_3);
      hai.lugares(_newArrayList_11);
      ArrayList<String> _newArrayList_12 = CollectionLiterals.<String>newArrayList("Forma de bota", "Comen pizza", "Son Mafiosos");
      ita.caract(_newArrayList_12);
      ArrayList<Pais> _newArrayList_13 = CollectionLiterals.<Pais>newArrayList(cro, hai);
      ita.conexiones(_newArrayList_13);
      Embajada _embajada_3 = new Embajada();
      Banco _banco_1 = new Banco();
      Biblioteca _biblioteca_4 = new Biblioteca();
      ArrayList<Lugar> _newArrayList_14 = CollectionLiterals.<Lugar>newArrayList(_embajada_3, _banco_1, _biblioteca_4);
      ita.lugares(_newArrayList_14);
      ArrayList<Pais> _newArrayList_15 = CollectionLiterals.<Pais>newArrayList(uru, ita);
      cro.conexiones(_newArrayList_15);
      ArrayList<String> _newArrayList_16 = CollectionLiterals.<String>newArrayList("Son croatas", "no se que mas poner porque no se nada de croacia");
      cro.caract(_newArrayList_16);
      Embajada _embajada_4 = new Embajada();
      Biblioteca _biblioteca_5 = new Biblioteca();
      Club _club_4 = new Club();
      ArrayList<Lugar> _newArrayList_17 = CollectionLiterals.<Lugar>newArrayList(_embajada_4, _biblioteca_5, _club_4);
      cro.lugares(_newArrayList_17);
      List<Pais> _conexiones = this.getConexiones();
      _xblockexpression = CollectionExtensions.<Pais>addAll(_conexiones, arg, ita, bra, hai, cro, uru);
    }
    return _xblockexpression;
  }
  
  public Pais buscarPais(final Pais string) {
    List<Pais> _conexiones = this.getConexiones();
    final Function1<Pais, Boolean> _function = new Function1<Pais, Boolean>() {
      public Boolean apply(final Pais p) {
        String _nombre = p.getNombre();
        String _nombre_1 = string.getNombre();
        return Boolean.valueOf(Objects.equal(_nombre, _nombre_1));
      }
    };
    Iterable<Pais> _filter = IterableExtensions.<Pais>filter(_conexiones, _function);
    return ((Pais[])Conversions.unwrapArray(_filter, Pais.class))[0];
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
  
  public Pais seleccionarPais(final String n) {
    List<Pais> _conexiones = this.getConexiones();
    final Function1<Pais, Boolean> _function = new Function1<Pais, Boolean>() {
      public Boolean apply(final Pais it) {
        String _nombre = it.getNombre();
        return Boolean.valueOf(Objects.equal(_nombre, n));
      }
    };
    Iterable<Pais> _filter = IterableExtensions.<Pais>filter(_conexiones, _function);
    return ((Pais[])Conversions.unwrapArray(_filter, Pais.class))[0];
  }
  
  public Villano seleccionarVillano() {
    List<Villano> _villanos = this.getVillanos();
    double _random = Math.random();
    List<Villano> _villanos_1 = this.getVillanos();
    int _size = _villanos_1.size();
    double _multiply = (_random * _size);
    Villano _get = _villanos.get(((int) _multiply));
    return this._villano = _get;
  }
  
  public void iniciarJuego() {
    Detective _detective = this.getDetective();
    Villano _villano = this.getVillano();
    List<Pais> _planDeEscape = _villano.getPlanDeEscape();
    Pais _get = _planDeEscape.get(0);
    _detective.setPaisActual(_get);
    Villano _villano_1 = this.getVillano();
    _villano_1.visitarPais();
  }
}
