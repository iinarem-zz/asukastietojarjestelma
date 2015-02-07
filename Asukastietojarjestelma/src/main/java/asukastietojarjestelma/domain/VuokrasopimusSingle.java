
package asukastietojarjestelma.domain;

public class VuokrasopimusSingle extends Vuokrasopimus {
    private Asukas asukas;
    
    public VuokrasopimusSingle (Asunto asunto, String alku, String paattyminen, Asukas asukas) {
        super(asunto, alku, paattyminen);
        this.asukas = asukas;
        this.asukas.setVuokrasopimus(this);
    }
    //GETTERIT
    public Asukas getAsukas() {
        return this.asukas;
    }

    //SETTERIT
    public void lisaaAsukas(Asukas asukas) {
        //lisää se ettei vuokrasopimusta voi tehdä jos jo voimassa oleva soppari.
        this.asukas = asukas;
         this.asukas.setVuokrasopimus(this);
    }
    
    @Override
    public void setPaattymispvm(String paattymispvm) {
        this.paattymispvm = paattymispvm;
        this.asunto.paataVuokrasopimus();
        this.asukas.paataVuokrasopimus();
    }
    
    //MUUT
    @Override
    public String toString() {
        return "Vuokrasopimuksen tiedot:\n" +
                "Vuokrattu asunto: " + super.asunto.getOsoite() +
                "\nAsukas: " + this.asukas.getNimi() +
                "\nVuokrasopimuksen voimassaolo: " + super.alkupvm + " - " + super.paattymispvm; 
        }

}

