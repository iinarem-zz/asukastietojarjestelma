
package asukastietojarjestelma.domain;

import java.util.HashMap;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TiedostonLukijaTest {
    private TiedostonLukija lukija;
    
    public TiedostonLukijaTest() {
        this.lukija = null;
    }
    
    @Before
    public void setUp() {
        this.lukija = new TiedostonLukija();
    }
    
    @Test
    public void konstruktoriLuoLuokanOikein() {
        
    }
    
    @Test
    public void lukijaLukeeVuokralaisTiedostonJaLuoAsukkaanKunAsukkaitaYksi() {
        HashMap asukkaat = this.lukija.lueAsukkaat();
        assertEquals(1, asukkaat.size());
    }
    
    @Test
    public void lukijaLukeeVuokralaisTiedostonJaLuoAsukkaatKunAsukkaitaKaksi() {
        //pitäisikin varmaan lähettää ne tiedostot, jotta voisi testailla eri kokoisia.
    }
}
