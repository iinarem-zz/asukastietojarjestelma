package asukastietojarjestelma.domain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Luokka ohjaa asukastietojärjestelmää ja sisältää metodikutsut, joilla muita
 * luokka käskytetään
 */
public class JarjestelmanOhjaus {
    /* ... */

    private String asukasTiedosto;
    private String asuntoTiedosto;
    private String sopimusTiedosto;
    private Map<String, Asukas> asukkaat;
    private Map<String, ArrayList<Asunto>> asunnot;
    private List<Vuokrasopimus> vuokrasopimukset;
    private Scanner lukija;
    private TiedostonLukija tiedostonLukija;
    private TiedostonKirjoittaja tiedostonKirjoittaja;

    public JarjestelmanOhjaus() {
        this.tiedostonLukija = new TiedostonLukija();
        this.lukija = new Scanner(System.in);
        this.asukasTiedosto = "vuokralaiset.txt";
        this.asuntoTiedosto = "asunnot.txt";
        this.sopimusTiedosto = "sopimukset.txt";
        this.asukkaat = this.tiedostonLukija.lueAsukkaat(this.asukasTiedosto);
        this.asunnot = this.tiedostonLukija.lueAsunnot(this.asuntoTiedosto);
        this.vuokrasopimukset = this.tiedostonLukija.lueVuokrasopimukset(this.asukkaat, this.asunnot, this.sopimusTiedosto);
        this.tiedostonKirjoittaja = new TiedostonKirjoittaja();
    }

    /**
     * Metodi käynnistää asukastietojärjestelmän
     *
     * @see
     * asukastietojarjestelma.domain.JarjestelmanOhjaus#ohjelmanKomentojenTulostus()
     * @see
     * asukastietojarjestelma.domain.JarjestelmanOhjaus#toimintojenOhjaus(java.lang.String)
     *
     */
    public void suorita() {
        while (true) {
            ohjelmanKomentojenTulostus();
            String komento = kysymystenEsittaja("Syötä komento: ");
            System.out.println("");
            toimintojenOhjaus(komento);
            System.out.println("");

            if (komento.equals("x")) {
                System.out.println("");
                System.out.println("Kiitos näkemiin!");
                break;
            }
            System.out.println();
        }
    }

    /**
     * Apumetodi tulostaa asukastietojärjestelmän tekstikäyttöliittymän
     * peruskomennot
     *
     * @see asukastietojarjestelma.domain.JarjestelmanOhjaus#suorita()
     *
     */
    private void ohjelmanKomentojenTulostus() {
        System.out.println("Komennot:"
                + "\n 1 tulosta asunnot"
                + "\n 2 tulosta asukkaat"
                + "\n 3 tulosta sopimukset"
                + "\n 4 näytä ja muokkaa asukkaan tietoja"
                + "\n 5 näytä asunnon tiedot"
                + "\n 6 näytä vapaat asunnot"
                + "\n 7 uusi vuokrasopimus"
                + "\n x lopeta\n");
    }

    /**
     * Apumetodi ohjaa asukastietojärjestelmää tekstikäyttöliittymän
     * peruskomennoilla
     *
     * @see asukastietojarjestelma.domain.JarjestelmanOhjaus#suorita()
     *
     */
    private void toimintojenOhjaus(String komento) {
        if (komento.equals("1")) {
            this.tulostaAsunnot();
        } else if (komento.equals("2")) {
            this.tulostaAsukkaat();
        } else if (komento.equals("3")) {
            this.tulostaSopimukset();
        } else if (komento.equals("4")) {
            this.asukkaanTiedot();
        } else if (komento.equals("5")) {
            this.asunnonTietojenHakeminen();
        } else if (komento.equals("6")) {
            this.tulostaVapaatAsunnot();   
        } else if (komento.equals("7")) {
            this.uusiVuokrasopimus();
        }
    }

    //ASUKKAAN TIEDOT
    /**
     * Metodi joka etsii yksittäisen asukaan tiedot
     *
     * @see
     * asukastietojarjestelma.domain.JarjestelmanOhjaus#haluatkoMuokataTietoja()
     *
     */
    public void asukkaanTiedot() {
        //virheellisten syötteiden käsittely!
        String hlotunnus = kysymystenEsittaja("Syötä henkilötunnus: ");

        if (this.asukkaat.containsKey(hlotunnus)) {
            System.out.println("");
            System.out.println(this.asukkaat.get(hlotunnus));
            System.out.println("");
            if (haluatkoMuokataTietoja()) {
                asukkaanTietojenMuokkaaminen(this.asukkaat.get(hlotunnus));
            }
        } else {
            System.out.println("Järjestelmässä ei ole etsittyä asukasta.");
        }

    }

