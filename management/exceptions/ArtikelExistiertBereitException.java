package management.exceptions;

import dataObjects.Artikel;

public class ArtikelExistiertBereitException {
    Artikel artikel ;

    /**
     * Konstruktor
     */

    public ArtikelExistiertBereitException(Artikel artikel){
        super("Artikel mit der Bezeichnung " + artikel.getBezeichnung() +" , Bestand" + artikel.getArtikelBestand() +"" +
                ", Preis" + artikel.getPreis() + " , Artikelnummer" + artikel.getArtikelnummer() + "existiert schon");
        this.artikel = artikel;

    }
}
