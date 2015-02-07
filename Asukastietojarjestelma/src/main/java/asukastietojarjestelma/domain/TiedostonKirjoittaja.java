
package asukastietojarjestelma.domain;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TiedostonKirjoittaja {
    private FileWriter kirjoittaja;
    
    public TiedostonKirjoittaja() {
    }
    
    public void tallennaAsunnot(String tiedosto, HashMap<String, ArrayList<Asunto>> asunnot) throws IOException {
        this.kirjoittaja = new FileWriter(tiedosto);
        for (String avain : asunnot.keySet()) {
            ArrayList<Asunto> kampat = asunnot.get(avain);
            for (Asunto a : kampat) {
                kirjoittaja.write("talo:" + a.getTalo() + "\n");
                kirjoittaja.write("asuntonro:" + a.getAsuntonro() + "\n");
                kirjoittaja.write("huonemaara:" + a.getHuonemaara() + "\n");
                kirjoittaja.write("pA:" + a.getpA() + "\n");
                kirjoittaja.write("vuokra:" + a.getVuokra() + "\n");
                kirjoittaja.write("##");
            }
        }
        this.kirjoittaja.close();
        
    }
    
    public void tallennaAsukkaat(String tiedosto, HashMap<String, Asukas> asukkaat) throws IOException {
        this.kirjoittaja = new FileWriter(tiedosto);
        for (String avain : asukkaat.keySet()) {
            Asukas a = asukkaat.get(avain);
            kirjoittaja.write("htunnus:" + a.getHlotunnus() + "\n");
            kirjoittaja.write("enimi:" + a.getEtunimi() + "\n");
            kirjoittaja.write("snimi:" + a.getSukunimi() + "\n");
            kirjoittaja.write("puh:" + a.getPuh() + "\n");
            kirjoittaja.write("email:" + a.getEmail() + "\n");
            kirjoittaja.write("##");
        }
        this.kirjoittaja.close();
    }
    
    public void tallennaVuokrasopimukset(String tiedosto, ArrayList<Vuokrasopimus> sopimukset) throws IOException {
        this.kirjoittaja = new FileWriter(tiedosto);
        for (Vuokrasopimus sopimus : sopimukset) {
            kirjoittaja.write("huonamaara:" + sopimus.getAsunto().getHuonemaara() + "\n");
            kirjoittaja.write("asunto:" + sopimus.getAsunto().getTalo() + ":" + sopimus.getAsunto().getAsuntonro() + "\n");
            kirjoittaja.write("alkupvm:" + sopimus.getAlkupvm() + "\n");
            kirjoittaja.write("loppupvm:" + sopimus.getPaattymispvm() + "\n");
            
            if (sopimus.getAsunto().getHuonemaara() > 1) {
                VuokrasopimusCouple muunnos = (VuokrasopimusCouple) sopimus;
                kirjoittaja.write("asukas1:" + muunnos.getAsukas1().getHlotunnus() + "\n");
                kirjoittaja.write("asukas2:" + muunnos.getAsukas2().getHlotunnus() + "\n");
            } else {
                VuokrasopimusSingle muunnos = (VuokrasopimusSingle) sopimus;
                kirjoittaja.write("asukas1:" + muunnos.getAsukas().getHlotunnus() + "\n");
                kirjoittaja.write("asukas2:none\n");
            }
            kirjoittaja.write("##");
        }
        this.kirjoittaja.close();
    }
    
}
