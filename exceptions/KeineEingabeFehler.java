package exceptions;

public class KeineEingabeFehler extends Exception {

    public KeineEingabeFehler() {
        super("Sie haben keine Eingabe getätigt.");
    }
}
