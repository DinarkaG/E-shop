package management;

import dataObjects.Mitarbeiter;

import java.util.ArrayList;

public class MitarbeiterVW {

    // Attribute
    private ArrayList<Mitarbeiter> mitarbeiterListe;

    public MitarbeiterVW() {
        mitarbeiterListe = new ArrayList<>();
    }

    /**
     * Methode zum Einfügen eines Mitarbeiters in die mitarbeiterListe
     * 
     * @param name
     * @param id
     * @param passwort
     */
    public void mitarbeiterEinfuegen(String name, int id, String passwort) {
        Mitarbeiter neuerMitarbeiter = new Mitarbeiter(name, id, passwort);
        mitarbeiterListe.add(neuerMitarbeiter);
    }

    /**
     * Methode zum Suchen nach einem Mitarbeiter mit eingegebener Id und Passwort
     * 
     * @param id
     * @param passwort
     * @return den zutreffenden Mitarbeiter
     */
    public Mitarbeiter anmelden(int id, String passwort) {
        for (Mitarbeiter mitarbeiter : mitarbeiterListe) {
            if (id == mitarbeiter.getId() && passwort.equals(mitarbeiter.getPasswort())) {
                return mitarbeiter;
            }
        }
        return null;
    }

    /**
     * Methode, mit der man nach bereits vergebenen Ids sucht
     * 
     * @param id
     * @return
     */
    public boolean idSuchen(int id) {
        for (Mitarbeiter mitarbeiter : mitarbeiterListe) {
            if (id == mitarbeiter.getId()) {
                return true;
            }
        }
        return false;
    }

    // Getter und Setter
    public ArrayList<Mitarbeiter> getMitarbeiterListe() {
        return mitarbeiterListe;
    }

}
