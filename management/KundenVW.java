package management;

import dataObjects.Kunde;

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
    public Kunde kundeEinfuegen(String name, int nummer, String passwort, String straße, String hausnummer,
            int postleitzahl, String stadt) {
        Kunde neuerKunde = new Kunde(name, nummer, passwort, straße, hausnummer, postleitzahl, stadt);
        kundenListe.add(neuerKunde);
        return neuerKunde;
    }

    /**
     * Methode zum Suchen nach einen Kunden mit eingegebener Id und Passwort
     * 
     * @param id
     * @param passwort
     * @return den zutreffenden Kunden
     */
    public Kunde anmelden(int id, String passwort) {
        for (Kunde kunde : kundenListe) {
            if (id == kunde.getId() && passwort.equals(kunde.getPasswort())) {
                return kunde;
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
        for (Kunde kunden : kundenListe) {
            if (id == kunden.getId()) {
                return true;
            }
        }
        return false;
    }

    // Getter und Setter
    public ArrayList<Kunde> getKundenListe() {
        return kundenListe;
    }
}
