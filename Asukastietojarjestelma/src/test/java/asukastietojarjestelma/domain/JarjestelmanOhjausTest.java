package asukastietojarjestelma.domain;


import asukastietojarjestelma.domain.JarjestelmanOhjaus;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JarjestelmanOhjausTest {
    private JarjestelmanOhjaus ohjaus;
    
    public JarjestelmanOhjausTest() {
        this.ohjaus = null;
    }
    
    @Before
    public void setUp() {
        this.ohjaus = new JarjestelmanOhjaus();
    }
    
    @Test
    public void palauttaaKayttajanVastauksenEsitettyynKysymykseen() {
        // näitä en osaa testata, koska vaatii käyttäjän syötteitä!
    }
}
