package asukastietojarjestelma.domain;


import asukastietojarjestelma.domain.Asunto;
import asukastietojarjestelma.domain.Vuokrasopimus;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class AsuntoTest {
    private Asunto testi;
    private Date alkupvm;
    private Date loppupvm;
    
    public AsuntoTest() {
        this.testi = null;
        this.alkupvm = new Date(2014, 10, 1);
        this.loppupvm = new Date(2015, 3, 31);
    }
    
    @Before
    public void setUp() {
        this.testi = new Asunto("C 21", 2, 10);
    }

    
    @Test
    public void konstruktoriLuoAsunnonOikein() {
        String vastaus = this.testi.toString();
        
        assertEquals("C 21: 2h 10.0m2", vastaus);
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
