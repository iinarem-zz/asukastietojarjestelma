
package asukastietojarjestelma.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Asukas {
    private String sukunimi;
    private String etunimi;
    private String hloTunnus;
    private String puhelinnumero;
    private String email;
    private String osoite;
    private Vuokrasopimus sopimus;
    private List<Vuokrasopimus> vanhatVuokrasopimukset;
    
    public Asukas(String sukunimi, String etunimi, String hloTunnus, String puh, String email) {
        this.sukunimi = sukunimi;
        this.etunimi = etunimi;
        this.hloTunnus = hloTunnus;
        this.puhelinnumero = puh;
        this.email = email;
        this.osoite = "";
        this.sopimus = null;
        this.vanhatVuokrasopimukset = new ArrayList<Vuokrasopimus>();
    }
    
    // GETTERIT
    
    public String getNimi() {
        return this.etunimi + " " + this.sukunimi;
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
        //käytetäänkö muuten kuin asukkaan poismuuttaessa? Muuten osoite sopparilta?
        this.osoite = osoite;
    }
    
    public void setVuokrasopimus(Vuokrasopimus soppari) {
        if (this.sopimus == null) {
            this.sopimus = soppari;
        }
    }
    
    // MUUT TOIMINNALLISUUDET
    
    // kun asukas siirtyy Säätiön asunnosta toiseen
    public void paataVuokrasopimus() {
        // tähän tarttee lukijan, jotta voi kysyä päättymispäivän
        //this.sopimus.setPaattymispvm(paivamaara); 
        this.vanhatVuokrasopimukset.add(this.sopimus);
        Collections.sort(vanhatVuokrasopimukset);
        // lukijalta kysytään uusi osoite.
        this.setOsoite(osoite);
    }
//    
//    // kun asukas muuttaa muualle kuin Säätiön asuntoon
//    public void paataVuokrasopimus(Vuokrasopimus soppari) {
//        //this.sopimus.setPaattymispvm(soppari.getAlkupvm() MITEN SAADAAN EDELTÄVÄ PÄIVÄ?); (automaattisesti sopparin alkua edeltävä pvm)
//        this.vanhatVuokrasopimukset.add(this.sopimus);
//        Collections.sort(vanhatVuokrasopimukset);
//        this.sopimus = null;
//    }
    
   @Override
    public int hashCode() {
        if (this.hloTunnus == null) {
            return 7;
        }
        return this.hloTunnus.hashCode();
    }
    
    @Override
    public boolean equals(Object olio) {
        if (olio == null) {
            return false;
        }

        if (getClass() != olio.getClass()) {
            return false;
        }

        Asukas verrattava = (Asukas) olio;

        if (this.hloTunnus == null || !this.hloTunnus.equals(verrattava.getHlotunnus())) {
            return false;
        }

        return true;
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
