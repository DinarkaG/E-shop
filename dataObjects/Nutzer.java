package dataObjects;

public class Nutzer {
    //Attribute
    public String name;
    public int id;
    public String passwort;

    //Konstruktor
    public Nutzer(String name, int nummer, String passwort){
        this.name = name;
        this.id = nummer;
        this.passwort = passwort;
    }


    //Getter und Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPasswort(String passwort){this.passwort = passwort;}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPasswort() { return passwort; }
}
