package ui;

import dataObjects.Mitarbeiter;
import management.ArtikelVW;
import management.MitarbeiterVW;
import management.ShopVW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CUI {

    private BufferedReader in;
    public ShopVW eshop;

    public CUI() {
        // Stream-Objekt fuer Texteingabe ueber Konsolenfenster erzeugen
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    /*
     * (non-Javadoc)
     *
     * Interne (private) Methode zum Einlesen von Mitarbeitereingaben.
     */
    private String liesEingabe() throws IOException {
        // einlesen von Konsole
        return in.readLine();
    }

    /**
     * Methode die das Startmenue ausgibt
     */
    public void startmenue() {
        System.out.println("Willkommen auf unserer Seite!");
        System.out.println("  /n     Einloggen: 'a'");
        System.out.println("  /n     Registrieren: 'b'");
        System.out.println("  /n --------------------- ");
        System.out.println("  /n     Beenden:    'c'");
        System.out.println(">");
        System.out.flush(); // ohne NL ausgeben
    }

    /**
     * Methode zum Verarbeiten des Startmenues
     */
    public void verarbeiteStartmenue(String line) {
        switch (line) {
            case "a":
                break;
            case "b":
                break;
            case "c":
                System.out.println("Verbindung zum Server abgebrochen.");
                break;
        }
    }

    /**
     * Methode die das Kundenmenue ausgibt
     */
    public void kundenmenue() {
        System.out.println("  /n   Artikel nummerisch sortiert ausgeben: 'd'");
        System.out.println("  /n   Artikel alphabetisch sortiert ausgeben:'e'");
        System.out.println("  /n   Warenkorb anzeigen:                   'f'");
        System.out.println("  /n   Artikel zum Warenkorb hinzufügen:     'g'");
        System.out.println("  /n   Artikel aus dem Warenkorb löschen:    'h'");
        System.out.println("  /n   Artikel aus dem Warenkorb verringern: 'i'");
        System.out.println("  /n   Artikel aus dem Warenkorb erhöhen:    'j'");
        System.out.println("  /n   Warenkorb leeren:                     'k'");
        System.out.println("  /n   Warenkorb kaufen:                     'l'");
        System.out.println("  /n ------------------------------------------ ");
        System.out.println("  /n   Beenden:                              'c'");
        System.out.println("  /n   Ausloggen:                            'm'");
        System.out.println(">");

    }

    /**
     * Methode zum Verarbeiten des Kundenmenues
     */
    public void verarbeiteKundenmenue(String line) {
        switch (line) {
            case "d":
                break;
            case "e":
                break;
            case "f":
                break;
            case "g":
                break;
            case "h":
                break;
            case "i":
                break;
            case "j":
                break;
            case "k":
                break;
            case "l":
                break;
            case "m":
                break;
            case "c":
                System.out.println("Verbindung zum Server abgebrochen.");
                break;
        }
    }

    /**
     * Methode die das Mitarbeitermenue ausgibt
     */
    public void mitarbeitermenue() {
        System.out.println("  /n   Artikel nummerisch sortiert ausgeben: 'd'");
        System.out.println("  /n   Artikel alphabetisch sortiert ausgeben:'e'");
        System.out.println("  /n   Neuen Artikel erstellen:               'n'");
        System.out.println("  /n   Artikelbestand erhöhen:                'o'");
        System.out.println("  /n   Artikelbestand verringern:             'p'");
        System.out.println("  /n   Artiekl löschen:                       'q'");
        System.out.println("  /n   Neuen Mitarbeiter registrieren:        'r'");
        System.out.println("  /n ------------------------------------------ ");
        System.out.println("  /n   Beenden:                              'c'");
        System.out.println("  /n   Ausloggen:                            'm'");
        System.out.println(">");
    }

    /**
     * Methode zum Verarbeiten des Mitarbeitermenues
     */
    public void verarbeiteMitarbeitermenue(String line) {
        switch (line) {
            case "d":
                break;
            case "e":
                break;
            case "n":
                break;
            case "o":
                break;
            case "p":
                break;
            case "q":
                break;
            case "r":
                break;
            case "m":
                break;
            case "c":
                System.out.println("Verbindung zum Server abgebrochen.");
                break;
        }
    }

    /**
     *
     * METHODE : EINLOGGEN
     *
     */
    /*
     * String name;
     * String password;
     * 
     * 
     * //Input (Name, Nummer, Passwort)
     * System.out.println("Geben Sie bitte den Namen ein: ");
     * name = liesEingabe();
     * System.out.println("Geben Sie bitte die Nummer ein: ");
     * int nummer = Integer.parseInt(liesEingabe());
     * System.out.println("Geben Sie bitte das Passwort ein");
     * password = liesEingabe();
     * 
     * Mitarbeiter m = null;
     * 
     * if (name.equals(m.getName())) {
     * if(nummer != m.getNummer()){
     * if(password.equals(m.getPasswort())){
     * }else if(name.equals(m.getName())){
     * System.out.println("Nummer und Passwort sind falsch");
     * }else if(nummer != m.getNummer()){
     * System.out.println("Name und Passwort sind falsch");
     * }else if(password.equals(m.getPasswort())){
     * System.out.println("Name und Nummer sind falsch");
     * }else if((name.equals(m.getName()))&& (nummer != m.getNummer())){
     * System.out.println("Passwort ist falsch");
     * }else if((name.equals(m.getName()))&&(password.equals(m.getPasswort()))) {
     * System.out.println("Nummer ist falsch");
     * }else if((nummer != m.getNummer())&&(password.equals(m.getPasswort()))){
     * System.out.println("Name ist falsch");
     * }else{
     * System.out.println("Name und Nummer und Passwort sind falsch");
     * }
     * }}
     */

    /**
     *
     * METHODE : REGISTRIEREN
     *
     */
    /*
     * public void registrieren() throws IOException {
     * String name;
     * int nummer = 0;
     * String passwort;
     * System.out.println("Erzeugen eines neuen Mitarbeiter");
     * System.out.println(" ");
     * System.out.println(" ");
     * System.out.println("Geben Sie bitte Ihren Namen ein");
     * try{
     * name = liesEingabe();
     * }catch (IOException e){
     * System.out.println("Bitte nur die Buchstaben nutzen ");
     * }
     * 
     * 
     * System.out.println("Geben Sie bitte Ihres Passwort ein");
     * passwort = liesEingabe();
     * 
     * //HIER NOCH BESPRECHEN
     * nummer++;
     * }
     */

    /**
     *
     * METHODE : ABMELDEN
     *
     */

    /*
     * public void abmelden(String antwort){
     * System.out.println("Wollen Sie abmelden?\n" +
     * "'Abmelden' für Ja");
     * switch (antwort){
     * case "Abmelden":
     * break;
     * 
     * }
     * }
     */
}
