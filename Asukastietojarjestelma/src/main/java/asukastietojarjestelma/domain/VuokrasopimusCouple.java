
package asukastietojarjestelma.domain;

import java.util.Date;

public class VuokrasopimusCouple extends Vuokrasopimus{
    private Asukas asukas1;
    private Asukas asukas2;
    
    public VuokrasopimusCouple(Asunto asunto, Date alku, Date paattyminen) {
        super(asunto, alku, paattyminen);
        this.asukas1 = null;
        this.asukas2 = null;
    }

    //SETTERIT
    public void lisaaAsukas(Asukas a, Asukas b) {
        this.asukas1 = a;
        this.asukas2 = b;
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
