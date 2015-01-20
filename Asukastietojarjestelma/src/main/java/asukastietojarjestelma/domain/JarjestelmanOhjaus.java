
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
            System.out.println("Komennot:\n 1 lisää asunto\n 2 lisää asukas\n 3 näytä kaikkien asuntojen tiedot\n 4 näytä vapaat asunnot\n x lopeta\n");
            System.out.print("Syötä komento: ");
            String komento = this.lukija.nextLine();
            if (komento.equals("1")) {
                this.lisaaAsunto();
            } else if (komento.equals("2")) {
                this.lisaaAsukas();
            } else if (komento.equals("3")) {
                this.tulostaAsunnot();
            } else if (komento.equals("4")) {
                //this.tulostaVapaatAsunnot();
            } else if (komento.equals("x")) {
                System.out.println("Kiitos näkemiin!");
                break;
            }
            System.out.println();
        }
        
    }
    
    public void lisaaTalo(String osoite){
        this.talot.put(new Talo(osoite), new ArrayList<Asunto>());
        System.out.println("Talo luotu järjestelmään, voit lisätä asunnot");
        return;
    }
    
    public void lisaaAsunto() {
        System.out.print("Syötä talon katuosoite: ");
        String osoite = this.lukija.nextLine();
        if (this.talot == null || this.talot.containsKey(osoite) == false) {
            this.lisaaTalo(osoite);
        }
        
        System.out.print("Syötä asunnon rappu ja numero: ");
        String numero = this.lukija.nextLine();
        System.out.print("Asunnon huonemuoto: ");
        String huonemuoto = this.lukija.nextLine();
        
        
        this.talot.get(osoite).add(new Asunto(numero, huonemuoto));
            
        
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
