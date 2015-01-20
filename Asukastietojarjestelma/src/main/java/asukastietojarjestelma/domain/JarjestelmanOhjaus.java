
package asukastietojarjestelma.domain;

import java.util.List;

public class JarjestelmanOhjaus {
    private List<Talo> talot;
    private List<Asukas> asukkaat;
    
    public JarjestelmanOhjaus() {
        //talojen ja siten asuntojen tietojen lataaminen jostain...
        //asukkaiden lataaminen jostain...
        
    }
    
    public void kaynnista() {
        // järjestelmän toimintojen hoitaminen...
    }
    
    public void lisaaTalo(){
        
    }
    
    // vai pitäisikö jotenkin olla että muokkaa asunnon tietoja.
    public void lisaaAsunto() {
        
    }
    
    //tarvitseeko??
    public void muokkaaAsunnonTietoja() {
        
    }
    //tarvitseeko??
    public void poistaAsunto() {
        
    }
    
    //ASUKKAASEEN LIITTYVIÄ TOIMINTOJA
    
    //tarkoittaa samalla vuokrasopimuksen solmimista
    public void lisaaAsukas() {
        
    }
    
    public void muokkaaAsukkaanTietoja() {
        // nimen muuttaminen
        // vuokrasopimuksen muuttaminen / päättäminen
    }
    
    
    
    //poistaa tiedot järjestelmästä kokonaan...vaiko siirtää arkistoon?
    public void poistaAsukas() {
        
    }
    
}
