package exceptions;

public class ArtikelExistiertNichtImWarenkorb extends Exception {

    public ArtikelExistiertNichtImWarenkorb() {
        super("Der von Ihnen gewünschte Artikel existiert nicht in Ihrem Warenkorb.");
    }
}
