
package asukastietojarjestelma.domain;

import java.util.Date;

public class Vuokrasopimus implements Comparable<Vuokrasopimus> {
    private Asunto asunto;
    private Asukas asukas1;
    private Asukas asukas2;
    private Date alkupvm;
    private Date paattymispvm;
    // vuokra muuttujaksi!
    
    public Vuokrasopimus(Asunto asunto, Date alku, Date paattyminen) {
        this.asunto = asunto;
        this.asukas1 = null;
        this.asukas2 = null;
        this.alkupvm = alku;
        this.paattymispvm = paattyminen;
        
    }
    
    // GETTERIT
    
    public Date getAlkupvm() {
        return this.alkupvm;
    }
    
    public Date getPaattymispvm() {
        return this.paattymispvm;
    }
    
    public String getVuokrasopimuksenTiedot() {
        return this.asunto.getOsoite() + ": " + this.alkupvm + " - " + this.paattymispvm;
    }
    
    // SETTERIT
    
    public void setPaattymispvm(Date paattymispvm) {
        this.paattymispvm = paattymispvm;
    }
    
    // MUUT TOIMINNOT
    
    public String lisaaAsukas(Asukas asukas) {
        //tsekkaa onko asunto single vai couple
        if (this.asukas1 == null) {
            this.asukas1 = asukas;
        } else if (this.asukas2 == null) {
           this.asukas2 = asukas;
        } else {
            return "Asunto on jo vuokrattu.";
        }
        
        return asukas.getNimi() + " lisättiin asukkaaksi asuntoon " + this.asunto.getOsoite();
                
    }
    
    @Override
    public int compareTo(Vuokrasopimus sopimus) {
        return this.paattymispvm.compareTo(sopimus.paattymispvm);
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
