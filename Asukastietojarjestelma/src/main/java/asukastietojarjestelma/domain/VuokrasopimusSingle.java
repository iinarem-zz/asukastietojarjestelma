
package asukastietojarjestelma.domain;

public class VuokrasopimusSingle extends Vuokrasopimus {
    private Asukas asukas;
    
    public VuokrasopimusSingle (Asunto asunto, String alku, String paattyminen) {
        super(asunto, alku, paattyminen);
        this.asukas = null;
    }

    //SETTERIT
    public void lisaaAsukas(Asukas asukas) {
        this.asukas = asukas;
         this.asukas.setVuokrasopimus(this);
    }
    
    //MUUT
    @Override
    public String toString() {
        return "Vuokrasopimuksen tiedot:\n" +
                "Vuokrattu asunto: " + super.asunto.getOsoite() +
                "\nAsukas: " + this.asukas.getNimi() +
                "\nVuokrasopimuksen voimassaolo: " + super.alkupvm + "-" + super.paattymispvm; 
        }

}

