package exceptions;

public class KeineArtikelInWarenkorb extends Exception {

    public KeineArtikelInWarenkorb() {
        super("Es befinden sich keine Artikel im Warenkorb.");
    }
}
