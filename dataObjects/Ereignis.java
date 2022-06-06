package dataObjects;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ereignis {

    // Attribute
    public enum EreignisTyp {
        NEU, KAUF, EINLAGERUNG, AUSLAGERUNG
    };

    private String datum;
    private Artikel artikel;
    private String aenderung;
    private EreignisTyp aktion;
    private Nutzer nutzer;

    // Konstruktor
    public Ereignis(Artikel artikel, String aenderung, Nutzer nutzer, EreignisTyp aktion) {
        datum = generateSimpleDatum();
        this.artikel = artikel;
        this.aenderung = aenderung;
        this.nutzer = nutzer;
        this.aktion = aktion;
    }

    @Override
    public String toString() {
        return getDatum() + " " + getArtikel().getBezeichnung() + " " + getAenderung() + " " + getAktion() + " von " +
                getNutzer().getName();
    }

    // Getter und Setter
    public EreignisTyp getAktion() {
        return this.aktion;
    }

    public void setAktion(EreignisTyp aktion) {
        this.aktion = aktion;
    }

    public String getDatum() {
        return datum;
    }

    public String generateSimpleDatum() {
        return new SimpleDateFormat("dd.MM.yyy HH:mm").format(new Date());
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public String getAenderung() {
        return this.aenderung;
    }

    public void setAenderung(String aenderung) {
        this.aenderung = aenderung;
    }

    public Nutzer getNutzer() {
        return this.nutzer;
    }

    public void setNutzer(Nutzer nutzer) {
        this.nutzer = nutzer;
    }

}
