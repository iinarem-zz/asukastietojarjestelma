
package asukastietojarjestelma.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TiedostonLukija {
    private Scanner tiedostonLukija;
    
    public TiedostonLukija() {
        this.tiedostonLukija = null;
    }
    
    public ArrayList<Asunto> lueAsunnot() {
        File asunnot = new File("asunnot.txt");
        ArrayList<Asunto> asuntoLista = new ArrayList<Asunto>();
        
        
        return asuntoLista;
        
    }
    
    public HashMap<String,Asukas> lueAsukkaat() {
        File asukkaat = new File("vuokralaiset.txt");
        HashMap<String,Asukas> asukasLista = new HashMap<String,Asukas>();
        String htunnus = "";
        String enimi = "";
        String snimi = "";
        String puh = "";
        String email = "";
        String lisat = "";
        try {
            this.tiedostonLukija = new Scanner(asukkaat);
            while (this.tiedostonLukija.hasNextLine()) {
                String rivi = this.tiedostonLukija.nextLine();
                
                if (rivi.equals("##")) {
                    Asukas uusi = new Asukas(snimi, enimi, htunnus, puh, email);
                    uusi.setLisatiedot(lisat);
                    asukasLista.put(htunnus, uusi);
                    continue;
                } else {
                    String[] sanat = rivi.split(":");
                    
                    if (sanat[1].equals("htunnus")) {
                        htunnus = sanat[1];
                    } else if (sanat[1].equals("enimi")) {
                        enimi = sanat[1];
                    } else if (sanat[1].equals("snimi")) {
                        snimi = sanat[1];
                    } else if (sanat[1].equals("puh")) {
                        puh = sanat[1];
                    } else if (sanat[1].equals("email")) {
                        email = sanat[1];
                    } else if (sanat[1].equals("lisat")) {
                        lisat = sanat[1];
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Tiedostoa ei voitu lukea!");
        }
        this.tiedostonLukija.close();
        return asukasLista;
        
    }
    
    public ArrayList<Vuokrasopimus> lueVuokrasopimukset() {
        File asunnot = new File("sopimukset.txt");
        ArrayList<Vuokrasopimus> soppariLista = new ArrayList<Vuokrasopimus>();
        
        return soppariLista;
        
        
    }
    
}
