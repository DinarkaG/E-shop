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
    public void miterbeiterEinfuegen(String name, int id, String passwort) {
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
    public Mitarbeiter mitarbeiterSuchen(int id, String passwort) {
        for (Mitarbeiter mitarbeiter : mitarbeiterListe) {
            if ((id - mitarbeiter.getId() == 0) && passwort.equals(mitarbeiter.getPasswort())) {
                return mitarbeiter;
            }
        }
        return null;
    }

    // Getter und Setter
    public ArrayList<Mitarbeiter> getMitarbeiterListe() {
        return mitarbeiterListe;
    }

}
