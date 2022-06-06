package dataObjects;

import java.io.Serializable;

public class Artikel implements Serializable {

    // Attribute
    private String bezeichnung;
    private int artikelnummer;
    private int artikelBestand;
    private double preis;

    // Konstruktor
    public Artikel(String bezeichnung, int artikelbestand, double preis, int artikelnummer) {
        this.artikelnummer = artikelnummer;
        this.bezeichnung = bezeichnung;
        this.artikelBestand = artikelbestand;
        this.preis = preis;
    }

    @Override
    public String toString() {
        return "Nr. " + getArtikelnummer() + "  " + getBezeichnung() + "  " + getArtikelBestand() + " Stck  "
                + getPreis() + "€";
    }

    // Getter und Setter
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setArtikelnummer(int artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public int getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelBestand(int artikelBestand) {
        this.artikelBestand = artikelBestand;
    }

    public int getArtikelBestand() {
        return artikelBestand;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

}
