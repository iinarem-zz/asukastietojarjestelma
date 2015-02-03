
package asukastietojarjestelma.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Asunto {
    private String talo;
    private String asuntonro;
    private int huonemaara;
    private double pA;
    private int vuokra;
    private boolean onkoVuokrattu;
    private Vuokrasopimus sopimus;
    private List<Vuokrasopimus> vuokrasopimukset;
    
    public Asunto(String talo, String asuntonro, int huonemaara, double pA) {
        this.talo = talo;
        this.asuntonro = asuntonro;
        this.huonemaara = huonemaara;
        this.pA = pA;
        this.vuokra = 0;
        this.onkoVuokrattu = false;
        this.sopimus = null;
        this.vuokrasopimukset = new ArrayList<Vuokrasopimus>();
    }
    
    // GETTERIT
    public String getOsoite() {
        return this.talo + " " + this.asuntonro;
    }
    
    public String getTalo() {
        return this.talo;
    }
    
    public String getAsuntonro() {
        return this.asuntonro;
    }
    
    public double getVuokra() {
        return this.vuokra;
    }
    
    public boolean onkoVuokrattu() {
        return this.onkoVuokrattu;
    }
    
    public Vuokrasopimus getVuokrasopimus() {
        return this.sopimus;
    }
    
    public int getHuonemaara() {
        return this.huonemaara;
    }
    
    //SETTERIT
    public void setVuokra(int vuokra) {
        this.vuokra = vuokra;
    }
    
    public String vuokraa(Vuokrasopimus sopimus) {
        if (this.onkoVuokrattu == false) {
            this.sopimus = sopimus;
            this.onkoVuokrattu = true;
            this.vuokrasopimukset.add(sopimus);
            //Collections.sort(vuokrasopimukset);
            return "Vuokraus onnistui!";
        } else {
            return "Asunto on jo vuokrattu! Päätä edellinen vuokrasopimus.";
        } 
    }
    
    public void paataVuokrasopimus() {
        if (this.onkoVuokrattu) {
            this.sopimus = null;
            this.onkoVuokrattu = false;
        } else {
            System.out.println("Asuntoa ei ole vuokrattu, vuokrasopimusta ei voida päättää.");
        }
    }
    
    // MUUT
    
    //tähän metodi järjestäminen osoitteen mukaan aakkosissa
    
    @Override
    public String toString() {
        if (this.onkoVuokrattu) {
            return this.talo + " " + this.asuntonro + ": " + this.huonemaara + "h " + this.pA + "m2" +
                   "\nvuokra: " + this.vuokra +" euroa" +
                   "\n" + this.sopimus;
        }
        return this.talo + " " + this.asuntonro + ": " + this.huonemaara + "h " + this.pA + "m2, " +
                "vuokra: " + this.vuokra +" euroa";
    }
    
}
