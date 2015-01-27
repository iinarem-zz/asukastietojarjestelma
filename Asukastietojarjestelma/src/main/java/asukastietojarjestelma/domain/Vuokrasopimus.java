
package asukastietojarjestelma.domain;

public class Vuokrasopimus {
    private Asunto asunto;
    private Asukas asukas1; //tartteeko vuokrasopimuksella olla asukas vai asukkaalla vain vuokrasopimus?
    private Asukas asukas2;
    private String alkupvm;
    private String paattymispvm;
    
    public Vuokrasopimus(Asunto asunto, String alku, String paattyminen) {
        this.asunto = asunto;
        this.asukas1 = null;
        this.asukas2 = null;
        this.alkupvm = alku;
        this.paattymispvm = paattyminen;
        
    }
    
    public String lisaaAsukas(Asukas asukas) {
        if (this.asukas1 == null) {
            this.asukas1 = asukas;
        } else if (this.asukas2 == null) {
           this.asukas2 = asukas;
        } else {
            return "Asunto on jo vuokrattu.";
        }
        
        return asukas.getNimi() + " lisättiin asukkaaksi asuntoon " + this.asunto.getOsoite();
        
        //tsekattava ettei ole vaaraa tehdä satunnaisille ihmisille sopimusta samaan asuntoon.
        //järjestelmän pitäisi varmaan kysäistä onko ok.
                
    }
    
    public void setPaattymispaiva(String paattymispaiva) {
        this.paattymispvm = paattymispaiva;
    }
    
    public String toString() {
        if (this.asukas2 == null) {
            return "Vuokrasopimuksen tiedot:\n" +
                    "Asukas: " + this.asukas1 +
                    "\nVuokrattu asunto: " + this.asunto +
                    "\nVuokrasopimuksen voimassaolo: " + this.alkupvm + "-" + this.paattymispvm; 
        }
        return "Vuokrasopimuksen tiedot:\n" +
                "Asukas: " + this.asukas1 + this.asukas2 +
                "\nVuokrattu asunto: " + this.asunto +
                "\nVuokrasopimuksen voimassaolo: " + this.alkupvm + "-" + this.paattymispvm; 
    }
    
}
