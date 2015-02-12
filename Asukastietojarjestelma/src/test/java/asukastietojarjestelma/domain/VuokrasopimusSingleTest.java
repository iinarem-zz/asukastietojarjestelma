package asukastietojarjestelma.domain;


import asukastietojarjestelma.domain.Vuokrasopimus;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class VuokrasopimusSingleTest {
        private Vuokrasopimus soppari;
        private Asukas asukas;
        private Asunto asunto;
    
    public VuokrasopimusSingleTest() {
        this.soppari = null;
        this.asukas = new Asukas("Mehiläinen", "Maija", "123456-", "0000000", "maija.mehilainen@helsinki.fi");
        this.asunto = new Asunto("AKT 4", "C 4", 1, 20.0);
    }
    
    @Before
    public void setUp() {
        this.soppari = new VuokrasopimusSingle(asunto, "1.1.2015", "31.12.2016", asukas);

    }
    
    @Test
    public void konstruktoriLuoSopimuksenOikein() {
    assertEquals("Vuokrasopimuksen tiedot:\nVuokrattu asunto: AKT 4 C 4\nAsukas: Maija Mehiläinen\nVuokrasopimuksen voimassaolo: 1.1.2015 - 31.12.2016", soppari.toString());
    }
    
    @Test
    public void kunVuokrasopimusPaatetaanAlkuaMyohempanaPaivanaSePaattyy() {
        
    }
    
    @Test
    public void kunVuokrasopimusPaatetaanAlkuaAiempanaPaivanaPaattymisaikaEiMuutu() {
        
    }
    
    @Test
    public void kunVuokrasopimustaVerrataanAiemminPaattyneeseenPalauttaaArvon() {}
    
    
    @Test
    public void kunVuokrasopimustaVerrataanMyohemminPaattyvaanPalauttaaArvon() {}
    
}
