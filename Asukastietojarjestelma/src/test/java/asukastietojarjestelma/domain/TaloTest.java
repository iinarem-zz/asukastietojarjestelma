package asukastietojarjestelma.domain;


import asukastietojarjestelma.domain.Talo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaloTest {
    private Talo talo;
    
    public TaloTest() {
        this.talo = null;
    }
    
    @Before
    public void setUp() {
        this.talo = new Talo("Antti Korpin tie 4");
    }
    
    @Test
    public void kostruktoriLuoTalonOikein() {
        String vastaus = this.talo.getOsoite();
        
        assertEquals("Antti Korpin tie 4", vastaus);
    }
}
