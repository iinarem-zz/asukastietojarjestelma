
package asukastietojarjestelma.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JarjestelmanOhjaus {
    private List<Talo> talot;
    private Map<String, Asukas> asukkaat; //olisiko parempi luoda oma asukasrekisteriluokkansa
    private List<Vuokrasopimus> vuokrasopimukset;
    private Scanner lukija;
    private TiedostonLukija tiedostonLukija;
    
    public JarjestelmanOhjaus(TiedostonLukija tiedostonLukija) {
        this.talot = new ArrayList<Talo>();
        this.tiedostonLukija = tiedostonLukija;
        this.asukkaat = this.tiedostonLukija.lueAsukkaat();
        this.lukija = new Scanner(System.in);
        
    }
    
    public void suorita() {
        // Pitäisi ehkä luoda oma komentoluokka (abstrakti) ja jokainen komento omaksi luokakseen.
        while (true) {
            System.out.println("Komennot:\n 1 lisää asunto\n 2 lisää asukas\n 3 tulosta asukkaat\n 4 näytä vapaat asunnot\n x lopeta\n");
            System.out.print("Syötä komento: ");
            String komento = this.lukija.nextLine();
            if (komento.equals("1")) {
                this.lisaaAsunto();
            } else if (komento.equals("2")) {
                this.lisaaAsukas();
            } else if (komento.equals("3")) {
                this.tulostaAsukkaat();
            } else if (komento.equals("4")) {
                this.tulostaVapaatAsunnot();
            } else if (komento.equals("x")) {
                System.out.println("Kiitos näkemiin!");
                break;
            }
            System.out.println();
        }
    }
    
    public void lisaaTalo(String osoite){
        this.talot.add(new Talo(osoite));
        System.out.println("Talo luotu järjestelmään, voit lisätä asunnot");
    }
    
    public void lisaaAsunto() {
        System.out.println("");
        System.out.print("Syötä talon katuosoite: ");
        String osoite = this.lukija.nextLine();
        // tarvitseeko testata onko talo jo järjestelmässä, jos loppukäkdessä ladataan tiedostosta?
        if (this.talot == null) {
            this.lisaaTalo(osoite);
        }
         
        System.out.print("Syötä asunnon rappu ja numero: ");
        String numero = this.lukija.nextLine();
        System.out.print("Asunnon huonemuoto: ");
        String huonemuoto = this.lukija.nextLine();
        
        // tarvitseeko testata onko asunto jo järjestelmässä, jos loppukädessä ladataan tiedostosta?
        //Asunnon luominen tähän!
    }
    
    //tarvitseeko?
    public void muokkaaAsunnonTietoja() {
        
    }
    
    // TIETOJEN TULOSTAMISEEN LIITTYVIÄ TOIMINTOJA
    
    public void tulostaAsunnot() {
        if (this.talot == null) {
            System.out.println("Säätiö ei omista asuntoja!");
        } else {
            System.out.print(this.talot);
        }
    }
    
    public void tulostaVapaatAsunnot() {
        for (Talo t : this.talot) {
            for (Asunto a : t.getAsunnot()) {
                if (!a.onkoVuokrattu())
                    System.out.println(a);
            }
        }
        // tähän liittyen pitäisi tehdä sellainen hakutoiminnallisuus, joka hakee tiettynä aikana päättyvät
        // vuokrasopimukset!
    }
    
    //ASUKKAASEEN LIITTYVIÄ TOIMINTOJA
    
    public void lisaaAsukas() {
        System.out.println("");
        System.out.print("Syötä henkilötunnus: ");
        String hloTunnus = this.lukija.nextLine();
        // toteuta tähän testaus onko jo järjestelmässä
        
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
        //poistaa tiedot järjestelmästä kokonaan...vaiko siirtää arkistoon?
        //asukashistoria olisi tarpeellinen kyllä
        
    }  
}
