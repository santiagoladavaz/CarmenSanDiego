package dominio;

import com.google.common.collect.Lists;
import dominio.Cuidador;
import dominio.Lugar;
import dominio.Pais;
import dominio.Villano;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Club extends Lugar {
  public Club(final String nom) {
    this._nombre = nom;
    Cuidador _cuidador = new Cuidador();
    this._okupa = _cuidador;
  }
  
  public List<String> dameLasPistas(final Villano villano) {
    final ArrayList<String> list = new ArrayList<String>();
    List<String> _señas = villano.getSeñas();
    String _get = _señas.get(0);
    list.add(_get);
    List<String> _señas_1 = villano.getSeñas();
    String _get_1 = _señas_1.get(1);
    list.add(_get_1);
    List<String> _hobbie = villano.getHobbie();
    String _get_2 = _hobbie.get(0);
    list.add(_get_2);
    return list;
  }
  
  public static void main(final String[] args) {
    final Club club = new Club("lala");
    final Club club2 = new Club("tranca");
    final ArrayList<Lugar> lugaress = new ArrayList<Lugar>();
    lugaress.add(club);
    final ArrayList<Lugar> lugaresSinPasar = new ArrayList<Lugar>();
    lugaresSinPasar.add(club2);
    Pais _pais = new Pais();
    final Procedure1<Pais> _function = new Procedure1<Pais>() {
      public void apply(final Pais it) {
        it.setLugares(lugaress);
      }
    };
    final Pais pais = ObjectExtensions.<Pais>operator_doubleArrow(_pais, _function);
    final Procedure1<Pais> _function_1 = new Procedure1<Pais>() {
      public void apply(final Pais it) {
        it.setNombre("Argentina");
      }
    };
    ObjectExtensions.<Pais>operator_doubleArrow(pais, _function_1);
    Pais _pais_1 = new Pais();
    final Procedure1<Pais> _function_2 = new Procedure1<Pais>() {
      public void apply(final Pais it) {
        it.setLugares(lugaresSinPasar);
      }
    };
    final Pais pais2 = ObjectExtensions.<Pais>operator_doubleArrow(_pais_1, _function_2);
    Villano _villano = new Villano();
    final Procedure1<Villano> _function_3 = new Procedure1<Villano>() {
      public void apply(final Villano it) {
        it.setNombre("Pepe");
        it.setSexo("Masculino");
        it.setHobbie(Collections.<String>unmodifiableList(Lists.<String>newArrayList("juego tennis")));
        it.setSeñas(Collections.<String>unmodifiableList(Lists.<String>newArrayList("soy un trolaso ", "no tengo idea de la vida")));
        it.setPlanDeEscape(Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList(pais)));
      }
    };
    final Villano villano = ObjectExtensions.<Villano>operator_doubleArrow(_villano, _function_3);
    villano.visitarPais();
    club.ocupanteInforma();
    club2.ocupanteInforma();
  }
}
