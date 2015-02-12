
package asukastietojarjestelma.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Luokka sisältää tietojen tiedostosta lukemiseen liittyvät metodit, jotka luovat tietojen perusteella tarvittavat oliot
 */
public class TiedostonLukija {
    /* ... */
    private Scanner tiedostonLukija;
    
    public TiedostonLukija() {
        this.tiedostonLukija = null;
    }
    
    // Asuntojen lukeminen
    /**
    * Metodi lukee tiedostosta asuntojen tiedot ja luo niiden perusteella Asunto-olioita
    *
    * @param   tiedostonnimi   Tiedosto, josta luetaan
    * 
    * @see    asukastietojarjestelma.domain.TiedostonLukija#asunnonLisaaminenMappiin(java.util.HashMap, java.lang.String, asukastietojarjestelma.domain.Asunto) 
    *
    * @return HashMap johon asunnot on tallennettu talotunnusten taakse ArrayListiin
    */
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
                    
                    asunnonLisaaminenMappiin(asuntoLista, talo, uusi);
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
    /**
    * lueAsunnot metodin apumetodi, joka lisää tiedostosta luodun asunnon HashMapiin
    *
    * @param   asuntoLista   HashMap olemassa olevista asunto-olioista
    * @param   talo   tieto siitä mihin taloon lisättävä asunto-olio kuuluu
    * @param   uusi   uusi lisättävä asunto-olio
    * 
    * @see    asukastietojarjestelma.domain.TiedostonLukija#lueAsunnot(java.lang.String) 
    *
    */
    private void asunnonLisaaminenMappiin(HashMap<String, ArrayList<Asunto>> asuntoLista, String talo, Asunto uusi) {
        if (asuntoLista.containsKey(talo)) {
            asuntoLista.get(talo).add(uusi);
            //järjestä asunnot aakkosjärjestykseen osoitteen mukaan
        } else {
            ArrayList<Asunto> talonAsunnot = new ArrayList<Asunto>();
            talonAsunnot.add(uusi);
            //järjestä asunnot aakkosjärjestykseen osoitteen mukaan
            asuntoLista.put(talo, talonAsunnot);
        }
    }
    
    
    
    // Asukkaiden lukeminen
    /**
    * Metodi lukee tiedostosta asukkaiden tiedot ja luo niiden perusteella Asukas-olioita
    *
    * @param   tiedostonnimi   Tiedosto, josta luetaan
    *
    * @return HashMap johon asukkaat on tallennettu henkilötunnustensa taakse
    */
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
    
    /**
    * Metodi lukee tiedostosta vuokrasopimusten tiedot ja luo niiden perusteella Vuokrasopimus-olioita
    *
    * @param   asukkaat   asukkaat HashMappinä, ne jotka järjestelmässä sen käynnistyessä
    * @param   asunnot   asunnot HashMappinä, ne jotka järjestelmässä sen käynnistyessä
    * @param   tiedostonnimi   Tiedosto, josta luetaan
    * 
    * @see    asukastietojarjestelma.domain.TiedostonLukija#vuokrasopimuksenLuominen(asukastietojarjestelma.domain.Asunto, asukastietojarjestelma.domain.Asukas, java.lang.String, java.lang.String, asukastietojarjestelma.domain.Asukas, java.util.ArrayList)  
    *
    * @return ArrayList johon vuokrasopimusoliot on tallennettu
    */
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
                    } 
                    
                    vuokrasopimuksenLuominen(asunto, asukas2, alkupvm, loppupvm, asukas1, soppariLista);
                    
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
    
    /**
    * lueVuokrasopimukset metodin apumetodi
    * Metodi luo oikean tyyppisiä vuokrasopimuksia, riippuen asukkaiden määrästä, ja lisää niitä listaan.
    *
    * @param   asunto   asunto, johon vuokrasopimus tehdään
    * @param   alkupvm   sopimuksen alkupvm
    * @param   loppupvm   sopimuksen loppupvm
    * @param   asukas1   ensimmäinen asukas
    * @param   asukas2   toinen asukas
    * @param   soppariLista   lista jo olemassa olevista vuokrasopimusolisoita
    * 
    * @see    asukastietojarjestelma.domain.TiedostonLukija#lueVuokrasopimukset(java.util.Map, java.util.Map, java.lang.String) 
    *
    */

    public void vuokrasopimuksenLuominen(Asunto asunto, Asukas asukas2, String alkupvm, String loppupvm, Asukas asukas1, ArrayList<Vuokrasopimus> soppariLista) {
        if (asunto.getHuonemaara() > 1 && asukas2 != null) {
            VuokrasopimusCouple uusi = new VuokrasopimusCouple(asunto, alkupvm, loppupvm, asukas1, asukas2);
            soppariLista.add(uusi);
        } else {
            VuokrasopimusSingle uusi = new VuokrasopimusSingle(asunto, alkupvm, loppupvm, asukas1);
            soppariLista.add(uusi);
        }
    }
    
}
