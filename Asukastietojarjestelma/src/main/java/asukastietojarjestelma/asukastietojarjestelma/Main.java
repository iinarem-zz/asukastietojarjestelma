
package asukastietojarjestelma.asukastietojarjestelma;

import asukastietojarjestelma.domain.JarjestelmanOhjaus;
import asukastietojarjestelma.domain.TiedostonLukija;

public class Main {
    
    public static void main(String[] args) {
        TiedostonLukija lukija = new TiedostonLukija();
        JarjestelmanOhjaus ohjaus = new JarjestelmanOhjaus(lukija);
        ohjaus.suorita();
    }
    
}
