package ui;

import management.ShopVW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import dataObjects.*;
import dataObjects.Ereignis.EreignisTyp;
import exceptions.*;

public class CUI {

    private BufferedReader in;
    public ShopVW eshop;

    public CUI() throws IOException {
        // die Shopverwaltung erledigt die Aufgaben, die nichts mit Ein-/Ausgabe zu tun
        // haben
        eshop = new ShopVW();
        // Stream-Objekt fuer Texteingabe ueber Konsolenfenster erzeugen
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Interne (private) Methode zum Einlesen von Mitarbeitereingaben.
     * 
     * @return
     * @throws IOException
     */
    private String liesEingabe() throws IOException {
        return in.readLine();

    }

    /**
     * Interne (private) Methode zum Einlesen von Mitarbeitereingaben.
     * 
     * @param output
     * @return
     * @throws IOException
     */
    private String liesEingabe(String output) throws IOException {
        System.out.println(output);
        // einlesen von Konsole
        return in.readLine();
    }

    // ____________________________________________________________________

    /**
     * Methode, um einen User (Kunden oder Mitarbeiter) anzumelden und das jeweilige
     * Menue auszugeben
     * 
     * @param line
     * @throws LoginError
     */
    public void userLogin(String line) throws Exception {
        int id;
        String passwort;

        id = Integer.parseInt(liesEingabe("UserId > "));
        passwort = liesEingabe("Passwort > ");

        try {
            eshop.userAnmelden(id, passwort);
        } catch (LoginError e) {
            System.out.println(e.getMessage());
        }
        System.out.println("_________________________________");
        System.out.println(" ");
        if (eshop.getEingeloggterNutzer() instanceof Kunde) {
            // Kunden anmelden
            System.out.println("Willkommen zurück " + eshop.getEingeloggterNutzer().getName() + "!");
            System.out.println(" ");
            kundenmenue();
        } else {
            // Mitarbeiter anmelden
            System.out.println("Willkommen zurück " + eshop.getEingeloggterNutzer().getName() + "!");
            System.out.println(" ");
            mitarbeitermenue();
        }
    }

    /**
     * Methode, um einen Kunden zu registrieren
     * 
     * @param line
     * @return Kunde
     * @throws IOException
     */
    public Kunde kundenRegistrieren(String line) throws Exception {
        int id;
        String passwort;
        String name;
        String straße;
        String hausnummer;
        int plz;
        String stadt;
        name = liesEingabe("Name >");
        id = Integer.parseInt(liesEingabe("Eindeutige nummerische Userid >"));
        passwort = liesEingabe("Passwort >");
        straße = liesEingabe("Straße >");
        hausnummer = liesEingabe("Hausnummer >");
        plz = Integer.parseInt(liesEingabe("Postleitzahl >"));
        stadt = liesEingabe("Stadt >");
        try {
            eshop.neuerKunde(name, id, passwort, straße, hausnummer, plz, stadt);
        } catch (IdExistiertBereits e) {
            System.out.println(e.getMessage());
        }
        return eshop.neuerKunde(name, id, passwort, straße, hausnummer, plz, stadt);
    }

    /**
     * Methode, um einen Mitarbeiter zu registrieren
     * 
     * @param line
     * @throws IOException
     */
    public void mitarbeiterRegistrieren(String line) throws Exception {
        int id;
        String passwort;
        String name;

        name = liesEingabe("Name >");
        id = Integer.parseInt(liesEingabe("Eindeutige nummerische Userid >"));
        passwort = liesEingabe("Passwort >");
        try {
            eshop.neuerMitarbeiter(name, id, passwort);
        } catch (IdExistiertBereits e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Ihr neuer Mitarbeiter " + name + " wurde erfolgreich hinzugefügt!");
    }

    // ____________________________________________________________________

    /**
     * Methode die das Startmenue ausgibt
     */
    public void startmenue() {
        System.out.println("  Willkommen auf unserer Seite!");
        System.out.println("       Einloggen:    'a'");
        System.out.println("       Registrieren: 'b'");
        System.out.println("----------------------- ");
        System.out.println("       Beenden:      'c'");
        System.out.println(">");
        System.out.flush(); // ohne NL ausgeben
    }

    /**
     * Methode zum Verarbeiten des Startmenues
     * 
     * @param line
     */
    public void verarbeiteStartmenue(String line) throws Exception {

        switch (line) {
            case "a":
                // Loggt den User als Kunden oder Mitarbeiter ein
                try {
                    userLogin(line);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "b":
                // Registriert einen neuen Kunden
                try {
                    eshop.setEingeloggterNutzer(kundenRegistrieren(line));
                    System.out.println("________________________________");
                    System.out.println(" ");
                    System.out.println("Willkommen " + eshop.getEingeloggterNutzer().getName() + "!");
                    System.out.println(" ");
                    kundenmenue();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "c":
                // Beendet den Eshop
                System.out.println("Verbindung zum Server abgebrochen.");
                System.exit(0);
                break;
        }
    }

    /**
     * Methode die das Kundenmenue ausgibt
     * 
     * @throws IOException
     */
    public void kundenmenue() throws Exception {
        System.out.println("       Artikel nummerisch sortiert ausgeben:  'd'");
        System.out.println("       Artikel alphabetisch sortiert ausgeben:'e'");
        System.out.println("       Warenkorb anzeigen:                    'f'");
        System.out.println("       Artikel zum Warenkorb hinzufügen:      'g'");
        System.out.println("       Artikel aus dem Warenkorb löschen:     'h'");
        System.out.println("       Artikel aus dem Warenkorb verringern:  'i'");
        System.out.println("       Artikel aus dem Warenkorb erhöhen:     'j'");
        System.out.println("       Warenkorb leeren:                      'k'");
        System.out.println("       Warenkorb kaufen:                      'l'");
        System.out.println("   --------------------------------------------- ");
        System.out.println("       Beenden:                               'c'");
        System.out.println("       Ausloggen:                             'm'");
        System.out.println(">");
        System.out.flush();

        verarbeiteKundenmenue(liesEingabe());
    }

    /**
     * Methode zum Verarbeiten des Kundenmenues
     * 
     * @param line
     */
    public void verarbeiteKundenmenue(String line) throws Exception {
        int anzahl;

        switch (line) {
            case "d":
                // Gibt Artikel nummerisch sortiert aus
                try {
                    for (Artikel artikel : eshop.nummer()) {
                        // Alle Artikel printen
                        System.out.println(artikel.toString());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("________________________________");
                System.out.println(" ");
                kundenmenue();
                break;
            case "e":
                // Gibt Artikel alphabetisch sortiert aus
                try {
                    for (Artikel artikel : eshop.alphabet()) {
                        // Alle Artikel printen
                        System.out.println(artikel.toString());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("________________________________");
                System.out.println(" ");
                kundenmenue();
                break;
            case "f":
                // Gibt den Warenkorb aus
                try {
                    System.out.println(" ");
                    System.out.println("Ihr Warenkorb:");
                    System.out.println("");
                    for (WarenkorbArtikel wkArtikel : eshop.getWarenkorbArtikel()) {
                        // Alle Warenkorbatikel printen
                        System.out.println(wkArtikel.toString(wkArtikel));
                    }
                    System.out.println("_______________________________");
                    System.out.println("Gesamtpreis: " + eshop.getGesamtpreis() + "€");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("________________________________");
                System.out.println(" ");
                kundenmenue();
                break;
            case "g":
                // Fügt Artikel in den Warenkorb hinzu
                String bezeichnung = liesEingabe("Artikelname > ");
                anzahl = Integer.parseInt(liesEingabe("Stückanzahl > "));
                try {
                    eshop.artikelInWarenkorb(bezeichnung, anzahl);
                    System.out.println("Es wurden erfolgreich " + anzahl + " " + bezeichnung + " hinzugefügt.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("________________________________");
                System.out.println(" ");
                kundenmenue();
                break;
            case "h":
                // Löscht Artikel aus dem Warenkorb
                String artikel = liesEingabe("Artikelname >");
                try {
                    eshop.wkArtikelLoeschen(eshop.wkArtikelSuchen(artikel));
                } catch (ArtikelExistiertNichtImWarenkorb e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("________________________________");
                System.out.println(" ");
                kundenmenue();
                break;
            case "i":
                // Verringert Artikel aus dem Warenkorb (oder löscht ihn raus)
                String wkArtikel = liesEingabe("Artikelname >");
                int verringern = Integer.parseInt(liesEingabe("Verringern um >"));
                try {
                    eshop.artikelAnzahlVerringern(eshop.wkArtikelSuchen(wkArtikel), verringern);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("________________________________");
                System.out.println(" ");
                kundenmenue();
                break;
            case "j":
                // Erhöht Artikel aus dem Warenkorb
                String wkArtikelname = liesEingabe("Artikelname >");
                int erhoehen = Integer.parseInt(liesEingabe("Erhöhen um >"));
                try {
                    eshop.artikelAnzahlErhoehen(eshop.wkArtikelSuchen(wkArtikelname), erhoehen);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("________________________________");
                System.out.println(" ");
                kundenmenue();
                break;
            case "k":
                // Leert den kompletten Warenkorb
                eshop.leeren();
                System.out.println("Ihr Warenkorb wurde geleert.");
                System.out.println("________________________________");
                System.out.println(" ");
                kundenmenue();
                break;
            case "l":
                // Kauft den Warenkorb
                try {
                    System.out.println("Vielen Dank für Ihren Einkauf!");
                    System.out.println("Ihre Rechnung:");
                    System.out.println("______________________");
                    System.out.println(eshop.warenkorbKaufen().toString());
                    eshop.warenkorbKaufen();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("______________________");
                System.out.println(" ");
                kundenmenue();
                break;
            case "m":
                // Loggt den Kunden aus
                eshop.ausloggen();
                startmenue();
                break;
            case "c":
                // Beendet den Shop
                System.out.println("Verbindung zum Server abgebrochen.");
                System.exit(0);
                break;
        }

    }

    /**
     * Methode die das Mitarbeitermenue ausgibt
     * 
     * @throws IOException
     */
    public void mitarbeitermenue() throws IOException {
        System.out.println("       Artikel nummerisch sortiert ausgeben:  'd'");
        System.out.println("       Artikel alphabetisch sortiert ausgeben:'e'");
        System.out.println("       Neuen Artikel erstellen:               'n'");
        System.out.println("       Artikelbestand erhöhen:                'o'");
        System.out.println("       Artikelbestand verringern:             'p'");
        System.out.println("       Artikel löschen:                       'q'");
        System.out.println("       Neuen Mitarbeiter registrieren:        'r'");
        System.out.println("       Ereignisse anzeigen:                   's'");
        System.out.println("      ------------------------------------------ ");
        System.out.println("        Beenden:                              'c'");
        System.out.println("        Ausloggen:                            'm'");
        System.out.println(">");
        System.out.flush();

        verarbeiteMitarbeitermenue(liesEingabe());

    }

    /**
     * Methode zum Verarbeiten des Mitarbeitermenues
     * 
     * @param line
     * @throws IOException
     */
    public void verarbeiteMitarbeitermenue(String line) throws IOException {
        switch (line) {
            case "d":
                // Gibt Artikel nummerisch sortiert aus
                try {
                    for (Artikel artikel : eshop.nummer()) {
                        // Alle Artikel printen
                        System.out.println(artikel.toString());
                    }
                } catch (KeineArtikel e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("________________________________");
                System.out.println(" ");
                mitarbeitermenue();
                break;
            case "e":
                // Gibt Artikel alphabetisch sortiert aus
                try {
                    for (Artikel artikel : eshop.alphabet()) {
                        // Alle Artikel printen
                        System.out.println(artikel.toString());
                    }
                } catch (KeineArtikel e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("________________________________");
                System.out.println(" ");
                mitarbeitermenue();
                break;
            case "n":
                // Erstellt neuen Artikel
                String bezeichnung = liesEingabe("Artikelbezeichnung > ");
                int nummer = Integer.parseInt(liesEingabe("Artikelnummer > "));
                int bestand = Integer.parseInt(liesEingabe("Bestand > "));
                String stringpreis = liesEingabe("Preis >");
                stringpreis = stringpreis.replace(",", ".");
                double preis = Double.parseDouble(stringpreis);
                int packungsgroesse = Integer.parseInt(liesEingabe("Packungsgroesse > "));
                try {
                    eshop.artikelAnlegen(bezeichnung, bestand, preis, nummer, packungsgroesse);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("________________________________");
                System.out.println(" ");
                mitarbeitermenue();
                break;
            case "o":
                // Erhöht den Bestand eines Artikels
                String artikelBezeichnung = liesEingabe("Artikelname >");
                int erhoehen = Integer.parseInt(liesEingabe("Erhöhen um >"));
                try {
                    eshop.bestandErhoehen(eshop.artikelSuchen(artikelBezeichnung), erhoehen);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("________________________________");
                System.out.println(" ");
                mitarbeitermenue();
                break;
            case "p":
                // Verringert den Bestand eines Artikels
                String artikelname = liesEingabe("Artikelname > ");
                int verringern = Integer.parseInt(liesEingabe("Verringern um > "));
                try {
                    eshop.bestandVerringern(eshop.artikelSuchen(artikelname), verringern, EreignisTyp.AUSLAGERUNG);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("________________________________");
                System.out.println(" ");
                mitarbeitermenue();
                break;
            case "q":
                // Löscht einen Artikel aus dem Sortiment
                String artikelbezeichnung = liesEingabe("Artikelname > ");
                try {
                    eshop.artikelLoeschen(eshop.artikelSuchen(artikelbezeichnung));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("________________________________");
                System.out.println(" ");
                mitarbeitermenue();
                break;
            case "r":
                // Registriert einen neuen Mitarbeiter
                try {
                    mitarbeiterRegistrieren(line);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("________________________________");
                System.out.println(" ");
                mitarbeitermenue();
                break;
            case "s":
                // Ereignisse für einen Artikel ausgeben
                String artikel = liesEingabe("Artikelname > ");
                try {
                    for (Ereignis ereignis : eshop.getEreignisForArtikel(artikel)) {
                        System.out.println(ereignis.toString());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("________________________________");
                System.out.println(" ");
                mitarbeitermenue();
                break;
            case "m":
                // Loggt den Mitarbeiter aus
                eshop.ausloggen();
                System.out.println("________________________________");
                System.out.println(" ");
                startmenue();
                break;
            case "c":
                // Beendet den Shop
                System.out.println("Verbindung zum Server abgebrochen.");
                System.exit(0);
                break;
        }

    }

    // ____________________________________________________________________

    /**
     * Methode, um die Menüs ausgeben zu können
     */
    public void run() {

        // Variable für Eingaben von der Konsole
        String input = "";

        startmenue();
        // Hauptschleife der Benutzungsschnittstelle
        do {
            try {
                eshop.kundeEinfuegen("Kristina", 1234, "1234", "Bremerstraße", "14b", 49456, "Bakum");
                eshop.mitarbeiterEinfuegen("Dinara", 99, "1209");
                eshop.kundeEinfuegen("Nadya", 0007, "1111", "Flughafenallee", "11", 29403, "Bremen");
                input = liesEingabe();
                verarbeiteStartmenue(input);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                startmenue();
            }

        } while (!input.equals("q"));
    }

    public static void main(String[] args) {
        CUI cui;
        try {
            cui = new CUI();
            cui.run();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
