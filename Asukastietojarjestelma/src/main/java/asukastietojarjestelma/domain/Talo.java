
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
    
    public void lisaaAsunto(String osoite, String huonemuoto) {
        // tarvitseeko edes testata onko asunto jo järjestelmässä jos lopussa lataa tiedostosta asunnot.
        this.asunnot.add(new Asunto(osoite, huonemuoto));
    }
    
    //tarvitaanko?
    public List<Asunto> getAsunnot() {
        return this.asunnot;
    }
    
    //on ehkä tarpeeton, mutta nyt vertailua varten
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
    
    public String getOsoite() {
        return this.osoite;
    }

    
    public String toString() {
        if (this.asunnot.isEmpty()) {
            return this.osoite + " talossa ei ole vuokrattavia asuntoja \nTalon tiedot: " + this.lisatietoja;
        }
        
        String kaikkienAsuntojenTiedot = "";
        
        for (Asunto a : this.asunnot) {
            kaikkienAsuntojenTiedot += a.toString() + "\n";
        }
        
        return this.osoite + "\n" + this.lisatietoja +  "\n" + kaikkienAsuntojenTiedot;
    }
    
}
