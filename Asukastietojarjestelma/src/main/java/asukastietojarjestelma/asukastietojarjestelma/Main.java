
package asukastietojarjestelma.asukastietojarjestelma;

import asukastietojarjestelma.domain.JarjestelmanOhjaus;
import asukastietojarjestelma.domain.TiedostonLukija;
import java.io.File;

public class Main {
    
    public static void main(String[] args) {
        TiedostonLukija lukija = new TiedostonLukija();
//        TiedostonTallentaja tallentaja = new TiedostonTallentaja();
        JarjestelmanOhjaus ohjaus = new JarjestelmanOhjaus(lukija);
        ohjaus.suorita();
    }
    
}
