
package asukastietojarjestelma.domain;

public class Talo {
    private String nimi;
    // asunnot, mut missä muodossa tallennettuna list vai map
    
    public Talo(String nimi) {
        this.nimi = nimi;
        
    }
    
    public String toString() {
        return this.nimi;
    }
    
}
