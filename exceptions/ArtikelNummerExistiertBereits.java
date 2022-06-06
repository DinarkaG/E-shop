package exceptions;

public class ArtikelNummerExistiertBereits extends Exception {

    public ArtikelNummerExistiertBereits() {
        super("Die von Ihnen gewünschte Artikelnummer ist bereits vergeben.");
    }

}
