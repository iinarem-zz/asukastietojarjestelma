
package asukastietojarjestelma.domain;

import java.util.List;

public class Asunto {
    private String huonenumero; // osoitteessa pitäisi näkyä myös talonkatuosoite.
    private String huonemuoto; // esim. 2h + k avattava enemmän.
    // asunnon pinta-ala muuttujaksi
    private boolean onkoVuokrattu;
    private Vuokrasopimus sopimus;
    private List<Vuokrasopimus> vuokrasopimukset;
    
    public Asunto(String huonenumero, String huonemuoto) {
        this.huonenumero = huonenumero;
        this.huonemuoto = huonemuoto;
        this.onkoVuokrattu = false; // kun ladataan tiedostosta ei ole auttomaattisesti false
        this.sopimus = null;
    }
    
    // GETTERIT
    
    public String getOsoite() {
        return this.huonenumero;
    }
    
    public boolean onkoVuokrattu() {
        return this.onkoVuokrattu;
    }
    
    //SETTERIT
    public void vuokraa(Vuokrasopimus sopimus) {
        if (this.onkoVuokrattu == false) {
            this.sopimus = sopimus;
            this.onkoVuokrattu = true;
            this.vuokrasopimukset.add(sopimus);
            // vuokrasopimusten järjestäminen
        }
        
        //pitäisikö palauttaa tieto siitä onnistuiko?
        //pitäisi huomauttaa jos asunnossa on jo voimassaoleva sopimus. 
        //jos silti halutaan vuokrata, pitäisi edellinen vuokrasopimus päättää ensin.
    }
    
    public String toString() {
        if (this.onkoVuokrattu) {
            return this.huonenumero + ": " + this.huonemuoto +
                   "\n" + this.sopimus;
        }
        return this.huonenumero + ": " + this.huonemuoto;
    }
    
}
