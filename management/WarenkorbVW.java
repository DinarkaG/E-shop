package management;

import java.util.ArrayList;

import dataObjects.Artikel;
import dataObjects.WarenkorbArtikel;

public class WarenkorbVW {

    // Attribute
    public ArrayList<WarenkorbArtikel> wkInhalt = new ArrayList<>();

    /**
     * Methode, um einen neuen Warenkorbartikel in die wkInhalt ArrayList
     * hinzuzufügen
     * 
     * @param artikel
     * @param anzahl
     */
    public void artikelHinzufuegen(Artikel artikel, int anzahl) {
        WarenkorbArtikel wkArtikel = new WarenkorbArtikel(artikel, anzahl);
        wkInhalt.add(wkArtikel);
    }

    /**
     * Methode, um die Anzahl eines Warenkorbartikels zu erhöhen
     * 
     * @param artikel
     * @param anzahl
     */
    public void artikelAnzahlErhoehen(Artikel artikel, int anzahl) {
        for (WarenkorbArtikel wkArtikel : wkInhalt) {
            if (wkArtikel.equals(artikel)) {
                wkArtikel.setAnzahl(wkArtikel.getAnzahl() + anzahl);
            }
        }
    }

    /**
     * Methode, um die Anzahl eines Warenkorbartikels zu verringern
     * 
     * @param artikel
     * @param anzahl
     */
    public void artikelAnzahlVerringern(Artikel artikel, int anzahl) {
        for (WarenkorbArtikel wkArtikel : wkInhalt) {
            if (wkArtikel.equals(artikel)) {
                if (wkArtikel.getAnzahl() > anzahl) {
                    wkArtikel.setAnzahl(wkArtikel.getAnzahl() - anzahl);
                } else
                    wkInhalt.remove(wkArtikel);
            }
        }
    }

    /**
     * Methode zum Löschen eines Artikels aus dem wkInhalt
     * 
     * @param artikel
     */
    public void artikelLoeschen(Artikel artikel) {
        wkInhalt.removeIf(warenkorbArtikel -> warenkorbArtikel.equals(artikel));
    }

    /**
     * Methode zum Leeren des wkInhalts
     */
    public void leeren() {
        wkInhalt.clear();
    }

    // Getter und Setter Methoden
    public ArrayList<WarenkorbArtikel> getWarenkorbArtikel() {
        return wkInhalt;
    }
}
