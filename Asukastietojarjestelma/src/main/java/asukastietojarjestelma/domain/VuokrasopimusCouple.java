
package asukastietojarjestelma.domain;
/**
 * Luokka on Vuokrasopimusluokan alaluokka, joka sisältää osan kahden hengen vuokrasopimuksiin liittyviä toiminnallisuuksia
 */
public class VuokrasopimusCouple extends Vuokrasopimus{
    /* ... */
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
    
    @Override
    public void setPaattymispvm(String paattymispvm) {
        //vertailu ettei ennen alkupäivää
        this.paattymispvm = paattymispvm;
        this.asunto.paataVuokrasopimus();
        this.asukas1.paataVuokrasopimus();
        this.asukas2.paataVuokrasopimus();
    }
    
    //MUUT
    @Override
    public String tiedotIlmanAsuntoa() {
        return "Asukas: " + this.asukas1.getNimi() + " ja " +  this.asukas2.getNimi() +
               "\nVuokrasopimuksen voimassaolo: " + super.alkupvm + " - " + super.paattymispvm;
    }

    @Override
    public String toString() {
        
        return "Vuokrasopimuksen tiedot:\n" +
                "Vuokrattu asunto: " + super.asunto.getOsoite() +
                "\nAsukas: " + this.asukas1.getNimi() + " ja " +  this.asukas2.getNimi() +
                "\nVuokrasopimuksen voimassaolo: " + super.alkupvm + " - " + super.paattymispvm;
    }
    
}
