
package asukastietojarjestelma.domain;

public class Asukas {
    private String nimi;
    private Vuokrasopimus sopimus;
    
    // mitä muita tunnistetietoja tarvitaan?
    // tallentuuko vanhat vuokrasopimukset asukkaan tietoihin vai minne?
    
    public Asukas(String nimi) {
        this.nimi = nimi;
        this.sopimus = null;
    }
    
    public String toString() {
        return this.nimi;
    }
    
}
