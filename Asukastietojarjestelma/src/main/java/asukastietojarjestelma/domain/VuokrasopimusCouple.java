
package asukastietojarjestelma.domain;

public class VuokrasopimusCouple extends Vuokrasopimus{
    private Asukas asukas1;
    private Asukas asukas2;
    
    public VuokrasopimusCouple(Asunto asunto, String alku, String paattyminen) {
        super(asunto, alku, paattyminen);
        this.asukas1 = null;
        this.asukas2 = null;
    }

    //SETTERIT
    public void lisaaAsukkaat(Asukas a, Asukas b) {
        this.asukas1 = a;
        this.asukas2 = b;
        this.asukas1.setVuokrasopimus(this);
        
        if (this.asukas2 != null) {
            this.asukas2.setVuokrasopimus(this);
        }
        
    }
    
    //MUUT
    @Override
    public String toString() {
        
        return "Vuokrasopimuksen tiedot:\n" +
                "Asukas: " + this.asukas1 + this.asukas2 +
                "\nVuokrattu asunto: " + this.asunto +
                "\nVuokrasopimuksen voimassaolo: " + this.alkupvm + "-" + this.paattymispvm; 
    }
    
}
