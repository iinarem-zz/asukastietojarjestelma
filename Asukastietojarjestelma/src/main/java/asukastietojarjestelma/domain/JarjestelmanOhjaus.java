
package asukastietojarjestelma.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JarjestelmanOhjaus {
    //private List<Talo> talot; onko onko Talo-luokka sittenkin tarpeeton?
    private Map<String, Asukas> asukkaat;
    private Map<String, ArrayList<Asunto>> asunnot;
    private List<Vuokrasopimus> vuokrasopimukset;
    private Scanner lukija;
    private TiedostonLukija tiedostonLukija;
    
    public JarjestelmanOhjaus(TiedostonLukija tiedostonLukija) {
        //this.talot = new ArrayList<Talo>(); tarpeeton?
        this.tiedostonLukija = tiedostonLukija;
        this.lukija = new Scanner(System.in);
        
        this.asukkaat = this.tiedostonLukija.lueAsukkaat();
        this.asunnot = this.tiedostonLukija.lueAsunnot();
    }
    
    public void suorita() {
        // Abstarkti komentoluokka ja jokainen komento omaksi sen toteuttavaksi luokaksi?
        while (true) {
            System.out.println("Komennot:\n 1 lisää asunto\n 2 lisää asukas\n 3 tulosta asukkaat\n 4 näytä vapaat asunnot\n x lopeta\n");
            System.out.print("Syötä komento: ");
            String komento = this.lukija.nextLine();
            if (komento.equals("1")) {
                System.out.println("");
                //this.lisaaAsunto();
                System.out.println("");
            } else if (komento.equals("2")) {
                System.out.println("");
                this.lisaaAsukas();
                System.out.println("");
            } else if (komento.equals("3")) {
                System.out.println("");
                this.tulostaAsukkaat();
                System.out.println("");
            } else if (komento.equals("4")) {
                System.out.println("");
                //this.tulostaVapaatAsunnot();
                System.out.println("");
            } else if (komento.equals("x")) {
                System.out.println("");
                System.out.println("Kiitos näkemiin!");
                break;
            }
            System.out.println();
        }
    }
    
    //HAKUTOIMINNALLISUUKSIA
    
        // sellainen hakutoiminnallisuus, joka hakee tiettynä aikana päättyvät vuokrasopimukset!
        // asukkaiden hakeminen
        // asuntojen hakeminen
    
    // TIETOJEN TULOSTAMISEEN LIITTYVIÄ TOIMINTOJA
//    public void tulostaAsunnot() {
//        if (this.talot == null) {
//            System.out.println("Säätiö ei omista asuntoja!");
//        } else {
//            System.out.print(this.talot);
//        }
//    }
    
//    public void tulostaVapaatAsunnot() {
//        for (Talo t : this.talot) {
//            for (Asunto a : t.getAsunnot()) {
//                if (!a.onkoVuokrattu())
//                    System.out.println(a);
//            }
//        }
//    }
    
    //ASUKKAASEEN LIITTYVIÄ TOIMINTOJA
    
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
        
        //tarkoittaa samalla vuokrasopimuksen solmimista...mietittävä
    }
    
    public void tulostaAsukkaat() {
        System.out.print(this.asukkaat);
    }
    
    public void muokkaaAsukkaanTietoja() {
        // nimen muuttaminen
        // vuokrasopimuksen muuttaminen / päättäminen
    }
    
    public void poistaAsukas() {
        //siirtää arkistoon?
    }  
    
    // ASUNTOIHIN LIITTYVIÄ TOIMINTOJA
    public void muokkaaAsunnonTietoja() {
        
    }
    
}
