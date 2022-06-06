package management;

import java.util.ArrayList;

import dataObjects.Artikel;
import dataObjects.Ereignis;
import dataObjects.Kunde;
import dataObjects.MassengutArtikel;
import dataObjects.Mitarbeiter;
import dataObjects.Nutzer;
import dataObjects.Rechnung;
import dataObjects.WarenkorbArtikel;
import dataObjects.Ereignis.EreignisTyp;
import exceptions.*;

public class ShopVW {

    // Attribute
    private ArtikelVW meineArtikel;
    private KundenVW meineKunden;
    private MitarbeiterVW meineMitarbeiter;
    private WarenkorbVW meineWarenkoerbe;
    private Nutzer eingeloggterNutzer;
    private EreignisVW meineEreignisse;

    public ShopVW() {
        meineArtikel = new ArtikelVW();
        meineKunden = new KundenVW();
        meineMitarbeiter = new MitarbeiterVW();
        meineWarenkoerbe = new WarenkorbVW();
        eingeloggterNutzer = null;
        meineEreignisse = new EreignisVW();
    }

    // Getter und Setter
    public Nutzer getEingeloggterNutzer() {
        return eingeloggterNutzer;
    }

    public void setEingeloggterNutzer(Nutzer eingeloggterNutzer) {
        this.eingeloggterNutzer = eingeloggterNutzer;
    }

    /**
     * Methode, die einen User ausloggt
     */
    public void ausloggen() {
        eingeloggterNutzer = null;
    }

    /**
     * Methode, um einen Nutzer (Kunden oder Mitarbeiter) anzumelden
     * 
     * @param id
     * @param passwort
     * @throws LoginError
     */
    public void userAnmelden(int id, String passwort) throws LoginError {
        eingeloggterNutzer = kundenAnmelden(id, passwort);
        if (eingeloggterNutzer != null)
            warenkorbHinzufuegen((Kunde) eingeloggterNutzer);

        if (eingeloggterNutzer == null) {
            eingeloggterNutzer = mitarbeiterAnmelden(id, passwort);
            if (eingeloggterNutzer == null) {
                throw new LoginError();
            }
        }

    }

    // __________________________________________________________________

    // Mitarbeiter-Methoden
    public void mitarbeiterEinfuegen(String name, int id, String passwort) {
        meineMitarbeiter.mitarbeiterEinfuegen(name, id, passwort);
    }

    public Mitarbeiter mitarbeiterAnmelden(int id, String passwort) {
        return meineMitarbeiter.anmelden(id, passwort);
    }

    public boolean mitarbeiteridSuchen(int id) {
        return meineMitarbeiter.idSuchen(id);
    }

    /**
     * Methode, um einen neuen Mitarbeiter zu registrieren
     * 
     * @param name
     * @param id
     * @param passwort
     * @throws IdExistiertBereits
     */
    public void neuerMitarbeiter(String name, int id, String passwort) throws IdExistiertBereits {
        if (mitarbeiteridSuchen(id) != true) {
            mitarbeiterEinfuegen(name, id, passwort);
        } else {
            throw new IdExistiertBereits();
        }
    }

    public ArrayList<Mitarbeiter> getMitarbeiterListe() {
        return meineMitarbeiter.getMitarbeiterListe();
    }

    // ________________________________________________________________________________
    // KundenVW-Methoden

    /**
     * Fügt einen neuen Kunden und seinen dazu gehörigen Warenkorb ein
     * 
     * @param name
     * @param nummer
     * @param passwort
     * @param straße
     * @param hausnummer
     * @param postleitzahl
     * @param stadt
     * @return neuen Kunden
     */
    public Kunde kundeEinfuegen(String name, int nummer, String passwort, String straße, String hausnummer,
            int postleitzahl, String stadt) {
        return meineKunden.kundeEinfuegen(name, nummer, passwort, straße, hausnummer, postleitzahl, stadt);
    }

    public Kunde kundenAnmelden(int id, String passwort) {
        return meineKunden.anmelden(id, passwort);
    }

