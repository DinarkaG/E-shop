package management;

import dataObjects.Artikel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArtikelVW {

    // Attribute
    private ArrayList<Artikel> artikelListe;

    public ArtikelVW() {
        artikelListe = new ArrayList<Artikel>();
    }

    /**
     * Methode zum Einfügen eines neuen Artikel in die artikelListe
     * 
     * @param bezeichnung
     * @param artikelbestand
     * @param preis
     * @param artikelnummer
     */
    public void artikelAnlegen(String bezeichnung, int artikelbestand, float preis, int artikelnummer) {
        Artikel neuerArtikel = new Artikel(bezeichnung, artikelbestand, preis, artikelnummer);
        artikelListe.add(neuerArtikel);
    }

    /**
     * Methode zum Erhöhen des Bestands eines Artikels
     * 
     * @param artikel
     * @param anzahl
     */
    public void bestandErhoehen(Artikel artikel, int anzahl) {
        // In artikelListe nach gewünschten Artikel suchen
        for (Artikel lArtikel : artikelListe) {
            if (lArtikel.equals(artikel)) {
                // Bei übereinstimmung um gewünschte Anzahl erhöht
                artikel.setArtikelBestand(artikel.getArtikelBestand() + anzahl);
            }
        }
    }

    /**
     * Methode zum Veringern des Bestands eines Artikels
     * 
     * @param artikel
     * @param anzahl
     */
    public void bestandVerringern(Artikel artikel, int anzahl) {
        // In artikelListe nach gewünschten Artikel suchen
        for (Artikel lArtikel : artikelListe) {
            if (lArtikel.equals(artikel)) {
                if (lArtikel.getArtikelBestand() > anzahl) {
                    // Wenn Anzahl kleiner ist als der Artikelbestands des gewünschten Artikels,
                    // wird der Bestand um Anzahl verringert
                    artikel.setArtikelBestand(artikel.getArtikelBestand() - anzahl);
                    // Ansonsten wird der gewünschte Artikel aus der artikelListe genommen
                } else {
                    artikelListe.remove(lArtikel);
                }
            }
        }
    }

    /**
     * Methode, die eine Artikelliste zurückgibt, die alphabetisch sortiert ist.
     * 
     * @return sortierte Liste aller Artikel in der artikelListe (Kopie)
     */
    public ArrayList<Artikel> alphabet() {

        ArrayList<Artikel> kopie = new ArrayList<>(artikelListe);
        Collections.sort(kopie, new Comparator<Artikel>() {
            @Override
            public int compare(Artikel o1, Artikel o2) {
                return o1.getBezeichnung().compareTo(o2.getBezeichnung());
            }
        });
        return kopie;
    }

    /**
     * Methode, die eine Artikelliste zurückgibt, die numerisch sortiert ist.
     * 
     * @return sortierte Liste aller Artikel in der artikelListe (Kopie)
     */
    public ArrayList<Artikel> nummer() {

        ArrayList<Artikel> kopie = new ArrayList<>(artikelListe);
        Collections.sort(kopie, new Comparator<Artikel>() {
            @Override
            public int compare(Artikel o1, Artikel o2) {
                return o1.getArtikelnummer() - (o2.getArtikelnummer());
            }
        });
        return kopie;
    }

    // Getter und Setter
    public ArrayList<Artikel> getArtikelListe() {
        return artikelListe;
    }
}
