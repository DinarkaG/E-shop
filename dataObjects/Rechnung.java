package dataObjects;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Rechnung {

    // Attribute
    private String datum;
    private Kunde kunde;
    private ArrayList<WarenkorbArtikel> gekaufteArtikel;
    private double gesamtpreis;

    public Rechnung(Kunde kunde, ArrayList<WarenkorbArtikel> gekaufteArtikel, double gesamtpreis) {
        this.datum = generateSimpleDatum();
        this.kunde = kunde;
        this.gekaufteArtikel = gekaufteArtikel;
        this.gesamtpreis = gesamtpreis;
    }

    // Getter und Setter
    public String getDatum() {
        return datum;
    }

    /**
     * Methode zum Generieren eines Datums
     * 
     * @return neues Datum
     */
    private String generateSimpleDatum() {
        return new SimpleDateFormat("dd.MM.yyy HH:mm").format(new Date());
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Kunde getKunde() {
        return this.kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public ArrayList<WarenkorbArtikel> getGekaufteArtikel() {
        return this.gekaufteArtikel;
    }

    public void setGekaufteArtikel(ArrayList<WarenkorbArtikel> gekaufteArtikel) {
        this.gekaufteArtikel = gekaufteArtikel;
    }

    public double getGesamtpreis() {
        return this.gesamtpreis;
    }

    public void setGesamtpreis(double gesamtpreis) {
        this.gesamtpreis = gesamtpreis;
    }

    // toString-Methode
    @Override
    public String toString() {
        String warenkorbArtikelPrint = "";

        for (WarenkorbArtikel warenkorbArtikel : getGekaufteArtikel()) {
            warenkorbArtikelPrint = "\n" +
                    warenkorbArtikel.getBezeichnung() + " " + warenkorbArtikel.getAnzahl() + " Stck "
                    + warenkorbArtikel.getPreis() + "€";
        }
        return "Datum: " + getDatum() + "\n" +
                "Name: " + getKunde() + "\n" +
                "gekaufte Artikel: " + warenkorbArtikelPrint + "\n" +
                "Gesamtpreis: " + getGesamtpreis();
    }

}
