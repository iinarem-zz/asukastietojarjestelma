
import asukastietojarjestelma.domain.Asunto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class AsuntoTest {
    private Asunto testi;
    
    public AsuntoTest() {
        this.testi = null;
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.testi = new Asunto("C 21", "2h + kk");
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void konstruktoriLuoAsunnonOikein() {
        String vastaus = this.testi.toString();
        
        assertEquals("C 21: 2h + kk", vastaus);
    
    }
    
    @Test
    public void asuntoEiOleAluksiVuokrattu() {
        
        assertEquals(false, this.testi.onkoVuokrattu());
    
    }
}
