
package asukastietojarjestelma.domain;

import java.util.ArrayList;
import java.util.List;

public class Talo {
    private String osoite;
    private List<Asunto> asunnot;
    private String lisatietoja;
    
    public Talo(String osoite) {
        this.osoite = osoite;
        this.asunnot = new ArrayList<Asunto>();
        this.lisatietoja = ""; // esim. talon rakennusvuosi, remontit...
    }
    
    // GETTERIT
    
    public String getOsoite() {
        return this.osoite;
    }
    
    
    public List<Asunto> getAsunnot() {
        return this.asunnot;
    }
    
    public int getAsuntojenMaara() {
        if (this.asunnot.isEmpty()) {
            return 0;
        }
        return this.asunnot.size();
    }
    
    // SETTERIT
    
    public void lisaaAsunto(String osoite, String huonemuoto) {
        this.asunnot.add(new Asunto(osoite, huonemuoto));
        // tarvitseeko testata onko asunto jo järjestelmässä jos ladataan tiedostosta?
    }
    
    
    // MUUT
    
    //onko tarpeeton
    public boolean equals(Object olio) {
        if (olio == null) {
            return false;
        }

        if (getClass() != olio.getClass()) {
            return false;
        }

        Talo verrattava = (Talo) olio;

        if (this.osoite == null || !this.osoite.equals(verrattava.getOsoite())) {
            return false;
        }

        return true;
    }

    
    public String toString() {
        if (this.asunnot.isEmpty()) {
            return this.osoite + " talossa ei ole vuokrattavia asuntoja \nTalon tiedot: " + this.lisatietoja;
        }
        
        String kaikkienAsuntojenTiedot = "";
        
        for (Asunto a : this.asunnot) {
            kaikkienAsuntojenTiedot += a.toString() + "\n\n";
        }
        
        return this.osoite + "\n" + this.lisatietoja +  "\n" + kaikkienAsuntojenTiedot;
    }
    
}
