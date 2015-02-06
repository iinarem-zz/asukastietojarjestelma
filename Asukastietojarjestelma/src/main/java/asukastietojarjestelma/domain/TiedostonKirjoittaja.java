
package asukastietojarjestelma.domain;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TiedostonKirjoittaja {
    private FileWriter kirjoittaja;
    
    public TiedostonKirjoittaja() {
    }
    
    public void tallennaAsunnot(String tiedosto, HashMap<String, ArrayList<Asunto>> asunnot) throws IOException {
        this.kirjoittaja = new FileWriter(tiedosto);
        for (String avain : asunnot.keySet()) {
            ArrayList<Asunto> kampat = asunnot.get(avain);
            for (Asunto a : kampat) {
                //kirjoittaminen tähän
            }
        }
        //rivivaihdot pitää kirjoittaa.
        this.kirjoittaja.close();
        
    }
    
    public void tallennaAsukkaat(String tiedosto, HashMap<String, Asukas> asukkaat) throws IOException {
        this.kirjoittaja = new FileWriter(tiedosto);
        for (String avain : asukkaat.keySet()) {
            Asukas a = asukkaat.get(avain);
            //kirjoittaminen tähän
        }
        this.kirjoittaja.close();
    }
    
    public void tallennaVuokrasopimukset(String tiedosto, ArrayList<Vuokrasopimus> sopimukset) throws IOException {
        this.kirjoittaja = new FileWriter(tiedosto);
        for (Vuokrasopimus sopimus : sopimukset) {
            //kirjoittaminen
        }
        this.kirjoittaja.close();
    }
    
}
