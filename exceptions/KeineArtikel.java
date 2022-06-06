package exceptions;

public class KeineArtikel extends Exception {

    public KeineArtikel() {
        super("Keine Artikel vorhanden.");
    }
}
