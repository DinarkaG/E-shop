package dataObjects;

public class Kunde extends Nutzer {
    public String adresse;
    //Warenkorb warenkorb;

    public Kunde(String name, int nummer, String a){
        super(name,nummer);
        this.adresse=a;

    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }
}
