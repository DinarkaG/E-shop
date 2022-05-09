package dataObjects;

import management.Warenkorb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Rechnung {

    //Attribute
    private String kunde;
    private ArrayList<WarenkorbArtikel> wkArtikel;
    private String datum;
    private float gesamtpreis;

    //Konstruktor
    public Rechnung(Kunde kunde, ArrayList<WarenkorbArtikel> wkArtikel, float gesamtpreis){
        this.kunde = kunde.getName();
        this.wkArtikel = wkArtikel;
        this.datum = generateSimpleDatum();
        this.gesamtpreis = gesamtpreis;
    }

    //Getter
    public String getDatum(){return datum;}
    /**
     * Gesamtpreis des Warenkorbes wird generiert
     * @param warenkorb
     * @return
     */
    public float getGesamtpreis( Warenkorb warenkorb) {
        float gesamtpreis = 0;
        for(WarenkorbArtikel wkArtikel : warenkorb.getWarenkorbList()){
            gesamtpreis += artikel.getPreis() * artikel.getAnzahl();
        }
        return gesamtpreis;
    }

    /**
     * Methode zum Generieren eines Datums
     * @return neues Datum
     */
    public String generateSimpleDatum() {
        return new SimpleDateFormat("dd.MM.yyy HH:mm").format(new Date());
    }
}
