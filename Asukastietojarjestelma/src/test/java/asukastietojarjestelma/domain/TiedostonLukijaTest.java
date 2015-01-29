
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
    
    //Vuokralaisten lukeminen
    @Test
    public void lukijaLukeeVuokralaisTiedostonJokaOnTyhjaPlauttaaTyhjanMapin() {
//        HashMap asukkaat = this.lukija.lueAsukkaat(); pitää muuttaa metodi sellaiseksi että saa tiedoston
//        assertEquals(0, asukkaat.size());
    }
    
    @Test
    public void lukijaLukeeVuokralaisTiedostonJaTiedostossaYksiVuokralainenMapissaYksiVuokralainen() {
//        HashMap asukkaat = this.lukija.lueAsukkaat(); pitää muuttaa metodi sellaiseksi että saa tiedoston
//        assertEquals(1, asukkaat.size());
    }
    
    @Test
    public void lukijaLukeeVuokralaisTiedostonJaTiedostossaViisiVuokralaistaMapissaViisiVuokralaista() {
//        HashMap asukkaat = this.lukija.lueAsukkaat(); pitää muuttaa metodi sellaiseksi että saa tiedoston
//        assertEquals(5, asukkaat.size());
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
