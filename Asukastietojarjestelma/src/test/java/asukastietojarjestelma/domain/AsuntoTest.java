package asukastietojarjestelma.domain;


import asukastietojarjestelma.domain.Asunto;
import asukastietojarjestelma.domain.Vuokrasopimus;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class AsuntoTest {
    private Asunto testi;
    
    public AsuntoTest() {
        this.testi = null;
    }
    
    @Before
    public void setUp() {
        this.testi = new Asunto("AKT 4", "C 21", 2, 10);
        this.testi.setVuokra(300);
    }

    
    @Test
    public void konstruktoriLuoAsunnonOikein() {
        String vastaus = this.testi.toString();
        assertEquals("AKT 4 C 21\n pohjaratkaisu: 2h 10.0m2\n vuokra: 300 euroa\n Asunto on vapaa", vastaus);
    }
    
    @Test
    public void asuntoEiOleAluksiVuokrattu() {
        assertEquals(false, this.testi.onkoVuokrattu());
    }
    
    @Test
    public void kunAsuntoVuokrataanSenStatusMuuttuuVuokratuksi() {
        Vuokrasopimus sopimus = null;
        Asukas asukas1 = new Asukas("Meikäläinen", "Maija", "123456", "0000000", "poo@helsinki.fi");
        Asukas asukas2 = new Asukas("Testaaja", "Tapani", "654321", "0000000", "tapani@helsinki.fi");
        if (this.testi.getHuonemaara() < 2) {
            sopimus = new VuokrasopimusSingle(this.testi, "01.01.2014", "31.12.2016", asukas1);
        } else {
            sopimus = new VuokrasopimusCouple(this.testi, "01.01.2014", "31.12.2016", asukas1, asukas2);
        }
        this.testi.vuokraa(sopimus);
        
        assertEquals(true, this.testi.onkoVuokrattu());
    }
    
    @Test
    public void josAsuntoVuokrataanAsetetaanVuokrasopimus() {
        Vuokrasopimus sopimus = null;
        Asukas asukas1 = new Asukas("Meikäläinen", "Maija", "123456", "0000000", "poo@helsinki.fi");
        Asukas asukas2 = new Asukas("Testaaja", "Tapani", "654321", "0000000", "tapani@helsinki.fi");
        if (this.testi.getHuonemaara() < 2) {
            sopimus = new VuokrasopimusSingle(this.testi, "01.01.2014", "31.12.2016", asukas1);
        } else {
            sopimus = new VuokrasopimusCouple(this.testi, "01.01.2014", "31.12.2016", asukas1, asukas2);
        }
        this.testi.vuokraa(sopimus);
        
        assertEquals(true, this.testi.onkoVuokrattu());
    }
    
    @Test
    public void josAsuntoOnJoVuokrattuSitaEiVoiVuokrata() {
        Vuokrasopimus sopimus = null;
        Asukas asukas1 = new Asukas("Meikäläinen", "Maija", "123456", "0000000", "maija.meikalainen@helsinki.fi");
        sopimus = new VuokrasopimusSingle(this.testi, "01.01.2014", "31.12.2016", asukas1);
        this.testi.vuokraa(sopimus);
        assertEquals(sopimus, this.testi.getVuokrasopimus());
    }
}
