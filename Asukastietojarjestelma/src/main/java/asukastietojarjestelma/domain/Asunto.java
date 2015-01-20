
package asukastietojarjestelma.domain;

public abstract class Asunto {
    private String osoite;
    private String huonemuoto; // esim. 2h + k
    private boolean onkoVuokrattu;
    
    //onko Asunnolla tieto entisistä ja nykyisistä asukkaista? lista tehdyistä vuokrasopimuksista!?
    
    public Asunto(String osoite, String huonemuoto) {
        this.osoite = osoite;
        this.huonemuoto = huonemuoto;
        this.onkoVuokrattu = false;
    }
    public String getOsoite() {
        return this.osoite;
    }
    
    // vuokraamista pitää miettiä...
    public boolean onkoVuokrattu() {
        return this.onkoVuokrattu;
    }
    
    public void vuokraa() {
        if (this.onkoVuokrattu == false) {
            this.onkoVuokrattu = true;
        }
    }
    
    public String toString() {
        return this.osoite;
        //voisi kertoa myös nykyiset asukkaat?
    }
    
}
