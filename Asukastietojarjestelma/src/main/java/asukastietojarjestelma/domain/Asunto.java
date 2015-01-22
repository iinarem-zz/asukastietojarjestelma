
package asukastietojarjestelma.domain;

public class Asunto {
    private String huonenumero; // osoitteessa pitäisi näkyä myös talonkatu osoite...
    private String huonemuoto; // esim. 2h + k
    private boolean onkoVuokrattu;
    
    //onko Asunnolla tieto entisistä ja nykyisistä asukkaista? lista tehdyistä vuokrasopimuksista!?
    
    public Asunto(String huonenumero, String huonemuoto) {
        this.huonenumero = huonenumero;
        this.huonemuoto = huonemuoto;
        this.onkoVuokrattu = false; // kun ladataan tiedostosta ei ole auttomaattisesti false
    }
    public String getOsoite() {
        return this.huonenumero;
    }
    
    // vuokraamista pitää miettiä...
    public boolean onkoVuokrattu() {
        return this.onkoVuokrattu;
    }
    
    public void vuokraa() {
        if (this.onkoVuokrattu == false) {
            this.onkoVuokrattu = true;
        }
        
        //pitäisikö palauttaa tieto siitä onnistuiko?
    }
    
    public String toString() {
        return this.huonenumero + ": " + this.huonemuoto;
        //voisi kertoa myös nykyiset asukkaat?
    }
    
}
