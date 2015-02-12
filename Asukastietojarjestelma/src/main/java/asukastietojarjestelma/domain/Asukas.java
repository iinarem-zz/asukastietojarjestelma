
package asukastietojarjestelma.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Luokka sisältää asukkaan ja metodeja niiden muokkaamiseen
 */
public class Asukas {
    /* ... */
    private String sukunimi;
    private String etunimi;
    private String hloTunnus;
    private String puhelinnumero;
    private String email;
    private String osoite;
    private Vuokrasopimus sopimus;
    private List<Vuokrasopimus> vuokrasopimukset;
    
    public Asukas(String sukunimi, String etunimi, String hloTunnus, String puh, String email) {
        this.sukunimi = sukunimi;
        this.etunimi = etunimi;
        this.hloTunnus = hloTunnus;
        this.puhelinnumero = puh;
        this.email = email;
        this.osoite = "";
        this.sopimus = null;
        this.vuokrasopimukset = new ArrayList<Vuokrasopimus>();
    }
    
    // GETTERIT
    public String getNimi() {
        return this.etunimi + " " + this.sukunimi;
    }
    
    public String getEtunimi() {
        return this.etunimi;
    }
    
    public String getSukunimi() {
        return this.sukunimi;
    }
    
    public String getPuh() {
        return this.puhelinnumero;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getHlotunnus () {
        return this.hloTunnus;
    }
    
    public String getYhteystiedot() {
        return "puhelinnro: " + this.puhelinnumero +
                "\n" + "email: " + this.email + 
                "\n" + "osoite: "; //poimitaanko vuokrasopimukselta, jos arkistossa niin tässä oltava uusi osoite.
    }
    
    public Vuokrasopimus getNykyinenVuokrasopimus() {
        return this.sopimus;
    }
    
    // SETTERIT
    public void setNimi(String enimi, String snimi) {
        //pitäiskö tallentaa tieto vanhasta nimestä jonnekin esim. lisätietoihin?
        this.etunimi = enimi;
        this.sukunimi = snimi;
        
    }
    
    public void setPuhelinnumero(String puh) {
        this.puhelinnumero = puh;
        // voiko olla useita numeroita?
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setOsoite(String osoite) {
        //käytetäänkö vain asukkaan poismuuttaessa?
        this.osoite = osoite;
    }
    
    public boolean setVuokrasopimus(Vuokrasopimus soppari) {
        if (this.sopimus == null) {
            this.sopimus = soppari;
            this.vuokrasopimukset.add(soppari);
            return true;
        }
        return false;
    }
    
    // MUUT TOIMINNALLISUUDET
    /**
    * Metodi päättää asukkaan vuokrasopimuksen
    *
    */
    public void paataVuokrasopimus() {
        this.sopimus = null;
    }
    
    @Override
    public String toString() {
        if (this.sopimus == null) {
            return "nimi: " + this.etunimi + " " + this.sukunimi + 
                "\nhenkilötunnus: " + this.hloTunnus + 
                "\npuhelinnro: " + this.puhelinnumero + 
                "\nemail: " + this.email +
                "\nosoite: " + this.osoite;
            
        }
        
        return "nimi: " + this.etunimi + " " + this.sukunimi + 
                "\nhenkilötunnus: " + this.hloTunnus + 
                "\npuhelinnro: " + this.puhelinnumero + 
                "\nemail: " + this.email +
                "\nvuokrasopimuksen tiedot: " + this.sopimus.getVuokrasopimuksenTiedot();
        
    }
    
}
