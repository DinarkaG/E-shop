package exceptions;

public class ArtikelExistiertschon extends Exception {

    public ArtikelExistiertschon() {
        super("Der von Ihnen gewünschte Artikel existiert bereits.");

    }

}
