package dataObjects;

public class Artikel {

    //Attribute
    private String bezeichnung;
    private int artikelnummer;
    private int artikelBestand;
    private float preis;

    //Konstruktor
    public Artikel(String bezeichnung, int artikelbestand, float preis, int artikelnummer) {
        this.artikelnummer = artikelnummer;
        this.bezeichnung = bezeichnung;
        this.artikelBestand = artikelbestand;
        this.preis = preis;
    }

    //Getter und Setter
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

    public float getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }
}
