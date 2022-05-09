package dataObjects;

public class WarenkorbArtikel {
    //attributes
    public Artikel wkArtikel;
    public int anzahl;

    public WarenkorbArtikel(Artikel wkArtikel, int anzahl) {
        this.wkArtikel = wkArtikel;
        this.anzahl = anzahl;
    }

    //getter-setter methode (Accesor Methode)
    public Artikel getWkArtikel() {
        return wkArtikel;
    }

    public void setWkArtikel(Artikel wkArtikel) {
        this.wkArtikel = wkArtikel;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

}

