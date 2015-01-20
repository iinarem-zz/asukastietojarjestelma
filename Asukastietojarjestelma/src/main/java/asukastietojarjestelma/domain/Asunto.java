
package asukastietojarjestelma.domain;

public abstract class Asunto {
    private String osoite;
    private String huonemuoto; // esim. 2h + k
    
    //onko Asunnolla tieto entisistä ja nykyisistä asukkaista?
    
    public Asunto(String osoite, String huonemuoto) {
        this.osoite = osoite;
        this.huonemuoto = huonemuoto;
    }
    
    public String toString() {
        return this.osoite;
    }
    
}
