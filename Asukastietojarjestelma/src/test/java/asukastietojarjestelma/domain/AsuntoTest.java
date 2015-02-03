package asukastietojarjestelma.domain;


import asukastietojarjestelma.domain.Asunto;
import asukastietojarjestelma.domain.Vuokrasopimus;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class AsuntoTest {
    private Asunto testi;
    private String alkupvm;
    private String loppupvm;
    
    public AsuntoTest() {
        this.testi = null;
        this.alkupvm = "01.10.2014";
        this.loppupvm = "31.03.2015";
    }
    
    @Before
    public void setUp() {
        this.testi = new Asunto("AKT 4", "C 21", 2, 10);
    }

    
    @Test
    public void konstruktoriLuoAsunnonOikein() {
        String vastaus = this.testi.toString();
        
        assertEquals("AKT 4 C 21: 2h 10.0m2", vastaus);
    }
    
    @Test
    public void asuntoEiOleAluksiVuokrattu() {
        assertEquals(false, this.testi.onkoVuokrattu());
    }
    
    @Test
    public void kunAsuntoVuokrataanSenStatusMuuttuuVuokratuksi() {
        Vuokrasopimus sopimus = null;
        if (this.testi.getHuonemaara() < 2) {
            sopimus = new VuokrasopimusSingle(this.testi, this.alkupvm, this.loppupvm);
        } else {
            sopimus = new VuokrasopimusCouple(this.testi, this.alkupvm, this.loppupvm);
        }
        this.testi.vuokraa(sopimus);
        
        assertEquals(true, this.testi.onkoVuokrattu());
    }
    
    @Test
    public void josAsuntoOnJoVuokrattuJarjestelmaHuomauttaa() {
        
    }
}
