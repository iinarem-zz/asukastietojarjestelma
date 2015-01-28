
package asukastietojarjestelma.domain;

import java.util.Date;

public abstract class Vuokrasopimus implements Comparable<Vuokrasopimus> {
    protected Asunto asunto;
    protected Date alkupvm;
    protected Date paattymispvm;
    
    public Vuokrasopimus(Asunto asunto, Date alku, Date paattyminen) {
        this.asunto = asunto;
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
    
    public double getVuokra (){
        return this.asunto.getVuokra();
    }
    
    // SETTERIT
    public void setPaattymispvm(Date paattymispvm) {
        this.paattymispvm = paattymispvm;
    }
    
    // MUUT TOIMINNOT
    @Override
    public int compareTo(Vuokrasopimus sopimus) {
        return this.paattymispvm.compareTo(sopimus.paattymispvm);
    }
    
}
