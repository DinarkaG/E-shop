package dataObjects;

public class WarenkorbArtikel {

    //Attribute
    public Artikel wkArtikel;
    public int anzahl;
    public float preis;

    //Konstruktor
    public WarenkorbArtikel(Artikel wkArtikel, int anzahl) {
        this.wkArtikel = wkArtikel;
        this.anzahl = anzahl;
    }

    //Getter und Setter
    public Artikel getWkArtikel() {
        return wkArtikel;
    }

    public void setWkArtikel(Artikel wkArtikel) {
        this.wkArtikel = wkArtikel;
    }

    public float getPreis(){ return wkArtikel.getPreis(); }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public  int getArtikelnummer(){return wkArtikel.getArtikelnummer();}
}
