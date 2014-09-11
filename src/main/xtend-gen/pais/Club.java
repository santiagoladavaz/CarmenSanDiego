package pais;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import pais.Embajada;
import pais.Lugar;
import pais.Pais;
import persona.Cuidador;
import persona.Informante;
import persona.Villano;

@SuppressWarnings("all")
public class Club extends Lugar {
  public Club(final String nom) {
    this._nombre = nom;
    Cuidador _cuidador = new Cuidador();
    this._okupa = _cuidador;
  }
  
  public void pasoLadron(final Villano villano, final List<String> pistas) {
    final List<String> x = villano.dameLasPistas();
    Informante _informante = new Informante(x);
    this.setOkupa(_informante);
  }
  
  public static void main(final String[] args) {
    final Club club = new Club("lala");
    final Embajada embajada = new Embajada("tranca");
    final ArrayList<Lugar> lugaress = new ArrayList<Lugar>();
    lugaress.add(club);
    final ArrayList<Lugar> lugaresSinPasar = new ArrayList<Lugar>();
    lugaresSinPasar.add(embajada);
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
    embajada.ocupanteInforma();
  }
}