    /**
     * Methode, um einen neuen Kunden zu registrieren
     * 
     * @param name
     * @param id
     * @param passwort
     * @param straße
     * @param hausnummer
     * @param plz
     * @param stadt
     * @return neuen Nunden
     * @throws IdExistiertBereits
     */
    public Kunde neuerKunde(String name, int id, String passwort, String straße, String hausnummer, int plz,
            String stadt) throws IdExistiertBereits {
        if (kundenidSuchen(id) != true) {
            return kundeEinfuegen(name, id, passwort, straße, hausnummer, plz, stadt);
        } else {
            throw new IdExistiertBereits();
        }
    }

    public boolean kundenidSuchen(int id) {
        return meineKunden.idSuchen(id);
    }

    public ArrayList<Kunde> getKundenListe() {
        return meineKunden.getKundenListe();
    }

    // __________________________________________________________________

    // ArtikelVW-Methoden
    /**
     * Legt einen neuen (Massengut-)Artikel an
     * 
     * @param bezeichnung
     * @param artikelbestand
     * @param preis
     * @param artikelnummer
     * @param packungsgroesse
     * @throws Exception
     */
    public void artikelAnlegen(String bezeichnung, int artikelbestand, double preis, int artikelnummer,
            int packungsgroesse) throws Exception {
        // Es muss überprüft werden, ob die Artikelnummer bereits existiert
        if (artikelNummerSuchen(artikelnummer) == null) {
            Artikel artikel = meineArtikel.artikelAnlegen(bezeichnung, artikelbestand, preis, artikelnummer,
                    packungsgroesse);
            // Ein neues Ereignis wird erzeugt
            ereignisHinzufuegen(
                    new Ereignis(
                            artikel,
                            "+" + artikelbestand, getEingeloggterNutzer(), EreignisTyp.NEU));
        } else {
            throw new ArtikelNummerExistiertBereits();
        }
    }

    public void bestandErhoehen(Artikel artikel, int anzahl) throws MassengutFehler {
        if (anzahl % ((MassengutArtikel) artikel).getPackungsgroesse() == 0) {
            meineArtikel.bestandErhoehen(artikel, anzahl);
            ereignisHinzufuegen(
                    new Ereignis(artikel, "+" + anzahl, getEingeloggterNutzer(), EreignisTyp.EINLAGERUNG));
        } else {
            throw new MassengutFehler();
        }
    }

    public void bestandVerringern(Artikel artikel, int anzahl, EreignisTyp aktion) throws Exception {
        if (artikel.getArtikelBestand() >= anzahl) {
            if (anzahl % ((MassengutArtikel) artikel).getPackungsgroesse() == 0) {
                meineArtikel.bestandVerringern(artikel, anzahl);
                ereignisHinzufuegen(
                        new Ereignis(artikel, "-" + anzahl, getEingeloggterNutzer(), aktion));
            } else {
                throw new MassengutFehler();
            }
        } else {
            throw new NichtGenugAnzahl();
        }
    }

    public ArrayList<Artikel> alphabet() throws KeineArtikel {
        return meineArtikel.alphabet();
    }

    public ArrayList<Artikel> nummer() throws KeineArtikel {
        return meineArtikel.nummer();
    }

    public void artikelLoeschen(Artikel artikel) {
        meineArtikel.artikelLoeschen(artikel);
        ereignisHinzufuegen(
                new Ereignis(artikel, "-" + artikel.getArtikelBestand(), getEingeloggterNutzer(),
                        EreignisTyp.AUSLAGERUNG));
    }

    public Artikel artikelSuchen(String bezeichnung) throws Exception {
        if (meineArtikel.artikelsuchen(bezeichnung) != null) {
            return meineArtikel.artikelsuchen(bezeichnung);
        } else {
            throw new ArtikelExistiertNicht();
        }

    }

    public Artikel artikelNummerSuchen(int nummer) {
        return meineArtikel.artikelNummerSuchen(nummer);
    }

    public ArrayList<Artikel> getArtikelListe() {
        return meineArtikel.getArtikelListe();
    }

    // __________________________________________________________________
    // Warenkorb-Methoden

    /**
     * Erstellt eine Rechnung und leert den Warenkorb
     * 
     * @return
     * @throws Exception
     */
    public Rechnung warenkorbKaufen() throws Exception {
        if (getWarenkorbArtikel().size() > 0) {
            Rechnung re = new Rechnung((Kunde) getEingeloggterNutzer(), getWarenkorbArtikel(), getGesamtpreis());
            for (WarenkorbArtikel wkArtikel : getWarenkorbArtikel()) {
                bestandVerringern(artikelSuchen(wkArtikel.getBezeichnung()), wkArtikel.getAnzahl(), EreignisTyp.KAUF);
            }
            leeren();
            return re;
        } else {
            throw new KeineArtikelInWarenkorb();
        }
    }

