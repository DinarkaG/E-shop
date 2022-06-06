package dataObjects;

public class Kunde extends Nutzer {
    // Attribute
    private String straße;
    public String hausnummer;
    public int postleitzahl;
    public String stadt;

    // Konstruktor
    public Kunde(String name, int nummer, String passwort, String straße, String hausnummer, int postleitzahl,
            String stadt) {
        super(name, nummer, passwort);
        this.straße = straße;
        this.hausnummer = hausnummer;
        this.postleitzahl = postleitzahl;
        this.stadt = stadt;
    }

    // Getter und Setter
    public void setStraße(String straße) {
        this.straße = straße;
    }

    public String getStraße() {
        return straße;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public int getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(int postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

}
