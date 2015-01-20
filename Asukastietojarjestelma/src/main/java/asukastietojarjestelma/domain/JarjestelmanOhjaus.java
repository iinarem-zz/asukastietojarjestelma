
package asukastietojarjestelma.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JarjestelmanOhjaus {
    private Map<Talo, List<Asunto>> talot;
    private List<Asukas> asukkaat;
    private Scanner lukija;
    
    public JarjestelmanOhjaus() {
        // loppuvaiheessa talojen ja siten asuntojen tietojen lataaminen jostain...
        // loppuvaiheessa asukkaiden lataaminen jostain...
        
        this.talot = new HashMap<Talo, List<Asunto>>();
        this.asukkaat = new ArrayList<Asukas>();
        this.lukija = new Scanner(System.in);
    }
    
    public void suorita() {
        // järjestelmän toimintojen hoitaminen...
        
        while (true) {
            System.out.println("1 lisaa talon, 2 lisaa asukkaan, 3 tulostaa asunnot, x lopettaa");
            System.out.print("Syötä komento: ");
            String komento = this.lukija.nextLine();
            if (komento.equals("1")) {
                this.lisaaTalo();
            } else if (komento.equals("2")) {
                this.lisaaAsukas();
            } else if (komento.equals("3")) {
                this.tulostaAsunnot();
            } else if (komento.equals("x")) {
                System.out.println("Kiitos näkemiin!");
                break;
            }
            System.out.println();
        }
        
    }
    
    public void lisaaTalo(){
        System.out.print("Syötä talon nimi: ");
        String nimi = this.lukija.nextLine();
        this.talot.put(new Talo(nimi), new ArrayList<Asunto>());
        // asuntojen generoiminen...
        
        System.out.println("Talo luotu");
        
    }
    
    // vai pitäisikö jotenkin olla että muokkaa asunnon tietoja.
    public void lisaaAsunto() {
        
    }
    
    //tarvitseeko??
    public void muokkaaAsunnonTietoja() {
        
    }
    //tarvitseeko??
    public void poistaAsunto() {
        
    }
    
    // TIETOJEN TULOSTAMISEEN LIITTYVIÄ TOIMINTOJA
    
    public void tulostaAsunnot() {
        if (this.talot == null) {
            System.out.println("Säätiö ei omista asuntoja!");
        } else {
            System.out.print(this.talot);
        }
    }
    
    //ASUKKAASEEN LIITTYVIÄ TOIMINTOJA
    
    //tarkoittaa samalla vuokrasopimuksen solmimista
    public void lisaaAsukas() {
        System.out.println("Lisataan asukas");
        
    }
    
    public void muokkaaAsukkaanTietoja() {
        // nimen muuttaminen
        // vuokrasopimuksen muuttaminen / päättäminen
    }
    
    
    
    //poistaa tiedot järjestelmästä kokonaan...vaiko siirtää arkistoon?
    public void poistaAsukas() {
        
    }
    
}
