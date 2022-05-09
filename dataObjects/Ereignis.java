package dataObjects;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ereignis {

    //Attribute
    private String datum;
    private Artikel artikel;
    private int aenderung;
    private String username;

    //Konstruktor
    public Ereignis( Artikel artikel, int aenderung, String username) {
        datum = generateSimpleDatum();
        this.artikel = artikel;
        this.aenderung = aenderung;
        this.username = username;
    }

    //Getter und Setter
    public String getDatum() { return datum;}

    public String generateSimpleDatum() {
        return new SimpleDateFormat("dd.MM.yyy HH:mm").format(new Date());
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public int getAenderung() {
        return this.aenderung;
    }

    public void setAenderung(int aenderung) {
        this.aenderung = aenderung;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
