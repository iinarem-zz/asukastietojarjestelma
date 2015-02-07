
package asukastietojarjestelma.domain;

import java.util.Objects;

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
    
    public Asunto getAsunto() {
        return this.asunto;
    }
    
    // SETTERIT
    public void setPaattymispvm(String paattymispvm) {
        this.paattymispvm = paattymispvm;
        this.asunto.paataVuokrasopimus();
    }
    
    // MUUT TOIMINNOT
//    @Override
//    public boolean equals(Object olio) {
//        if (olio == null) {
//            return false;
//        }
//
//        if (getClass() != olio.getClass()) {
//            return false;
//        }
//
//        Vuokrasopimus verrattava = (Vuokrasopimus) olio;
//
//        if (this.asunto == null || !this.getVuokrasopimuksenTiedot().equals(verrattava.getVuokrasopimuksenTiedot())) {
//            return false;
//        }
//
//        return true;
//    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.asunto);
        hash = 37 * hash + Objects.hashCode(this.alkupvm);
        hash = 37 * hash + Objects.hashCode(this.paattymispvm);
        return hash;
    }
    
    @Override
    public int compareTo(Vuokrasopimus sopimus) {
        return this.paattymispvm.compareTo(sopimus.paattymispvm); //korjattava!
    }
//    
}
