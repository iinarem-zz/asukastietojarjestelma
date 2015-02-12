
package asukastietojarjestelma.domain;
/**
 * Luokka on Vuokrasopimusluokan alaluokka, joka sisältää osan yhden hengen vuokrasopimuksiin liittyviä toiminnallisuuksia
 */
public class VuokrasopimusSingle extends Vuokrasopimus {
    /* ... */
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
    
    @Override
    public void setPaattymispvm(String paattymispvm) {
        //vertailu ettei ennen alkupäivää
        this.paattymispvm = paattymispvm;
        this.asunto.paataVuokrasopimus();
        this.asukas.paataVuokrasopimus();
    }
    
    //MUUT
    @Override
    public String tiedotIlmanAsuntoa() {
        return "Asukas: " + this.asukas.getNimi() +
               "\n Vuokrasopimuksen voimassaolo: " + super.alkupvm + " - " + super.paattymispvm;
    }
    @Override
    public String toString() {
        return "Vuokrasopimuksen tiedot:\n" +
                "Vuokrattu asunto: " + super.asunto.getOsoite() +
                "\nAsukas: " + this.asukas.getNimi() +
                "\nVuokrasopimuksen voimassaolo: " + super.alkupvm + " - " + super.paattymispvm; 
        }

}

