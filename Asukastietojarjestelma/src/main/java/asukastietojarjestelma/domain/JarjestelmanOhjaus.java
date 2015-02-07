
package asukastietojarjestelma.domain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JarjestelmanOhjaus {
    private String asukasTiedosto;
    private String asuntoTiedosto;
    private String sopimusTiedosto;
    private Map<String, Asukas> asukkaat;
    private Map<String, ArrayList<Asunto>> asunnot;
    private List<Vuokrasopimus> vuokrasopimukset;
    private Scanner lukija;
    private TiedostonLukija tiedostonLukija;
    private TiedostonKirjoittaja tiedostonKirjoittaja;
    
    public JarjestelmanOhjaus(TiedostonLukija tiedostonLukija) {
        this.tiedostonLukija = tiedostonLukija;
        this.lukija = new Scanner(System.in);
        this.asukasTiedosto = "vuokralaiset.txt";
        this.asuntoTiedosto = "asunnot.txt";
        this.sopimusTiedosto = "sopimukset.txt";
        this.asukkaat = this.tiedostonLukija.lueAsukkaat(this.asukasTiedosto);
        this.asunnot = this.tiedostonLukija.lueAsunnot(this.asuntoTiedosto);
        this.vuokrasopimukset = this.tiedostonLukija.lueVuokrasopimukset(this.asukkaat, this.asunnot, this.sopimusTiedosto);
        this.tiedostonKirjoittaja = new TiedostonKirjoittaja();
    }
    
    public void suorita() {
        // Abstarkti komentoluokka ja jokainen komento omaksi sen toteuttavaksi luokaksi?
        while (true) {
            System.out.println("Komennot:\n 1 tulosta asunnot\n 2 tulosta asukkaat\n 3 tulosta sopimukset\n 4 näytä vapaat asunnot\n 5 näytä asukkaan tiedot\n\n x lopeta\n");
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
                this.tulostaSopimukset();
                System.out.println("");
            } else if (komento.equals("4")) {
                System.out.println("");
                this.tulostaVapaatAsunnot();
                System.out.println("");
            } else if (komento.equals("5")) {
                System.out.println("");
                this.asukkaanTiedot();   
            } else if (komento.equals("x")) {
                
                System.out.println("");
                System.out.println("Kiitos näkemiin!");
                break;
            }
            System.out.println();
        }
    }
    
    //ASUKKAAN TIEDOT
    
    public void asukkaanTiedot() {
        //virheellisten syötteiden käsittely!
        System.out.print("Syötä henkilötunnus: ");
        String hlotunnus = this.lukija.nextLine();
        
        if (this.asukkaat.containsKey(hlotunnus)) {
            System.out.println("");
            System.out.println(this.asukkaat.get(hlotunnus));
            System.out.println("");
            System.out.print("Haluatko muokata asukkaan tietoja (y/n): ");
            String vastaus = this.lukija.nextLine();

            if (vastaus.equals("y")) {
                asukkaanTietojenMuokkaaminen(this.asukkaat.get(hlotunnus));
            }
        } else {
            System.out.println("Järjestelmässä ei ole etsittyä asukasta.");
        }
        
    }
    
    public void asukkaanTietojenMuokkaaminen(Asukas a) {
        //virheellisten syötteiden käsittely!
        System.out.println("");
        while(true) {
            System.out.println("Mitä muokataan?\n a. Nimi\n b. puhelinnumero\n c. e-mail\n d. vuokrasopimuksen päättäminen\n x. poistu");
            String muutetaan = this.lukija.nextLine();

            if (muutetaan.equals("a")) {
                System.out.print("Etunimi: ");
                String enimi = this.lukija.nextLine();
                System.out.print("Sukunimi: ");
                String snimi = this.lukija.nextLine();
                a.setNimi(enimi, snimi);
            } else if (muutetaan.equals("b")) {
                System.out.print("Uusi puhelinnumero: ");
                String puh = this.lukija.nextLine();
                a.setPuhelinnumero(puh);
            } else if (muutetaan.equals("c")) {
                System.out.print("Uusi e-mail: ");
                String email = this.lukija.nextLine();
                a.setEmail(email);
            } else if (muutetaan.equals("d")) {
                vuokrasopimuksenPaattaminen(a.getNykyinenVuokrasopimus());
                System.out.print("Haluatko syöttää uuden osoitteen (y/n): ");
                String vastaus = this.lukija.nextLine();
                if (vastaus.equals("y")) {
                    System.out.print("Uusi osoite: ");
                    String osoite = this.lukija.nextLine();
                    a.setOsoite(osoite);
                }
            } else if (muutetaan.equals("x")) {
                break;
            }
        }
    }
    
    public void poistaAsukas() {
        //siirtää arkistoon?
    }
    
    //ASUNNON TIEDOT
    public void asunnonTiedot() {
        //virheellisten syötteiden käsittely!
        System.out.println("");
        System.out.print("Syötä talon katuosoite: ");
        String talo = this.lukija.nextLine();
        
        if (this.asunnot.containsKey(talo)) {
            System.out.print("Syötä asunnon rappu ja numero: ");
            String asunnonNumero = this.lukija.nextLine();
            for (Asunto a : this.asunnot.get(talo)) {
                if (a.getAsuntonro().equals(asunnonNumero)){
                    System.out.println(a);
                    break;
                }
            }
            System.out.println("talossa ei ole vastaavaa asuntoa.");
        } else {
            System.out.println("Järjestelmässä ei ole haettua taloa.");
        }
    }
    
    //asunnon aiemmat sopimukset
    
    //VUOKRASOPIMUKSEN SOLMIMISEEN LIITTYVÄT
    public void lisaaAsukas() {
        System.out.println("");
        System.out.print("Syötä henkilötunnus: ");
        String hloTunnus = this.lukija.nextLine();
        
        if (this.asukkaat.containsKey(hloTunnus)) {
            System.out.println("Asukas on jo järjestelmässä");
            
        } else {
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
            //uusiVuokrasopimus();
        }
        
    }
    
    public void uusiVuokrasopimus() {
        
    }
    
    public void vuokrasopimuksenPaattaminen(Vuokrasopimus sopimus){
        System.out.println("");
        System.out.print("Syötä paattymispäivä (dd.mm.yyyy): ");
        String paattymispvm = this.lukija.nextLine();
        // vertaile ettei ole ennen alkamispäivämäärää!
        sopimus.setPaattymispvm(paattymispvm);
        
    }
    
    // RAPORTIT
    public void tulostaAsunnot() {
        System.out.print(this.asunnot);
    }
    
    public void tulostaAsukkaat() {
        System.out.print(this.asukkaat);
    }
    
    public void tulostaSopimukset() {
        System.out.print(this.vuokrasopimukset);
    }
    
    public void tulostaVapaatAsunnot() {
        for (String avain : this.asunnot.keySet()) {
            for (Asunto a : this.asunnot.get(avain)) {
                if (!a.onkoVuokrattu()) {
                    System.out.println(a);
                    System.out.println("");
                }
            }
        }
    }
    
    // tiettynä aikana vapautuvat asunnot!
    
    //LOPETTAMINEN JA TALLENTAMINEN
    public void tallennaTiedot() throws IOException{
        this.tiedostonKirjoittaja.tallennaAsunnot(asuntoTiedosto, asunnot);
//        this.tiedostonKirjoittaja.tallennaAsukkaat(asuntoTiedosto, asukkaat);
//        this.tiedostonKirjoittaja.tallennaVuokrasopimukset(sopimusTiedosto, vuokrasopimukset);
    }
}
