package dataObjects;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import management.WarenkorbVW;

public class Rechnung {

    // Attribute
    private Kunde kunde;
    private ArrayList<WarenkorbArtikel> wkArtikel;
    private String datum;
    private float gesamtpreis;

    // Konstruktor
    public Rechnung(Kunde kunde, ArrayList<WarenkorbArtikel> wkArtikel, float gesamtpreis) {
        this.kunde = kunde;
        this.wkArtikel = wkArtikel;
        this.datum = generateSimpleDatum();
        this.gesamtpreis = gesamtpreis;
    }

    // Getter und Setter
    public String getDatum() {
        return datum;
    }

    /**
     * Gesamtpreis des Warenkorbes wird generiert
     * 
     * @param warenkorb
     * @return
     */
    public float getGesamtpreis(WarenkorbVW warenkorb) {
        float gesamtpreis = 0;
        for (WarenkorbArtikel wkArtikel : warenkorb.getWarenkorbArtikel()) {
            gesamtpreis += wkArtikel.getPreis() * wkArtikel.getAnzahl();
        }
        return gesamtpreis;
    }

    /**
     * Methode zum Generieren eines Datums
     * 
     * @return neues Datum
     */
    public String generateSimpleDatum() {
        return new SimpleDateFormat("dd.MM.yyy HH:mm").format(new Date());
    }
}