    /**
     * Apumetodi joka kysyy haluaako käyttäjä muokata asukkaan tietoja
     *
     * @see
     * asukastietojarjestelma.domain.JarjestelmanOhjaus#asunnonTietojenHakeminen()
     *
     * @return tiedon siitä halutaanko tietoja muokata vai ei.
     */
    private boolean haluatkoMuokataTietoja() {
        String vastaus = kysymystenEsittaja("Haluatko muokata asukkaan tietoja (y/n): ");

        if (vastaus.equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Apumetodi joka palauttaa käyttäjän vastauksen parametrina annettuun
     * kysymykseen
     *
     * @param kysymys Esitettävä kysymys
     *
     * @return Käyttäjän vastauksen kysymykseen.
     */
    public String kysymystenEsittaja(String kysymys) {
        System.out.print(kysymys);
        String vastaus = this.lukija.nextLine();

        return vastaus;
    }

    /**
     * Metodi jonka avulla muokataan asukkaan tietoja
     *
     * @param a Asukas, jonka tietoja muokataan
     *
     * @see
     * asukastietojarjestelma.domain.JarjestelmanOhjaus#muokkausValikonTulostus()
     * @see
     * asukastietojarjestelma.domain.JarjestelmanOhjaus#nimenMuokkaus(asukastietojarjestelma.domain.Asukas)
     * @see
     * asukastietojarjestelma.domain.JarjestelmanOhjaus#puhelinNronMuokkaus(asukastietojarjestelma.domain.Asukas)
     * @see
     * asukastietojarjestelma.domain.JarjestelmanOhjaus#emailinMuokkaus(asukastietojarjestelma.domain.Asukas)
     * @see
     * asukastietojarjestelma.domain.JarjestelmanOhjaus#vuokrasopimuksenPaattaminen(asukastietojarjestelma.domain.Vuokrasopimus)
     * @see
     * asukastietojarjestelma.domain.JarjestelmanOhjaus#uudenOsoitteenAsettaminenPoisMuuttaessa(asukastietojarjestelma.domain.Asukas)
     *
     */
    public void asukkaanTietojenMuokkaaminen(Asukas a) {
        System.out.println("");
        while (true) {
            muokkausValikonTulostus();

            String muutetaan = this.lukija.nextLine();

            if (muutetaan.equals("a")) {
                nimenMuokkaus(a);
            } else if (muutetaan.equals("b")) {
                puhelinNronMuokkaus(a);
            } else if (muutetaan.equals("c")) {
                emailinMuokkaus(a);
            } else if (muutetaan.equals("d")) {
                vuokrasopimuksenPaattaminen(a.getNykyinenVuokrasopimus());
                uudenOsoitteenAsettaminenPoisMuuttaessa(a);
            } else if (muutetaan.equals("x")) {
                break;
            }
        }
    }
    
    /**
     * Metodi jolla tulostetaan asukkaantietojen muokkaamiseen liittyvät
     * komennot
     *
     */
    private void muokkausValikonTulostus() {
        System.out.println("Mitä muokataan?\n"
                + "a. nimi\n b. puhelinnumero\n"
                + "c. e-mail\n d. vuokrasopimuksen päättäminen\n"
                + "e. poista asukkaan tiedot"
                + "x. poistu");
    }

    /**
     * Metodi jonka avulla asukkaan tietoihin asennetaan uusi osoite, jos hän
     * muuttaa pois Säätiön asunnoista
     *
     * @param a Asukas, jonka tietoja muokataan
     *
     *
     */
    private void uudenOsoitteenAsettaminenPoisMuuttaessa(Asukas a) {
        String vastaus = kysymystenEsittaja("Haluatko syöttää uuden osoitteen (y/n): ");
        if (vastaus.equals("y")) {
            String osoite = kysymystenEsittaja("Uusi osoite: ");
            a.setOsoite(osoite);
        }
    }

    /**
     * Metodi jonka avulla asetataan asukkaalle uusi sähköpostiosoite
     *
     * @param a Asukas, jonka tietoja muokataan
     *
     */
    private void emailinMuokkaus(Asukas a) {
        String email = kysymystenEsittaja("Uusi e-mail: ");
        a.setEmail(email);
    }

    /**
     * Metodi jonka avulla asetataan asukkaalle uusi puhelinnumero
     *
     * @param a Asukas, jonka tietoja muokataan
     *
     */
    private void puhelinNronMuokkaus(Asukas a) {
        String puh = kysymystenEsittaja("Uusi puhelinnumero: ");
        a.setPuhelinnumero(puh);
    }

    /**
     * Metodi jonka avulla asetataan asukkaalle uusi nimi
     *
     * @param a Asukas, jonka tietoja muokataan
     *
     */
    private void nimenMuokkaus(Asukas a) {
        String enimi = kysymystenEsittaja("Etunimi: ");
        String snimi = kysymystenEsittaja("Sukunimi: ");
        a.setNimi(enimi, snimi);
    }
    
    /**
     * Metodi joka poistaa asukkaan tiedot järjestelmästä
     *
     * @param a Asukas, joka poistetaan
     *
     */
    public void poistaAsukas(Asukas a) {
        if (a.onkoVuokrasopimusVoimassa()) {
            System.out.println("Asukkaalla on voimassa oleva vuokrasopimus, asukasta ei voida poistaa. Päätä ensin vuokrasopimus.");
            this.vuokrasopimuksenPaattaminen(a.getNykyinenVuokrasopimus());
        } else {
            HashMap<String, Asukas> uusiAsukasLista = new HashMap<String, Asukas>();
            for (String avain : this.asukkaat.keySet()){
                if (avain.equals(a.getHlotunnus())) {
                    continue;
                }
                uusiAsukasLista.put(avain, this.asukkaat.get(avain));
            }
            this.asukkaat = uusiAsukasLista;
        }
        
    }

    //ASUNNON TIEDOT
    /**
     * Metodi yksittäisen asunnon tietojen hakemiseen
     *
     * @see
     * asukastietojarjestelma.domain.JarjestelmanOhjaus#asunnonTietojenTulostaminen(java.lang.String)
     *
     */
    public void asunnonTietojenHakeminen() {
        System.out.println("");
        String talo = kysymystenEsittaja("Syötä talon katuosoite: ");
        if(onkoTaloJarjestelmassa(talo)) {
            asunnonTietojenTulostaminen(talo);
        }
    }

    private boolean onkoTaloJarjestelmassa(String talo) {
        if (this.asunnot.containsKey(talo)) {
            return true;
        } else {
            System.out.println("Järjestelmässä ei ole haettua taloa.");
            return false;
        }
    }

    /**
     * Metodi yksittäisen asunnon tietojen tulostamiseen
     *
     * @param talo Talo, josta asuntoa etsitään. Käyttäjän syöte.
     *
     */
    private void asunnonTietojenTulostaminen(String talo) {
        String asunnonNumero = kysymystenEsittaja("Syötä asunnon rappu ja numero (erottele välilyönnillä): ");
        int i = 0;
        for (Asunto a : this.asunnot.get(talo)) {
            i++;
            if (a.getAsuntonro().equals(asunnonNumero)) {
                System.out.println(a);
                break;
            } else if (i == this.asunnot.get(talo).size()) {
                System.out.println("talossa ei ole vastaavaa asuntoa.");
            }
        }
    }

    //VUOKRASOPIMUKSEN SOLMIMISEEN LIITTYVÄT
    /**
     * Metodi, joka uuden asukkaan lisäämiseen järjestelmään.
     *
     */
    public void lisaaAsukas() {
        System.out.println("");
        String hloTunnus = kysymystenEsittaja("Syötä henkilötunnus: ");

        if (this.asukkaat.containsKey(hloTunnus)) {
            System.out.println("Asukas on jo järjestelmässä");

        } else {
            Asukas asukas = asukkaanLuominen(hloTunnus);
            this.asukkaat.put(hloTunnus, asukas);
        }

    }

    /**
     * Metodi uuden Asukas-olion järjestelmään
     *
     * @param hloTunnus Asukkaan henkilötunnus. Käyttäjän syöte.
     *
     * @return palauttaa uuden Asukas-olion
     */
    private Asukas asukkaanLuominen(String hloTunnus) {
        String etunimi = kysymystenEsittaja("Syötä etunimi: ");
        String sukunimi = kysymystenEsittaja("Syötä sukunimi: ");
        String puh = kysymystenEsittaja("Syötä puhelinnumero: ");
        String email = kysymystenEsittaja("Syötä email: ");
        Asukas asukas = new Asukas(sukunimi, etunimi, hloTunnus, puh, email);
        return asukas;
    }
    /**
     * Metodi luo uuden Vuokrasopimuksen järjestelmään
     *
     */
    public void uusiVuokrasopimus() {
        String talo = kysymystenEsittaja("Mikä talo: ");
        String asunto = kysymystenEsittaja("Mikä asunto: ");
        
        if (onkoTaloJarjestelmassa(talo)){
            //onko asuntojärjestelmässä
            //jos on 
              //onko vapaa? 
                //jos on, hae asunnon koko --> määrää vuokrasopimuksen muodon
                //pyydä asukkaan tiedot (tai kahden tiedot)
                    //jos ei järjestelmässä, tiedot pitää syöttää.
                //luo vuokrasopimus
            //jos ei, halutaanko edellinen vuokrasopimus päättää?
            
        }
        System.out.println("Asuntoa ei ole järjestelmässä");
    }

    /**
     * Metodi päättää vuokrasopimuksen
     *
     * @param sopimus Päätettävä vuokrasopimus
     *
     */
    public void vuokrasopimuksenPaattaminen(Vuokrasopimus sopimus) {
        System.out.println("");
        String paattymispvm = kysymystenEsittaja("Syötä paattymispäivä (dd.mm.yyyy): ");
        sopimus.setPaattymispvm(paattymispvm);

    }

    // RAPORTIT
    /**
     * Metodi tulostaa kaikki järjestelmän asunnot tietoineen
     *
     */
    public void tulostaAsunnot() {
        for (String avain : this.asunnot.keySet()) {
            for (Asunto a : this.asunnot.get(avain)) {
                System.out.println(a);
                System.out.println("");
            }
            System.out.println("");
            
        }
    }

    /**
     * Metodi tulostaa kaikki järjestelmän asukkaat tietoineen
     *
     */
    public void tulostaAsukkaat() {
        for (String avain : this.asukkaat.keySet()) {
            System.out.println(this.asukkaat.get(avain));
            System.out.println("");
        }
    }

    /**
     * Metodi tulostaa kaikki järjestelmän vuokrasopimukset tietoineen
     *
     */
    public void tulostaSopimukset() {
        for (Vuokrasopimus s : this.vuokrasopimukset) {
            System.out.println(s);
            System.out.println("");
        }
    }

    /**
     * Metodi tulostaa kaikki järjestelmässä olevat vapaat asunnot
     *
     */
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
    /**
     * Metodi tallentaa järjestelmän asuntojen, asukkaiden ja vuokrasopimusten
     * tiedot tiedostoihin Sekä poistaa järjestelmästä asukkaat, joilla ei ole
     * voimassa olevaa vuokrasopimusta
     * 
     * @see asukastietojarjestelma.domain.JarjestelmanOhjaus#poistaAsukkaatJoillaEiOleVuokrasopimusVoimassa() 
     * 
     */
    public void tallennaTiedot() throws IOException {
        this.poistaAsukkaatJoillaEiOleVuokrasopimusVoimassa();
        this.tiedostonKirjoittaja.tallennaAsunnot(asuntoTiedosto, asunnot);
        this.tiedostonKirjoittaja.tallennaAsukkaat(asuntoTiedosto, asukkaat);
        this.tiedostonKirjoittaja.tallennaVuokrasopimukset(sopimusTiedosto, vuokrasopimukset);
    }
    
    /**
     * Metodi poistaa asukasmapistä kaikki ne asukkaat joiden vuokrasopimus ei ole voimassa.
     * Metodi on tallennaTiedot()-metodin apumetodi.
     * 
     */
    public void poistaAsukkaatJoillaEiOleVuokrasopimusVoimassa() {
        HashMap<String, Asukas> uusiAsukasLista = new HashMap<String, Asukas>();
        for (String avain : this.asukkaat.keySet()){
            if (this.asukkaat.get(avain).onkoVuokrasopimusVoimassa() == false) {
                continue;
            }
            uusiAsukasLista.put(avain, this.asukkaat.get(avain));
        }
            this.asukkaat = uusiAsukasLista;
    }
    
}
