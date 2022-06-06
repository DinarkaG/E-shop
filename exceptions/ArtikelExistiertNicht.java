package exceptions;

public class ArtikelExistiertNicht extends Exception {

    public ArtikelExistiertNicht() {
        super("Der von Ihnen gewünschte Artikel existiert nicht.");

    }

}
