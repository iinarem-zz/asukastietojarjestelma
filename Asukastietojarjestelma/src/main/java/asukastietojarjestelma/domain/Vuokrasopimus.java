
package asukastietojarjestelma.domain;

public abstract class Vuokrasopimus implements Comparable<Vuokrasopimus> {
    protected Asunto asunto;
    protected String alkupvm;
    protected String paattymispvm;
    
    public Vuokrasopimus(Asunto asunto, String alku, String paattyminen) {
        this.asunto = asunto;
        this.alkupvm = alku;
        this.paattymispvm = paattyminen;
        this.asunto.vuokraa(this);
    }
    
    // GETTERIT
    public String getAlkupvm() {
        return this.alkupvm;
    }
    
    public String getPaattymispvm() {
        return this.paattymispvm;
    }
    
    public String getVuokrasopimuksenTiedot() {
        return this.asunto.getOsoite() + ": " + this.alkupvm + " - " + this.paattymispvm;
    }
    
    public double getVuokra (){
        return this.asunto.getVuokra();
    }
    
    // SETTERIT
    public void setPaattymispvm(String paattymispvm) {
        this.paattymispvm = paattymispvm;
    }
    
    // MUUT TOIMINNOT
    @Override
    public int compareTo(Vuokrasopimus sopimus) {
        return this.paattymispvm.compareTo(sopimus.paattymispvm); //korjattava!
    }
//    
}
