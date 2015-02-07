
package asukastietojarjestelma.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TiedostonKirjoittajaTest {
    private TiedostonKirjoittaja kirjoittaja;
    private TiedostonLukija lukija;
    private Map<String, Asukas> asukkaat;
    private Map<String, ArrayList<Asunto>> asunnot;
    private List<Vuokrasopimus> vuokrasopimukset;
    
    public TiedostonKirjoittajaTest() {
        this.asukkaat = new HashMap<String, Asukas>();
        this.asunnot = new HashMap<String, ArrayList<Asunto>>();
        this.vuokrasopimukset = new ArrayList<Vuokrasopimus>();
    }
    
    @Before
    public void setUp() {
        this.kirjoittaja = new TiedostonKirjoittaja();
        this.lukija = new TiedostonLukija();
    }
    
    //asunnot
    @Test
    public void kunMapTyhjäTiedostoTyhja() throws IOException {
        String tiedosto = "testitiedostot/kirjoitusTestasunnot.txt";
        this.kirjoittaja.tallennaAsunnot("testitiedostot/kirjoitusTestasunnot.txt", this.asunnot);
        assertEquals(true, this.lukija.lueAsunnot(tiedosto).isEmpty());
    }
    
    
    @Test
    public void kunMapissaYksiAsuntoKirjoittaaTiedostoonYhden() throws IOException {
        String tiedosto = "testitiedostot/kirjoitusTestasunnot.txt";
        this.kirjoittaja.tallennaAsunnot("testitiedostot/kirjoitusTestasunnot.txt", luoMapJossaYksiAsunto());
        assertEquals(1, this.lukija.lueAsunnot(tiedosto).keySet().size());
        assertEquals(1, this.lukija.lueAsunnot(tiedosto).get("AKT 4").size()); 
    }
    
    @Test
    public void kunMapissaKaksiSamanTalonAsuntoaKirjoittaaTiedostoonKaksi() throws IOException {
        String tiedosto = "testitiedostot/kirjoitusTestasunnot.txt";
        this.kirjoittaja.tallennaAsunnot("testitiedostot/kirjoitusTestasunnot.txt", luoMapJossaKaksiSamanTalonAsuntoa());
        assertEquals(1, this.lukija.lueAsunnot(tiedosto).keySet().size());
        assertEquals(2, this.lukija.lueAsunnot(tiedosto).get("AKT 4").size()); 
    }
    
    @Test
    public void kunMapissaKaksiEriTalonAsuntoaKirjoittaaTiedostoonKaksi() throws IOException {
        String tiedosto = "testitiedostot/kirjoitusTestasunnot.txt";
        this.kirjoittaja.tallennaAsunnot("testitiedostot/kirjoitusTestasunnot.txt", luoMapJossaKaksiEriTalonAsuntoa());
        assertEquals(2, this.lukija.lueAsunnot(tiedosto).keySet().size());
        assertEquals(1, this.lukija.lueAsunnot(tiedosto).get("AKT 4").size()); 
        assertEquals(1, this.lukija.lueAsunnot(tiedosto).get("RLT 5").size()); 
    }
    
    //asukkaat
    @Test
    public void kunMapissaNollaAsukastaTiedostossaEiAsukkaita() throws IOException {
        String tiedosto = "testitiedostot/kirjoitusTestvuokralaiset.txt";
        this.kirjoittaja.tallennaAsukkaat(tiedosto, asukkaat);
        assertEquals(true, this.lukija.lueAsukkaat(tiedosto).isEmpty());
    }
    
    @Test
    public void kunMapissaYksiAsukasKirjoittaaTiedostoonYhden() throws IOException {
        String tiedosto = "testitiedostot/kirjoitusTestvuokralaiset.txt";
        this.kirjoittaja.tallennaAsukkaat(tiedosto, luoMapJossaYksiAsukas());
        assertEquals(1, this.lukija.lueAsukkaat(tiedosto).keySet().size());
    }
    
    @Test
    public void kunMapissaKaksiAsukastaKirjoittaaTiedostoonKaksi() throws IOException {
        String tiedosto = "testitiedostot/kirjoitusTestvuokralaiset.txt";
        this.kirjoittaja.tallennaAsukkaat(tiedosto, luoMapJossaKaksiAsukasta());
        assertEquals(2, this.lukija.lueAsukkaat(tiedosto).keySet().size());
    }
    
    
    //vuokrasopimukset
    @Test
    public void kunListassaNollaVuokrasopimustaTiedostossaEiSopimuksia() throws IOException {
        String tiedosto = "testitiedostot/kirjoitusTestsopimukset.txt";
        this.kirjoittaja.tallennaVuokrasopimukset(tiedosto, vuokrasopimukset);
        assertEquals(true, this.lukija.lueVuokrasopimukset(asukkaat, asunnot, tiedosto).isEmpty());
    }
    
    @Test
    public void kunListassaYksiVuokrasopimusTiedostossaYksiSopimus() throws IOException {
        String tiedosto = "testitiedostot/kirjoitusTestsopimukset.txt";
        this.kirjoittaja.tallennaVuokrasopimukset(tiedosto, luoListaJossaYksiVuokrasopimus());
        assertEquals(1, this.lukija.lueVuokrasopimukset(luoMapJossaYksiAsukas(), luoMapJossaYksiAsunto(), tiedosto).size());
    }
    
    // apumetodeja
    public Map<String, Asukas> luoMapJossaYksiAsukas() {
        this.asukkaat = this.lukija.lueAsukkaat("testitiedostot/vuokralaisia1.txt");
        return this.asukkaat;
    }
    
    public Map<String, Asukas> luoMapJossaKaksiAsukasta() {
        this.asukkaat = this.lukija.lueAsukkaat("testitiedostot/vuokralaisia2.txt");
        return this.asukkaat;
    }
    
    public List<Vuokrasopimus> luoListaJossaYksiVuokrasopimus() {
        this.vuokrasopimukset = this.lukija.lueVuokrasopimukset(luoMapJossaYksiAsukas(), luoMapJossaYksiAsunto(), "testitiedostot/sopimuksia1.txt");
        return this.vuokrasopimukset;
    }
    
    public Map<String, ArrayList<Asunto>> luoMapJossaYksiAsunto() {
        this.asunnot = this.lukija.lueAsunnot("testitiedostot/asuntoja1.txt");
        return this.asunnot;
    }
    
    public Map<String, ArrayList<Asunto>> luoMapJossaKaksiSamanTalonAsuntoa(){
        this.asunnot = this.lukija.lueAsunnot("testitiedostot/asuntoja2.txt");
        return this.asunnot;
    }
    
    public Map<String, ArrayList<Asunto>> luoMapJossaKaksiEriTalonAsuntoa(){
        this.asunnot = this.lukija.lueAsunnot("testitiedostot/asuntoja2EriTalo.txt");
        return this.asunnot;
    }
}
