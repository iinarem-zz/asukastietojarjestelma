
package asukastietojarjestelma.domain;

public class Asunto {
    private String huonenumero; // osoitteessa pitäisi näkyä myös talonkatu osoite...
    private String huonemuoto; // esim. 2h + k
    private boolean onkoVuokrattu;
    private Vuokrasopimus sopimus;
    
    //lista kaikista tehdyistä vuokrasopimuksista!?
    
    public Asunto(String huonenumero, String huonemuoto) {
        this.huonenumero = huonenumero;
        this.huonemuoto = huonemuoto;
        this.onkoVuokrattu = false; // kun ladataan tiedostosta ei ole auttomaattisesti false
        this.sopimus = null;
    }
    public String getOsoite() {
        return this.huonenumero;
    }
    
    public boolean onkoVuokrattu() {
        return this.onkoVuokrattu;
    }
    
    public void vuokraa(Vuokrasopimus sopimus) {
        if (this.onkoVuokrattu == false) {
            this.sopimus = sopimus;
            this.onkoVuokrattu = true;
        }
        
        //pitäisikö palauttaa tieto siitä onnistuiko?
        //pitäisi huomauttaa jos asunnossa on jo voimassaoleva sopimus. 
        //jos silti halutaan vuokrata, pitäisi edellinen vuokrasopimus päättää ensin.
    }
    
    public String toString() {
        return this.huonenumero + ": " + this.huonemuoto;
        //tulosteeseen pitäisi saada myös talon katuosoite
        //voisi kertoa myös nykyiset asukkaat?
    }
    
}
