
package asukastietojarjestelma.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JarjestelmanOhjaus {
    private Map<String, Asukas> asukkaat;
    private Map<String, ArrayList<Asunto>> asunnot;
    private List<Vuokrasopimus> vuokrasopimukset;
    private Scanner lukija;
    private TiedostonLukija tiedostonLukija;
    
    public JarjestelmanOhjaus(TiedostonLukija tiedostonLukija, File vuokralaiset, File asunnot) {
        this.tiedostonLukija = tiedostonLukija;
        this.lukija = new Scanner(System.in);
        this.asukkaat = this.tiedostonLukija.lueAsukkaat(vuokralaiset);
        this.asunnot = this.tiedostonLukija.lueAsunnot(asunnot);
        this.vuokrasopimukset = this.tiedostonLukija.lueVuokrasopimukset(this.asukkaat, this.asunnot);
    }
    
    public void suorita() {
        // Abstarkti komentoluokka ja jokainen komento omaksi sen toteuttavaksi luokaksi?
        while (true) {
            System.out.println("Komennot:\n 1 tulosta asunnot\n 2 tulosta asukkaat\n 3 lisaa asukkaat\n 4 näytä vapaat asunnot\n x lopeta\n");
            System.out.print("Syötä komento: ");
            String komento = this.lukija.nextLine();
            if (komento.equals("1")) {
                System.out.println("");
                this.tulostaAsunnot();
                System.out.println("");
            } else if (komento.equals("2")) {
                System.out.println("");
                this.tulostaAsukkaat();
                System.out.println("");
            } else if (komento.equals("3")) {
                System.out.println("");
                //this.lisaaAsukas();
                System.out.println("");
            } else if (komento.equals("4")) {
                System.out.println("");
                this.tulostaVapaatAsunnot();
                System.out.println("");
            } else if (komento.equals("x")) {
                System.out.println("");
                System.out.println("Kiitos näkemiin!");
                break;
            }
            System.out.println();
        }
    }
    
    //ASUKKAAN TIEDOT
    
    //yksittäisen asukkaan hakeminen
    //asukkaan tietojen muokkaaminen (nimi, osoite)
    //asukkaan vuokrasopimusten tarkasteleminen
    //sopimuksen päättäminen
    
    public void poistaAsukas() {
        //siirtää arkistoon?
    }
    
    //ASUNNON TIEDOT
    
    //yksittäisen asunnon hakeminen
    //asunnon voimassa-olevat tiedot
    //asunnon aiemmat sopimukset
    
    //UUDEN SOPIMUKSEN SOLMIMISEEN LIITTYVÄT
    
    public void lisaaAsukas() {
        System.out.println("");
        System.out.print("Syötä henkilötunnus: ");
        String hloTunnus = this.lukija.nextLine();
        
        // testaus onko jo järjestelmässä
        
        System.out.print("Syötä etunimi: ");
        String etunimi = this.lukija.nextLine();
        System.out.print("Syötä sukunimi: ");
        String sukunimi = this.lukija.nextLine();
        System.out.print("Syötä puhelinnumero: ");
        String puh = this.lukija.nextLine();
        System.out.print("Syötä email: ");
        String email = this.lukija.nextLine();
        
        Asukas asukas = new Asukas(sukunimi, etunimi, hloTunnus, puh, email);
        this.asukkaat.put(hloTunnus, asukas);
        
        //vuokrasopimuksen luominen
    }
    
    //HAKUTOIMINNALLISUUKSIA
    
        // asukkaiden hakeminen
        // asuntojen hakeminen
    
    
    // RAPORTIT
    public void tulostaAsunnot() {
        System.out.print(this.asunnot);
    }
    
    public void tulostaAsukkaat() {
        System.out.print(this.asukkaat);
    }
    
    public void tulostaVapaatAsunnot() {
        
        for (String avain : this.asunnot.keySet()) {
            for (Asunto a : this.asunnot.get(avain)) {
                System.out.println(a);
                System.out.println("");
            }
        }
    }
    
    //public void tulostaVuokrasopimukset() {
    //        System.out.println(this.vuokrasopimukset);
    //}
    
    // tiettynä aikana päättyvät vuokrasopimukset!
    // vapaat asunnot
    
    
    
}
