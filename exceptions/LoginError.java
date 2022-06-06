package exceptions;

public class LoginError extends Exception {

    public LoginError() {
        super("Ihr Passwort oder Ihre Id war fehlerhaft.");
    }

}