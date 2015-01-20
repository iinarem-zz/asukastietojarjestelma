
package asukastietojarjestelma.domain;

public class Vuokrasopimus {
    private Asunto asunto;
    private Asukas asukas1;
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
        // tsekattava, ettei ole vaaraa tehdä kahdelle EI parille/kaverille sopimusta samaan asuntoon
        if (this.asukas1 == null) {
            this.asukas1 = asukas;
        } else if (this.asukas2 == null) {
           this.asukas2 = asukas;
        } else {
            return "Asunto on jo vuokrattu.";
        }
        
        return asukas.getNimi() + " lisättiin asukkaaksi asuntoon " + this.asunto.getOsoite() + "/n asunnon tiedot " + this.asunto.toString();
                
    }
    
}
