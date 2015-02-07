
package asukastietojarjestelma.domain;

public class VuokrasopimusCouple extends Vuokrasopimus{
    private Asukas asukas1;
    private Asukas asukas2;
    
    public VuokrasopimusCouple(Asunto asunto, String alku, String paattyminen, Asukas asukas1, Asukas asukas2) {
        super(asunto, alku, paattyminen);
        this.asukas1 = asukas1;
        this.asukas2 = asukas2;
        this.asukas1.setVuokrasopimus(this);
        this.asukas2.setVuokrasopimus(this);
    }
    
    //GETTERIT
    public Asukas getAsukas1() {
        return this.asukas1;
    }
    
    public Asukas getAsukas2() {
        return this.asukas2;
    }

    //SETTERIT
    public void lisaaAsukkaat(Asukas a, Asukas b) {
        // lisää se ettei vuokrasopimusta voi tehdä jos on jo voimassaoleva vuokrasoppari.
        this.asukas1 = a;
        this.asukas2 = b;
        this.asukas1.setVuokrasopimus(this);
        
        if (this.asukas2 != null) {
            this.asukas2.setVuokrasopimus(this);
        }
        
    }
    
    @Override
    public void setPaattymispvm(String paattymispvm) {
        this.paattymispvm = paattymispvm;
        this.asunto.paataVuokrasopimus();
        this.asukas1.paataVuokrasopimus();
        this.asukas2.paataVuokrasopimus();
    }
    
    //MUUT
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
//        if (this.asukas1 == null || ) {
//            return false;
//        }
//
//        return true;
//    }
    
    
    @Override
    public String toString() {
        
        return "Vuokrasopimuksen tiedot:\n" +
                "Vuokrattu asunto: " + super.asunto.getOsoite() +
                "\nAsukas: " + this.asukas1.getNimi() + " ja " +  this.asukas2.getNimi() +
                "\nVuokrasopimuksen voimassaolo: " + super.alkupvm + " - " + super.paattymispvm;
    }
    
}
