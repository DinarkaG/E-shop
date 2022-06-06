package exceptions;

public class IdExistiertBereits extends Exception {

    public IdExistiertBereits() {
        super("Die von Ihnen gewünschte Id existiert bereits.");

    }

}
