
package asukastietojarjestelma.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TiedostonLukijaTest {
    private TiedostonLukija lukija;
    private String nollaAsukasta;
    private String yksiAsukas;
    private String kaksiAsukasta;
    private String asuntojaNolla;
    private String asuntojaYksi;
    private String asuntojaKaksi;
    private String asuntojaKaksiEriTalo;
    private String sopimuksiaNolla;
    private String sopimuksiaYksi;
    private String sopimuksiaKaksi;
    
    public TiedostonLukijaTest() {
        this.nollaAsukasta = "testitiedostot/vuokralaisia0.txt";
        this.yksiAsukas = "testitiedostot/vuokralaisia1.txt";
        this.kaksiAsukasta = "testitiedostot/vuokralaisia2.txt";
        this.asuntojaNolla = "testitiedostot/asuntoja0.txt";
        this.asuntojaYksi = "testitiedostot/asuntoja1.txt";
        this.asuntojaKaksi = "testitiedostot/asuntoja2.txt";
        this.asuntojaKaksiEriTalo = "testitiedostot/asuntoja2EriTalo.txt";
        this.sopimuksiaNolla = "testitiedostot/sopimuksia0.txt";
        this.sopimuksiaYksi = "testitiedostot/sopimuksia1.txt";
        this.sopimuksiaKaksi = "testitiedostot/sopimuksia2.txt";
    }
    
    @Before
    public void setUp() {
        this.lukija = new TiedostonLukija();
    }
    
    //Vuokralaisten lukeminen
    @Test
    public void lukijaLukeeVuokralaisTiedostonJokaOnTyhjaPalauttaaTyhjanMapin() {
        HashMap<String, Asukas> asukkaat = this.lukija.lueAsukkaat(this.nollaAsukasta);
        assertEquals(true, asukkaat.isEmpty());
    }
    
    @Test
    public void lukijaLukeeVuokralaisTiedostonJaTiedostossaYksiVuokralainenMapissaYksiVuokralainen() {
        HashMap<String, Asukas> asukkaat = this.lukija.lueAsukkaat(this.yksiAsukas);
        assertEquals(1, asukkaat.size());
    }
    
    @Test
    public void lukijaLukeeVuokralaisTiedostonJaTiedostossaKaksiVuokralaistaMapissaKaksiVuokralaista() {
        HashMap<String, Asukas> asukkaat = this.lukija.lueAsukkaat(this.kaksiAsukasta);
        assertEquals(2, asukkaat.size());
    }
    
    //Asuntojen lukeminen
    @Test
    public void lukijaLukeeAsuntoTiedostonJokaOnTyhjaPalauttaaTyhjanMapin() {
        HashMap<String, ArrayList<Asunto>> asunnot = this.lukija.lueAsunnot(this.asuntojaNolla);
        assertEquals(0, asunnot.keySet().size());
    }
    
    @Test
    public void lukijaLukeeAsuntoTiedostonJaTiedostossaYksiAsuntoMapissaYksiAsunto() {
        HashMap<String, ArrayList<Asunto>> asunnot = this.lukija.lueAsunnot(this.asuntojaYksi);
        assertEquals(1, asunnot.keySet().size());
        for (String a : asunnot.keySet()) {
            ArrayList<Asunto> asuntolista = asunnot.get(a);
            assertEquals(1, asuntolista.size());
        }
    }
    
    @Test
    public void lukijaLukeeAsuntoTiedostonJaTiedostossaKaksiSamanTalonAsuntoaMapissaYksiAvainjaKaksiAsuntoa() {
        HashMap<String, ArrayList<Asunto>> asunnot = this.lukija.lueAsunnot(this.asuntojaKaksi);
        assertEquals(1, asunnot.keySet().size());
        for (String a : asunnot.keySet()) {
            ArrayList<Asunto> asuntolista = asunnot.get(a);
            assertEquals(2, asuntolista.size());
        }
    }
    
    @Test
    public void lukijaLukeeAsuntoTiedostonJaTiedostossaKaksiEriTalonAsuntoaMapissaKaksiAvaintajaKaksiAsuntoa() {
        HashMap<String, ArrayList<Asunto>> asunnot = this.lukija.lueAsunnot(this.asuntojaKaksiEriTalo);
        assertEquals(2, asunnot.keySet().size());
        for (String a : asunnot.keySet()) {
            ArrayList<Asunto> asuntolista = asunnot.get(a);
            assertEquals(1, asuntolista.size());
        }
    }
    
    //Vuokrasopimusten lukeminen
    @Test
    public void lukijaLukeeSopimustiedostonLuoSopimuksiaNollaKunSopimuksiaNolla() {
    }
    
    @Test
    public void lukijaLukeeSopimustiedostonLuoSopimuksiaYhdenKunSopimuksiaYksi() {
        
    }
    
    @Test
    public void lukijaLukeeSopimustiedostonLuoSopimuksiaKaksiKunSopimuksiaKaksi() {
        
    }
}