    public void warenkorbHinzufuegen(Kunde kunde) {
        meineWarenkoerbe.warenkorbHinzufuegen(kunde);
    }

    /**
     * Fügt einen Artikel in den Warenkorb hinzu oder erhöht seinen Bestand
     * 
     * @param bezeichnung
     * @param anzahl
     * @throws Exception
     */
    public void artikelInWarenkorb(String bezeichnung, int anzahl) throws Exception {
        // Wenn ein Artikel mit der Bezeichnung im Warenkorb bereits existiert, soll der
        // Bestand im Warenkorb erhöht werden
        if (wkArtikelSuchenWithoutException(bezeichnung) != null) {
            // Die neue Anzahl + die Warenkorbanzahl darf nicht größer als der
            // Artikelbestand sein
            if (wkArtikelSuchen(bezeichnung).getAnzahl() + anzahl <= artikelSuchen(bezeichnung)
                    .getArtikelBestand()) {
                // Bei Massengutartikeln muss die Packungsgroeße eingehalten werden
                if (artikelSuchen(bezeichnung) instanceof MassengutArtikel) {
                    if (anzahl % ((MassengutArtikel) artikelSuchen(bezeichnung)).getPackungsgroesse() == 0) {
                        artikelAnzahlErhoehen(wkArtikelSuchen(bezeichnung), anzahl);
                    } else {
                        throw new MassengutFehler();
                    }
                } else {
                    artikelAnzahlErhoehen(wkArtikelSuchen(bezeichnung), anzahl);
                }

            } else {
                throw new NichtGenugAnzahl();
            }
            // Falls der Artikel nicht im Warenkorb existiert, soll er hinzugefügt werden
        } else {
            // Die Anzahl darf nicht groeßer als der Artikelbestand sein
            if (anzahl <= artikelSuchen(bezeichnung).getArtikelBestand()) {
                // Bei Massengutartikeln muss die Packungsgroeße eingehalten werden
                if (artikelSuchen(bezeichnung) instanceof MassengutArtikel) {
                    if (anzahl % ((MassengutArtikel) artikelSuchen(bezeichnung)).getPackungsgroesse() == 0) {
                        artikelHinzufuegen(artikelSuchen(bezeichnung), anzahl);
                    } else {
                        throw new MassengutFehler();
                    }
                } else {
                    artikelHinzufuegen(artikelSuchen(bezeichnung), anzahl);
                }
            } else {
                throw new NichtGenugAnzahl();
            }
        }

    }

    public void artikelHinzufuegen(Artikel artikel, int anzahl) {
        meineWarenkoerbe.getWarenkorbForKunde((Kunde) getEingeloggterNutzer()).artikelHinzufuegen(artikel, anzahl);
    }

    /**
     * Erhöht die Anzahl eines Artikel im Warenkorb
     * 
     * @param artikel
     * @param anzahl
     * @throws Exception
     */
    public void artikelAnzahlErhoehen(WarenkorbArtikel artikel, int anzahl) throws Exception {
        // Es wird überprüft, ob der Artikel sich im Warenkorb befindet
        if (wkArtikelSuchen(artikel.getBezeichnung()) != null) {
            // Die Anzahl der Artikel,die im Warenkorb sind, + die neue Anzahl dürfen nicht
            // höher als der Bestand des Artikels sein
            if (artikel.getAnzahl() + anzahl <= artikelSuchen(artikel.getBezeichnung()).getArtikelBestand()) {
                // Falls der gewünschte Artikel ein Massengutartikel ist, muss die Packungsgröße
                // eingehalten werden
                if (artikel.getWkArtikel() instanceof MassengutArtikel) {
                    if (anzahl % ((MassengutArtikel) artikel.getWkArtikel()).getPackungsgroesse() == 0) {
                        meineWarenkoerbe.getWarenkorbForKunde((Kunde) getEingeloggterNutzer())
                                .artikelAnzahlErhoehen(artikel, anzahl);
                    } else {
                        throw new MassengutFehler();
                    }
                } else {
                    meineWarenkoerbe.getWarenkorbForKunde((Kunde) getEingeloggterNutzer())
                            .artikelAnzahlErhoehen(artikel, anzahl);
                }
            } else {
                throw new NichtGenugAnzahl();
            }
        }
    }

