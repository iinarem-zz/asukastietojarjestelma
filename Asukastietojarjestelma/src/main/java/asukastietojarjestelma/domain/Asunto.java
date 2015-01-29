
package asukastietojarjestelma.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Asunto {
    private String talo;
    private String asuntonro;
    private int huonemaara;
    private double pA;
    private double vuokra;
    private boolean onkoVuokrattu;
    private Vuokrasopimus sopimus;
    private List<Vuokrasopimus> vuokrasopimukset;
    
    public Asunto(String talo, String asuntonro, int huonemaara, double pA) {
        this.talo = talo;
        this.asuntonro = asuntonro;
        this.huonemaara = huonemaara;
        this.pA = pA;
        this.vuokra = 0;
        this.onkoVuokrattu = false; // kun ladataan tiedostosta ei ole auttomaattisesti false
        this.sopimus = null;
        this.vuokrasopimukset = new ArrayList<Vuokrasopimus>();
    }
    
    // GETTERIT
    public String getOsoite() {
        return this.talo + " " + this.asuntonro;
    }
    
    public double getVuokra() {
        return this.vuokra;
    }
    
    public boolean onkoVuokrattu() {
        return this.onkoVuokrattu;
    }
    
    public int getHuonemaara() {
        return this.huonemaara;
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
            Collections.sort(vuokrasopimukset);
        }
        
        //pitäisikö palauttaa tieto siitä onnistuiko?
        //pitäisi huomauttaa jos asunnossa on jo voimassaoleva sopimus. 
        //jos silti halutaan vuokrata, pitäisi edellinen vuokrasopimus päättää ensin.
    }
    
    // MUUT
    
    //järjestäminen
    
    @Override
    public String toString() {
        if (this.onkoVuokrattu) {
            return this.talo + " " + this.asuntonro + ": " + this.huonemaara + "h " + this.pA + "m2" +
                   "\n" + this.sopimus;
        }
        return this.talo + " " + this.asuntonro + ": " + this.huonemaara + "h " + this.pA + "m2";
    }
    
}
