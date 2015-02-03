
package asukastietojarjestelma.asukastietojarjestelma;

import asukastietojarjestelma.domain.JarjestelmanOhjaus;
import asukastietojarjestelma.domain.TiedostonLukija;
import java.io.File;

public class Main {
    
    public static void main(String[] args) {
        TiedostonLukija lukija = new TiedostonLukija();
//        TiedostonTallentaja tallentaja = new TiedostonTallentaja();
        File vuokralaiset = new File("vuokralaiset.txt");
        File asunnot = new File("asunnot.txt");
        File sopimukset = new File("sopimukset.txt");
        JarjestelmanOhjaus ohjaus = new JarjestelmanOhjaus(lukija, vuokralaiset, asunnot, sopimukset);
        ohjaus.suorita();
    }
    
}
