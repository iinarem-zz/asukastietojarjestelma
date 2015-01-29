
package asukastietojarjestelma.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TiedostonLukija {
    private Scanner tiedostonLukija;
    
    public TiedostonLukija() {
        this.tiedostonLukija = null;
    }
    
    public HashMap<String, ArrayList<Asunto>> lueAsunnot() {
        File asunnot = new File("asunnot.txt");
        HashMap<String, ArrayList<Asunto>> asuntoLista = new HashMap<String, ArrayList<Asunto>>();
        String talo = "";
        String asuntonro = "";
        int huonemaara = 0;
        double pA = 0;
        double vuokra = 0;
        
        try {
            this.tiedostonLukija = new Scanner(asunnot);
            while (this.tiedostonLukija.hasNextLine()) {
                String rivi = this.tiedostonLukija.nextLine();
                
                if (rivi.equals("##")) {
                    Asunto uusi = new Asunto(talo, asuntonro, huonemaara, pA);
                    uusi.setVuokra(vuokra);
                    if (asuntoLista.containsKey(talo)) {
                        asuntoLista.get(talo).add(uusi);
                        //järjestä asunnot aakkosjärjestykseen osoitteen mukaan
                    } else {
                        ArrayList<Asunto> talonAsunnot = new ArrayList<Asunto>();
                        talonAsunnot.add(uusi);
                        //järjestä asunnot aakkosjärjestykseen osoitteen mukaan
                        asuntoLista.put(talo, talonAsunnot);
                    }
                } else {
                    String[] sanat = rivi.split(":");
                    
                    if (sanat[0].equals("talo")) {
                        talo = sanat[1];
                    } else if (sanat[0].equals("asuntonro")) {
                        asuntonro = sanat[1];
                    } else if (sanat[0].equals("huonemaara")) {
                        huonemaara = Integer.parseInt(sanat[1]);
                    } else if (sanat[0].equals("pA")) {
                        pA = Double.parseDouble(sanat[1]);
                    } else if (sanat[0].equals("vuokra")) {
                        vuokra = Double.parseDouble(sanat[1]);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Tiedostoa ei voitu lukea!");
        }
        this.tiedostonLukija.close();
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
                    
                    if (sanat[0].equals("htunnus")) {
                        htunnus = sanat[1];
                    } else if (sanat[0].equals("enimi")) {
                        enimi = sanat[1];
                    } else if (sanat[0].equals("snimi")) {
                        snimi = sanat[1];
                    } else if (sanat[0].equals("puh")) {
                        puh = sanat[1];
                    } else if (sanat[0].equals("email")) {
                        email = sanat[1];
                    } else if (sanat[0].equals("lisat")) {
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
    
    public ArrayList<Vuokrasopimus> lueVuokrasopimukset(Map<String,Asukas> asukkaat, Map<String,ArrayList<Asunto>> asunnot) {
        File sopimukset = new File("sopimukset.txt");
        ArrayList<Vuokrasopimus> soppariLista = new ArrayList<Vuokrasopimus>();
        
        return soppariLista;
        
        
    }
    
}
