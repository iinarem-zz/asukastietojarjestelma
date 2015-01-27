
package asukastietojarjestelma.domain;

import java.util.ArrayList;
import java.util.List;

public class Asunto {
    private String huonenumero; // osoitteessa pitäisi näkyä myös talonkatuosoite.
    private String huonemuoto; // esim. 2h + k avattava enemmän.
    // asunnon pinta-ala muuttujaksi
    private double vuokra;
    private boolean onkoVuokrattu;
    private Vuokrasopimus sopimus;
    private List<Vuokrasopimus> vuokrasopimukset;
    
    public Asunto(String huonenumero, String huonemuoto) {
        this.huonenumero = huonenumero;
        this.huonemuoto = huonemuoto;
        this.vuokra = 0; //vuokra on ladattava jostain
        this.onkoVuokrattu = false; // kun ladataan tiedostosta ei ole auttomaattisesti false
        this.sopimus = null;
        this.vuokrasopimukset = new ArrayList<Vuokrasopimus>();
    }
    
    // GETTERIT
    
    public String getOsoite() {
        return this.huonenumero;
    }
    
    public boolean onkoVuokrattu() {
        return this.onkoVuokrattu;
    }
    
    public double getVuokra() {
        return this.vuokra;
    }
    
    //SETTERIT
    
    public void setVuokra(double vuokra) {
        this.vuokra = vuokra;
    }
    
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
