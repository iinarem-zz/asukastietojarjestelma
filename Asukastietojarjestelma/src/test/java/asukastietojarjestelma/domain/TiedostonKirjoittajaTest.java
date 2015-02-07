
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
    public void kunMapTyhjäTiedostoTyhjä() throws IOException {
        String tiedosto = "testitiedostot/kirjoitusTestasunnot.txt";
        this.kirjoittaja.tallennaAsunnot("testitiedostot/kirjoitusTestasunnot.txt", this.asunnot);
        assertEquals(true, this.lukija.lueAsunnot(tiedosto).isEmpty());
    }
    
    
    @Test
    public void kunMapissaYksiAsuntoKirjoittaaTiedostoonYhden() throws IOException {
        String tiedosto = "testitiedostot/kirjoitusTestasunnot.txt";
        Asunto u = new Asunto("AKT 4", "C 1 a", 1, 10.5);
        ArrayList<Asunto> kampat = new ArrayList<Asunto>();
        kampat.add(u);
        this.asunnot.put("AKT 4", kampat);
        this.kirjoittaja.tallennaAsunnot("testitiedostot/kirjoitusTestasunnot.txt", this.asunnot);
        assertEquals(1, this.lukija.lueAsunnot(tiedosto).keySet().size());
        assertEquals(1, this.lukija.lueAsunnot(tiedosto).get("AKT 4").size()); 
    }
    
    @Test
    public void kunMapissaKaksiSamanTalonAsuntoaKirjoittaaTiedostoonKaksi() throws IOException {
        String tiedosto = "testitiedostot/kirjoitusTestasunnot.txt";
        Asunto a = new Asunto("AKT 4", "C 1 a", 1, 10.5);
        a.setVuokra(200);
        Asunto b = new Asunto("AKT 4", "C 1 b", 1, 10.5);
        b.setVuokra(350);
        ArrayList<Asunto> kampat = new ArrayList<Asunto>();
        kampat.add(a);
        kampat.add(b);
        this.asunnot.put("AKT 4", kampat);
        this.kirjoittaja.tallennaAsunnot("testitiedostot/kirjoitusTestasunnot.txt", this.asunnot);
        assertEquals(1, this.lukija.lueAsunnot(tiedosto).keySet().size());
        assertEquals(2, this.lukija.lueAsunnot(tiedosto).get("AKT 4").size()); 
    }
    
    @Test
    public void kunMapissaKaksiEriTalonAsuntoaKirjoittaaTiedostoonKaksi() throws IOException {
        String tiedosto = "testitiedostot/kirjoitusTestasunnot.txt";
        Asunto a = new Asunto("AKT 4", "C 1 a", 1, 10.5);
        a.setVuokra(200);
        ArrayList<Asunto> kampat1 = new ArrayList<Asunto>();
        kampat1.add(a);
        Asunto b = new Asunto("RLT 5", "A 1", 1, 10.5);
        b.setVuokra(350);
        ArrayList<Asunto> kampat2 = new ArrayList<Asunto>();
        kampat2.add(b);
        this.asunnot.put("AKT 4", kampat1);
        this.asunnot.put("RLT 5", kampat2);
        this.kirjoittaja.tallennaAsunnot("testitiedostot/kirjoitusTestasunnot.txt", this.asunnot);
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
        Asukas a = new Asukas("Testaaja", "Taneli", "123456-", "000-00000", "taneli.testaaja@helsinki.fi");
        this.asukkaat.put("123456-", a);
        this.kirjoittaja.tallennaAsukkaat(tiedosto, asukkaat);
        assertEquals(1, this.lukija.lueAsukkaat(tiedosto).keySet().size());
    }
    
    @Test
    public void kunMapissaKaksiAsukastaKirjoittaaTiedostoonYhden() throws IOException {
        String tiedosto = "testitiedostot/kirjoitusTestvuokralaiset.txt";
        Asukas a = new Asukas("Testaaja", "Taneli", "123456-", "000-00000", "taneli.testaaja@helsinki.fi");
        this.asukkaat.put("123456-", a);
        Asukas b = new Asukas("Mallikas", "Maija", "987456-", "000-00000", "maija.mallikas@helsinki.fi");
        this.asukkaat.put("987456-", b);
        this.kirjoittaja.tallennaAsukkaat(tiedosto, asukkaat);
        assertEquals(2, this.lukija.lueAsukkaat(tiedosto).keySet().size());
    }
    
    
    //vuokrasopimukset
}
