
package asukastietojarjestelma.asukastietojarjestelma;

import asukastietojarjestelma.domain.JarjestelmanOhjaus;
import asukastietojarjestelma.domain.TiedostonLukija;
import java.io.File;

public class Main {
    
    public static void main(String[] args) {
        JarjestelmanOhjaus ohjaus = new JarjestelmanOhjaus();
        ohjaus.suorita();
    }
    
}
