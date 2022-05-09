package dataObjects;

public class Artikel {

    // Item descriptions as attributes
    private String bezeichnung;
    private int artikelnummer;
    private int artikelBestand;
    private int preis;

    //constructor methode
    public Artikel(String bezeichnung, int artikelbestand, int preis, int artikelnummer) {
        this.artikelnummer = artikelnummer;
        this.bezeichnung = bezeichnung;
        this.artikelBestand = artikelbestand;
        this.preis = preis;
    }

    // ------ Dienste der Artikel-Objekte ------

    //to-String methode
    public String toString() {
        return "Artikel{" +
                "Bezeichnung='" + bezeichnung + '\'' +
                ", Artikelnummer=" + artikelnummer +
                ", ArtikelBestand=" + artikelBestand +
                ", Preis=" + preis +
                '}';
    }

    //methode is used to compare two article objects. The attributes used in comparison are Artikelnummer and Bezeichnung
    public boolean equals(Object andererArtikel) {
        if (andererArtikel instanceof Artikel)
            return ((this.artikelnummer == ((Artikel) andererArtikel).artikelnummer)
                    && (this.bezeichnung.equals(((Artikel) andererArtikel).bezeichnung));
        else
            return false;
    }


    //getter-setter methode (Accesor Methode)
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

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

}
