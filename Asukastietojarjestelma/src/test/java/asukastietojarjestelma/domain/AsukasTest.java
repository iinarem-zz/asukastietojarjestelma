package asukastietojarjestelma.domain;


import asukastietojarjestelma.domain.Asukas;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AsukasTest {
    private Asukas uusi;
    
    public AsukasTest() {
        this.uusi = null;
    }
    
    @Before
    public void setUp() {
        this.uusi = new Asukas("Testihenkilö", "Iina", "101082", "044-1234567", "iina.testi@helsinki.fi");
    }

    @Test
    public void kostruktoriLuoVuokralaisenOikein() {
        String vastaus = this.uusi.toString();
        
        assertEquals("nimi: Iina Testihenkilö\nhenkilötunnus: 101082\npuhelinnro: 044-1234567\nemail: iina.testi@helsinki.fi\nosoite: ", vastaus);
    }
    
    @Test
    public void kunAsukastaVerrataanItseensaPalauttaaTrue() {
        assertEquals(true, this.uusi.equals(this.uusi)); 
    }
    
    @Test
    public void kunAsukastaVerrataanMuuhunPalauttaaTrue() {
        Asukas toinen = new Asukas("Testihenkilö", "Iina", "101084", "044-1234567", "iina.testi@helsinki.fi");
        
        assertEquals(false, this.uusi.equals(toinen)); 
    }
    
    //@Test vuokrasopimuksen päättämiseen liittyvät asiat
    
    
    
}
