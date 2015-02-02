
package asukastietojarjestelma.domain;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TiedostonLukijaTest {
    private TiedostonLukija lukija;
    private File nollaAsukasta;
    private File yksiAsukas;
    private File kaksiAsukasta;
    
    public TiedostonLukijaTest() {
        this.lukija = null;
        this.nollaAsukasta = new File("testitiedostot/vuokralaisia0.txt");
        this.yksiAsukas = new File("testitiedostot/vuokralaisia1.txt");
        this.kaksiAsukasta = new File("testitiedostot/vuokralaisia2.txt");
    }
    
    @Before
    public void setUp() {
        this.lukija = new TiedostonLukija();
    }
    
    //Vuokralaisten lukeminen
//    @Test
    public void lukijaLukeeVuokralaisTiedostonJokaOnTyhjaPalauttaaTyhjanMapin() {
        HashMap asukkaat = this.lukija.lueAsukkaat(this.nollaAsukasta);
        assertEquals(true, asukkaat.isEmpty());
    }
    
    @Test
    public void lukijaLukeeVuokralaisTiedostonJaTiedostossaYksiVuokralainenMapissaYksiVuokralainen() {
        HashMap asukkaat = this.lukija.lueAsukkaat(this.yksiAsukas);
        assertEquals(1, asukkaat.size());
    }
    
    @Test
    public void lukijaLukeeVuokralaisTiedostonJaTiedostossaKaksiVuokralaistaMapissaKaksiVuokralaista() {
        HashMap asukkaat = this.lukija.lueAsukkaat(this.kaksiAsukasta);
        assertEquals(2, asukkaat.size());
    }
    
    //Asuntojen lukeminen
    @Test
    public void lukijaLukeeAsuntoTiedostonJokaOnTyhjaPalauttaaTyhjanMapin() {
//        HashMap asukkaat = this.lukija.lueAsukkaat(); pitää muuttaa metodi sellaiseksi että saa tiedoston
//        assertEquals(0, asukkaat.size());
    }
    
    @Test
    public void lukijaLukeeAsuntoTiedostonJaTiedostossaYksiAsuntoMapissaYksiAsunto() {
//        metodi muutettava sellaiseksi, että saa muuttujana tiedoston
    }
    
    @Test
    public void lukijaLukeeAsuntoTiedostonJaTiedostossaKaksiSamanTalonAsuntoaMapissaYksiAvainjaKaksiAsuntoa() {
//        metodi muutettava sellaiseksi, että saa muuttujana tiedoston
    }
    
    @Test
    public void lukijaLukeeAsuntoTiedostonJaTiedostossaKaksiEriTalonAsuntoaMapissaKaksiAvaintajaKaksiAsuntoa() {
//        metodi muutettava sellaiseksi, että saa muuttujana tiedoston
    }
    
    //Vuokrasopimusten lukeminen
//    @Test
//    public void lukijaLukeeSopimustiedoston() {
//        metodi muutettava sellaiseksi, että saa muuttujana tiedoston
//    }
    
//    @Test
//    public void () {
//        metodi muutettava sellaiseksi, että saa muuttujana tiedoston
//    }
}
