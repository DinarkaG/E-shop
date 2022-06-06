package dataObjects;

public class MassengutArtikel extends Artikel {

    // Attribute
    int packungsgroesse;

    // Konstruktor
    public MassengutArtikel(String bezeichnung, int artikelbestand, double preis, int artikelnummer,
            int packungsgroesse) {
        super(bezeichnung, artikelbestand, preis, artikelnummer);
        this.packungsgroesse = packungsgroesse;
    }

    // Getter und Setter
    public int getPackungsgroesse() {
        return this.packungsgroesse;
    }

    public void setPackungsgroesse(int packungsgroesse) {
        this.packungsgroesse = packungsgroesse;
    }

    // toString-Methode
    @Override
    public String toString() {
        return "Nr. " + getArtikelnummer() + "  " + getBezeichnung() + "  " + getPackungsgroesse() + "er Packung  "
                + getArtikelBestand() + " Stck  " + getPreis() + "€";
    }

}
