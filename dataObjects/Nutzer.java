package dataObjects;

public class Nutzer {
    public String name;
    public int eindeutNummer;
    public String passwort;



    public Nutzer(String name, int nummer, String passwort){
        this.name = name;
        this.eindeutNummer = nummer;
        this.passwort = passwort;
    }



    public void setEindeutNummer(int eindeutNummer) {
        this.eindeutNummer = eindeutNummer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPasswort(String passwort){this.passwort = passwort;}

    public int getEindeutNummer() {
        return eindeutNummer;
    }

    public String getName() {
        return name;
    }

    public String getPasswort() { return passwort; }
}
