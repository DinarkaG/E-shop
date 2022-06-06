package exceptions;

public class KeineEreignisse extends Exception {

    public KeineEreignisse() {
        super("Es wurden keine Ereignisse aufgezeichnet.");
    }
}
