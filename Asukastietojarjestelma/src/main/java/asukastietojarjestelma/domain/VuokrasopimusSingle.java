
package asukastietojarjestelma.domain;

import java.util.Date;

public class VuokrasopimusSingle extends Vuokrasopimus {
    private Asukas asukas;
    
    public VuokrasopimusSingle (Asunto asunto, Date alku, Date paattyminen) {
        super(asunto, alku, paattyminen);
        this.asukas = null;
    }

    //SETTERIT
    public void lisaaAsukas(Asukas asukas) {
        if (this.asukas == null) {
            this.asukas = asukas;
        } else {
            System.out.println("Asunto on jo vuokrattu.");
        }
    }
    
    //MUUT
    @Override
    public String toString() {
        return "Vuokrasopimuksen tiedot:\n" +
                "Asukas: " + this.asukas +
                "\nVuokrattu asunto: " + super.asunto +
                "\nVuokrasopimuksen voimassaolo: " + super.alkupvm + "-" + super.paattymispvm; 
        }

}

