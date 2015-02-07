
package asukastietojarjestelma.domain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
    public void kunMapissaYksiAsuntoKirjoittaaTiedostoonYhden() throws IOException {
        File tiedosto = new File("testitiedostot/kirjoitusTestasunnot.txt");
        Asunto u = new Asunto("AKT 4", "C 1 a", 1, 10.5);
        ArrayList<Asunto> kampat = new ArrayList<Asunto>();
        kampat.add(u);
        this.asunnot.put("AKT 4", kampat);
        this.kirjoittaja.tallennaAsunnot("testitiedostot/kirjoitusTestasunnot.txt", this.asunnot);
        assertEquals(1, this.lukija.lueAsunnot(tiedosto).size());
        
    }
    
    @Test
    public void kunMapissaKaksiAsuntoKirjoittaaTiedostoonKaksi() throws IOException {
        File tiedosto = new File("testitiedostot/kirjoitusTestasunnot.txt");
        Asunto a = new Asunto("AKT 4", "C 1 a", 1, 10.5);
        Asunto b = new Asunto("AKT 4", "C 1 b", 1, 10.5);
        ArrayList<Asunto> kampat = new ArrayList<Asunto>();
        kampat.add(a);
        kampat.add(b);
        this.asunnot.put("AKT 4", kampat);
        this.kirjoittaja.tallennaAsunnot("testitiedostot/kirjoitusTestasunnot.txt", this.asunnot);
        assertEquals(2, this.lukija.lueAsunnot(tiedosto).size());
        
    }
    
    //asukkaat
    
    //vuokrasopimukset
}
