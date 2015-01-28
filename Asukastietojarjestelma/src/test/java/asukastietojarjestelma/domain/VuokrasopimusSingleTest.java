package asukastietojarjestelma.domain;


import asukastietojarjestelma.domain.Vuokrasopimus;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class VuokrasopimusSingleTest {
    private Vuokrasopimus soppari;
    
    public VuokrasopimusSingleTest() {
        this.soppari = null;
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void konstruktoriLuoSopimuksenOikein() {}
    
    @Test
    public void kunVuokrasopimukseenLisataanAsukasAsukasLisataan() {}
    
    @Test
    public void kunVuokrasopimukseenLisataanToinenAsukasEiOnnistu() {}
    
    @Test
    public void kunVuokrasopimustaVerrataanAiemminPaattyneeseenPalauttaaArvon() {}
    
    @Test
    public void kunVuokrasopimustaVerrataanMyohemminPaattyvaanPalauttaaArvon() {}
    
}
