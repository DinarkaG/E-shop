package management;

import dataObjects.Kunde;
import dataObjects.Mitarbeiter;

import java.util.ArrayList;

public class KundenVW {

    public static ArrayList<Kunde> kundenListe;

    public KundenVW() {
        kundenListe = new ArrayList<Kunde>();
    }

    /**
     * Methode zum Einfügen eines Kunden in die kundenListe
     * 
     * @param name
     * @param nummer
     * @param passwort
     * @param straße
     * @param hausnummer
     * @param postleitzahl
     * @param stadt
     */
    public void kundeEinfuegen(String name, int nummer, String passwort, String straße, String hausnummer,
            int postleitzahl, String stadt) {
        Kunde neuerKunde = new Kunde(name, nummer, passwort, straße, hausnummer, postleitzahl, stadt);
        kundenListe.add(neuerKunde);
    }

    /**
     * Methode zum Suchen nach einen Kunden mit eingegebener Id und Passwort
     * 
     * @param id
     * @param passwort
     * @return den zutreffenden Kunden
     */
    public Kunde kundeSuchen(int id, String passwort) {
        for (Kunde kunde : kundenListe) {
            if ((id - kunde.getId() == 0) && passwort.equals(kunde.getPasswort())) {
                return kunde;
            }
        }
        return null;
    }

    // Getter und Setter
    public static ArrayList<Kunde> getKundenListe() {
        return kundenListe;
    }
}
