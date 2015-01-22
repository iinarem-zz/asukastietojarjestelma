
import asukastietojarjestelma.domain.Asukas;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AsukasTest {
    private Asukas uusi;
    
    public AsukasTest() {
        this.uusi = null;
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.uusi = new Asukas("Testihenkilö", "Iina", "101082", "044-1234567", "testiterhi@helsinki.fi");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kostruktoriLuoVuokralaisenOikein() {
        String vastaus = this.uusi.toString();
        
        assertEquals("nimi: Iina Testihenkilö", vastaus);
    }
    
    
}
