package asukastietojarjestelma.domain;


import asukastietojarjestelma.domain.Vuokrasopimus;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class VuokrasopimusCoupleTest {
    private Vuokrasopimus soppari;
    private Asukas asukas1;
    private Asukas asukas2;
    private Asunto asunto;
    
    public VuokrasopimusCoupleTest() {
        this.soppari = null;
        this.asukas1 = new Asukas("Mehiläinen", "Maija", "123456-", "0000000", "maija.mehilainen@helsinki.fi");
        this.asukas2 = new Asukas("Kimalainen", "Kimmo", "654321-", "0000000", "kimmo.kimalainen@helsinki.fi");
        this.asunto = new Asunto("RLT 5", "C 40", 2, 40.0);
    }
    
    @Before
    public void setUp() {
        this.soppari = new VuokrasopimusCouple(asunto, "1.1.2015", "31.12.2016", asukas1, asukas2);
    }
    
    @Test
    public void konstruktoriLuoSopimuksenOikein() {
    assertEquals("Vuokrasopimuksen tiedot:\nVuokrattu asunto: RLT 5 C 40\nAsukas: Maija Mehiläinen ja Kimmo Kimalainen\nVuokrasopimuksen voimassaolo: 1.1.2015 - 31.12.2016", soppari.toString());
    }
    
    @Test
    public void kunVuokrasopimustaVerrataanAiemminPaattyneeseenPalauttaaArvon() {}
    
    @Test
    public void kunVuokrasopimustaVerrataanMyohemminPaattyvaanPalauttaaArvon() {}
    
}
