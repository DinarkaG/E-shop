package management;

import java.util.ArrayList;

import dataObjects.Artikel;
import dataObjects.Kunde;
import dataObjects.WarenkorbArtikel;
import exceptions.ArtikelExistiertNichtImWarenkorb;

public class Warenkorb {

    // Attribute
    private ArrayList<WarenkorbArtikel> wkInhalt;
    private Kunde kunde;

    // Konstruktor
    public Warenkorb(Kunde kunde) {
        wkInhalt = new ArrayList<>();
        this.kunde = kunde;
    }

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
    public void artikelAnzahlErhoehen(WarenkorbArtikel artikel, int anzahl) {
        artikel.setAnzahl(artikel.getAnzahl() + anzahl);
    }

    /**
     * Methode, um die Anzahl eines Warenkorbartikels zu verringern
     * 
     * @param artikel
     * @param anzahl
     */
    public void artikelAnzahlVerringern(WarenkorbArtikel artikel, int anzahl) {
        if (artikel.getAnzahl() > anzahl) {
            artikel.setAnzahl(artikel.getAnzahl() - anzahl);
        } else
            wkInhalt.remove(artikel);
    }

    /**
     * Methode zum Löschen eines Artikels aus dem wkInhalt
     * 
     * @param artikel
     */
    public void artikelLoeschen(WarenkorbArtikel artikel) {
        wkInhalt.remove(artikel);
    }

    /**
     * Methode zum Leeren des wkInhalts
     */
    public void leeren() {
        wkInhalt.clear();
    }

    /**
     * Methode, um nach einem Warenkorbartikel in der Warenkorbliste zu suchen
     * 
     * @param bezeichnung
     * @return den gesuchten Artikel
     * @throws ArtikelExistiertNichtImWarenkorb
     */
    public WarenkorbArtikel wkArtikelSuchen(String bezeichnung) {
        for (WarenkorbArtikel artikel : wkInhalt) {
            if (artikel.getBezeichnung().equals(bezeichnung)) {
                return artikel;
            }
        }
        return null;
    }

    /**
     * Gesamtpreis des Warenkorbes wird generiert
     * 
     * @return Gesamtpreis
     */
    public double getGesamtpreis() {
        double gesamtpreis = 0;
        for (WarenkorbArtikel wkArtikel : wkInhalt) {
            gesamtpreis += wkArtikel.getPreis() * wkArtikel.getAnzahl();
        }
        return gesamtpreis;
    }

    // Getter und Setter Methoden
    public ArrayList<WarenkorbArtikel> getWarenkorbArtikel() {
        return wkInhalt;
    }

    public Kunde getKunde() {
        return this.kunde;
    }

}
