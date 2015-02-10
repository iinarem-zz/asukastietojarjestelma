
package asukastietojarjestelma.domain;

import java.io.File;
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
    
    public HashMap<String, ArrayList<Asunto>> lueAsunnot(String tiedostonnimi) {
        File asunnot = new File(tiedostonnimi);
        HashMap<String, ArrayList<Asunto>> asuntoLista = new HashMap<String, ArrayList<Asunto>>();
        String talo = "";
        String asuntonro = "";
        int huonemaara = 0;
        double pA = 0;
        int vuokra = 0;
        
        try {
            this.tiedostonLukija = new Scanner(asunnot);
            while (this.tiedostonLukija.hasNextLine()) {
                String rivi = this.tiedostonLukija.nextLine();
                
                if (rivi.equals("##")) {
                    if (talo.equals("")) {
                        break;
                    }
                    
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
                        vuokra = Integer.parseInt(sanat[1]);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Tiedostoa ei voitu lukea! Virhe: " + e.getMessage());
        }
        this.tiedostonLukija.close();
        return asuntoLista;
        
    }
    
    public HashMap<String,Asukas> lueAsukkaat(String tiedostonnimi) {
        File asukkaat = new File(tiedostonnimi);
        HashMap<String,Asukas> asukasLista = new HashMap<String,Asukas>();
        String htunnus = "";
        String enimi = "";
        String snimi = "";
        String puh = "";
        String email = "";
        
        try {
            this.tiedostonLukija = new Scanner(asukkaat);
            while (this.tiedostonLukija.hasNextLine()) {
                String rivi = this.tiedostonLukija.nextLine();
                
                if (rivi.equals("##")) {
                    if (snimi.equals("")) {
                        break;
                    }
                    
                    Asukas uusi = new Asukas(snimi, enimi, htunnus, puh, email);
                    asukasLista.put(htunnus, uusi);
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
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Tiedostoa ei voitu lukea! Virhe: " + e.getMessage());
        }
        this.tiedostonLukija.close();
        return asukasLista;
        
    }
    
    public ArrayList<Vuokrasopimus> lueVuokrasopimukset(Map<String,Asukas> asukkaat, Map<String,ArrayList<Asunto>> asunnot, String tiedostonnimi) {
        File sopimukset = new File(tiedostonnimi);
        ArrayList<Vuokrasopimus> soppariLista = new ArrayList<Vuokrasopimus>();
        Asunto asunto = null;
        String alkupvm = "";
        String loppupvm = "";
        Asukas asukas1 = null;
        Asukas asukas2 = null;
        
        try {
            this.tiedostonLukija = new Scanner(sopimukset);
            while (this.tiedostonLukija.hasNextLine()) {
                String rivi = this.tiedostonLukija.nextLine();
                
                if (rivi.equals("##")) {
                    if (asunto == null) {
                        break;
                    } else if (asunto.getHuonemaara() > 1 && asukas2 != null) {
                        VuokrasopimusCouple uusi = new VuokrasopimusCouple(asunto, alkupvm, loppupvm, asukas1, asukas2);
                        soppariLista.add(uusi);
                    } else {
                        VuokrasopimusSingle uusi = new VuokrasopimusSingle(asunto, alkupvm, loppupvm, asukas1);
                        soppariLista.add(uusi);
                    }
                    
                } else {
                    String[] sanat = rivi.split(":");
                    
                    if (sanat[0].equals("asunto")) {
                        try {
                            for (Asunto a : asunnot.get(sanat[1])) {
                                if (a.getAsuntonro().equals(sanat[2])) {
                                    asunto = a;
                                }
                           } 
                        } catch (Exception e) {
                            System.out.println("Virheellinen asuntotieto! Virhe: " + e.getMessage());
                            break;
                        }
                        
                    } else if (sanat[0].equals("alkupvm")) {
                        alkupvm = sanat[1] + "." + sanat[2] + "." + sanat[3];
                    } else if (sanat[0].equals("loppupvm")) {
                        loppupvm = sanat[1] + "." + sanat[2] + "." + sanat[3];
                    } else if (sanat[0].equals("asukas1")) {
                        try {
                            asukas1 = asukkaat.get(sanat[1]);
                        } catch (Exception e) {
                            System.out.println("Virheellinen asukastieto! Virhe: " + e.getMessage());
                            break;
                        }
                    } else if (sanat[0].equals("asukas2") && !sanat[1].equals("none")) {
                        try {
                            asukas2 = asukkaat.get(sanat[1]);
                        } catch (Exception e) {
                            System.out.println("Virheellinen asukastieto! Virhe: " + e.getMessage());
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Tiedostoa ei voitu lukea! Virhe: " + e.getMessage());
        }
        this.tiedostonLukija.close();
        
        return soppariLista;
        
        
    }
    
}
