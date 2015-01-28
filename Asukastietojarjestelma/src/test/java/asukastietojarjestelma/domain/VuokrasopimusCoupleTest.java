package asukastietojarjestelma.domain;


import asukastietojarjestelma.domain.Vuokrasopimus;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class VuokrasopimusCoupleTest {
    private Vuokrasopimus soppari;
    
    public VuokrasopimusCoupleTest() {
        this.soppari = null;
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void konstruktoriLuoSopimuksenOikein() {}
    
    @Test
    public void kunVuokrasopimukseenLisataanAsukkaatAsukkaatLisataan() {}
    
    @Test
    public void kunVuokrasopimustaVerrataanAiemminPaattyneeseenPalauttaaArvon() {}
    
    @Test
    public void kunVuokrasopimustaVerrataanMyohemminPaattyvaanPalauttaaArvon() {}
    
}
