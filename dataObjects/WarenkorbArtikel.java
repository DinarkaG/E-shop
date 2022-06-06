package dataObjects;

public class WarenkorbArtikel {

    // Attribute
    public Artikel wkArtikel;
    public int anzahl;

    // Konstruktor
    public WarenkorbArtikel(Artikel wkArtikel, int anzahl) {
        this.wkArtikel = wkArtikel;
        this.anzahl = anzahl;
    }

    public String toString(WarenkorbArtikel artikel) {
        if (artikel.getWkArtikel() instanceof MassengutArtikel) {
            return "Nr. " + artikel.getArtikelnummer() + "  " + artikel.getBezeichnung() + "  "
                    + ((MassengutArtikel) artikel.getWkArtikel()).getPackungsgroesse() + "er Packung  "
                    + artikel.getAnzahl() + " Stck  " + artikel.getPreis() + "€";
        } else {
            return "Nr. " + artikel.getArtikelnummer() + "  " + artikel.getBezeichnung() + "  "
                    + artikel.getAnzahl() + " Stck  "
                    + artikel.getPreis() + "€";
        }

    }

    // Getter und Setter
    public Artikel getWkArtikel() {
        return wkArtikel;
    }

    public void setWkArtikel(Artikel wkArtikel) {
        this.wkArtikel = wkArtikel;
    }

    public double getPreis() {
        return wkArtikel.getPreis();
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public int getArtikelnummer() {
        return wkArtikel.getArtikelnummer();
    }

    public String getBezeichnung() {
        return wkArtikel.getBezeichnung();
    }
}
