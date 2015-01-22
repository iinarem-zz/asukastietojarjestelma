
package asukastietojarjestelma.domain;

public class Asukas {
    private String sukunimi;
    private String etunimi;
    private String hloTunnus;
    private String puhelinnumero;
    private String email;
    private Vuokrasopimus sopimus;
    private String lisatietoja;
    // tänne lista aiemmista vuokrasoppareista!
    
    public Asukas(String sukunimi, String etunimi, String hloTunnus, String puh, String email) {
        this.sukunimi = sukunimi;
        this.etunimi = etunimi;
        this.hloTunnus = hloTunnus;
        this.puhelinnumero = puh;
        this.email = email;
        this.lisatietoja = "";
        this.sopimus = null;
    }
    
    public String getNimi() {
        return this.etunimi + this.sukunimi;
    }
    
    public String getYhteystiedot() {
        return "puhelinnro: " + this.puhelinnumero +
                "\n" + "email: " + this.email + 
                "\n" + "osoite: "; //poimitaanko vuokrasopimukselta?
    }
    
    public Vuokrasopimus getVuokrasopimus() {
        return this.sopimus;
    }
    
    public void setNimi(String etun, String sukun) {
        //pitääkö tallentaa tieto vanhasta nimestä jonnekin esim. lisätietoihin?
        this.etunimi = etun;
        this.sukunimi = sukun;
        
    }
    
    public void setPuhelinnumero(String puh) {
        this.puhelinnumero = puh;
        // voiko olla useita numeroita?
        
    }
    
    public void setLisatiedot(String lisatiedot) {
        System.out.println("Nykyiset lisätiedot:");
        System.out.println(this.lisatietoja);
        
        this.lisatietoja += lisatiedot;
        //pitäis varmaan muokkaaminen kehittää... ei voi olla näin suoraviivaista
        
    }
    
    public void setEmail(String email) {
        this.email = email;
        
    }
    
    public void setVuokrasopimus(Vuokrasopimus soppari) {
        //vanhan päättäminen ja arkistointi eka tähän vai hoidetaanko jossain muualla???
        this.sopimus = soppari;
        
    }
    
    public String toString() {
        return "nimi: " + this.etunimi + " " + this.sukunimi + 
                "\nhenkilötunnus: " + this.hloTunnus + 
                "\npuhelinnro: " + this.puhelinnumero + 
                "\nemail: " + this.email;
        
        //pohdittavaa: tulostaako nykyisen asunnon tiedot? vai erillinen getteri sille.
        //pitäisikö sisällyttää osoite...
        
    }
    
}
