package pais;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import pais.Biblioteca;
import pais.Embajada;
import pais.Lugar;
import pais.Pais;
import persona.Cuidador;
import persona.Informante;
import persona.Villano;

@SuppressWarnings("all")
public class Club extends Lugar {
  public Club() {
    this._nombre = "Club";
    Cuidador _cuidador = new Cuidador();
    this._okupa = _cuidador;
  }
  
  public void pasoLadron(final Villano villano, final List<String> pistas) {
    final ArrayList<String> x = villano.dameLasPistas();
    Informante _informante = new Informante(x);
    this.setOkupa(_informante);
  }
  
  public static void main(final String[] args) {
    final Club club = new Club();
    final Embajada embajada = new Embajada();
    final Embajada embajada2 = new Embajada();
    final Biblioteca biblio = new Biblioteca();
    final ArrayList<Lugar> lugaress = new ArrayList<Lugar>();
    lugaress.add(club);
    lugaress.add(embajada2);
    lugaress.add(biblio);
    final ArrayList<Lugar> lugaresSinPasar = new ArrayList<Lugar>();
    lugaresSinPasar.add(embajada);
    Pais _pais = new Pais();
    final Procedure1<Pais> _function = new Procedure1<Pais>() {
      public void apply(final Pais it) {
        it.lugares(lugaress);
        it.setNombre("Argentina");
        List<String> _caract = it.getCaract();
        _caract.add("hablan español");
        List<String> _caract_1 = it.getCaract();
        _caract_1.add("son gays");
      }
    };
    final Pais pais = ObjectExtensions.<Pais>operator_doubleArrow(_pais, _function);
    Pais _pais_1 = new Pais();
    final Procedure1<Pais> _function_1 = new Procedure1<Pais>() {
      public void apply(final Pais it) {
        it.setNombre("sarasa");
        it.lugares(lugaresSinPasar);
        List<String> _caract = it.getCaract();
        _caract.add("sarasa1");
        List<String> _caract_1 = it.getCaract();
        _caract_1.add("sarasa2");
      }
    };
    final Pais pais2 = ObjectExtensions.<Pais>operator_doubleArrow(_pais_1, _function_1);
    Villano _villano = new Villano();
    final Procedure1<Villano> _function_2 = new Procedure1<Villano>() {
      public void apply(final Villano it) {
        it.setNombre("Pepe");
        it.setSexo("Masculino");
        it.setHobbie(Collections.<String>unmodifiableList(Lists.<String>newArrayList("el ladron juega tennis", " el ladron come manzanas")));
        it.setSeñas(Collections.<String>unmodifiableList(Lists.<String>newArrayList("es un trolaso ", "no tiene idea de la vida")));
        it.setPlanDeEscape(Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList(pais, pais2)));
      }
    };
    final Villano villano = ObjectExtensions.<Villano>operator_doubleArrow(_villano, _function_2);
    villano.visitarPais();
    club.ocupanteInforma();
    embajada2.ocupanteInforma();
    biblio.ocupanteInforma();
    InputOutput.<String>print("\n");
    String _plus = (embajada + "\n");
    InputOutput.<String>print(_plus);
    embajada.ocupanteInforma();
  }
}