    /**
     * Verringert die Anzahl eines Artikel im Warenkorb oder entfernt ihn
     * 
     * @param artikel
     * @param anzahl
     * @throws Exception
     */
    public void artikelAnzahlVerringern(WarenkorbArtikel artikel, int anzahl) throws Exception {
        // Es wird überprüft, ob der Artikel sich im Warenkorb befindet
        if (wkArtikelSuchen(artikel.getBezeichnung()) != null) {
            // Falls der gewünschte Artikel ein Massengutartikel ist, muss die Packungsgröße
            // eingehalten werden
            if (artikel.getWkArtikel() instanceof MassengutArtikel) {
                if (anzahl % ((MassengutArtikel) artikel.getWkArtikel()).getPackungsgroesse() == 0) {
                    meineWarenkoerbe.getWarenkorbForKunde((Kunde) getEingeloggterNutzer())
                            .artikelAnzahlVerringern(artikel, anzahl);
                } else {
                    throw new MassengutFehler();
                }
            } else {
                meineWarenkoerbe.getWarenkorbForKunde((Kunde) getEingeloggterNutzer())
                        .artikelAnzahlVerringern(artikel, anzahl);
            }
        } else {
            throw new ArtikelExistiertNichtImWarenkorb();
        }
    }

    public void wkArtikelLoeschen(WarenkorbArtikel artikel) throws ArtikelExistiertNichtImWarenkorb {
        if (wkArtikelSuchen(artikel.getWkArtikel().getBezeichnung()) != null) {
            meineWarenkoerbe.getWarenkorbForKunde((Kunde) getEingeloggterNutzer()).artikelLoeschen(artikel);
        } else {
            throw new ArtikelExistiertNichtImWarenkorb();
        }
    }

    public void leeren() {
        meineWarenkoerbe.getWarenkorbForKunde((Kunde) getEingeloggterNutzer()).leeren();
    }

    public double getGesamtpreis() {
        return meineWarenkoerbe.getWarenkorbForKunde((Kunde) getEingeloggterNutzer()).getGesamtpreis();
    }

    public WarenkorbArtikel wkArtikelSuchen(String bezeichnung) throws ArtikelExistiertNichtImWarenkorb {
        WarenkorbArtikel wkArtikel = meineWarenkoerbe.getWarenkorbForKunde((Kunde) getEingeloggterNutzer())
                .wkArtikelSuchen(bezeichnung);
        if (wkArtikel != null) {
            return wkArtikel;
        }
        {
            throw new ArtikelExistiertNichtImWarenkorb();
        }
    }

    public WarenkorbArtikel wkArtikelSuchenWithoutException(String bezeichnung) {
        return meineWarenkoerbe.getWarenkorbForKunde((Kunde) getEingeloggterNutzer()).wkArtikelSuchen(bezeichnung);
    }

    public ArrayList<WarenkorbArtikel> getWarenkorbArtikel() throws KeineArtikelInWarenkorb {
        if (meineWarenkoerbe.getWarenkorbForKunde((Kunde) getEingeloggterNutzer()).getWarenkorbArtikel().size() > 0) {
            return meineWarenkoerbe.getWarenkorbForKunde((Kunde) getEingeloggterNutzer()).getWarenkorbArtikel();
        } else {
            throw new KeineArtikelInWarenkorb();
        }
    }

    public Warenkorb getWarenkorb(Nutzer eingeloggterNutzer) {
        return meineWarenkoerbe.getWarenkorbForKunde((Kunde) getEingeloggterNutzer());
    }

    // _____________________________________________________________________
    // EreignisVW-Methode,

    public ArrayList<Ereignis> getEreignisse() {
        return meineEreignisse.getEreignisListe();
    }

    public void ereignisHinzufuegen(Ereignis ereignis) {
        meineEreignisse.ereignisHinzufuegen(ereignis);
    }

    public ArrayList<Ereignis> getEreignisForArtikel(String artikelname) throws KeineEreignisse {
        return meineEreignisse.getEreignisForArtikel(artikelname);
    }

}
