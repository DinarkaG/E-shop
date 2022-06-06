package exceptions;

public class NichtGenugAnzahl extends Exception {

    public NichtGenugAnzahl() {
        super("Nicht genügend Artikel auf Lager.");

    }
}
