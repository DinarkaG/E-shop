package dataObjects;

public class Nutzer {

    private String name;
    private int nummer;
    public String passwort;




    public Nutzer(String name, int nummer, String passwort){
        this.name = name;
        this.nummer = nummer;
        this.passwort = passwort;
    }



    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPasswort(String passwort){this.passwort = passwort;}

    public int getNummer() {
        return nummer;
    }

    public String getName() {
        return name;
    }

    public String getPasswort() { return passwort; }
}
