package management;

import dataObjects.WarenkorbArtikel;

import java.util.ArrayList;

public class Warenkorb{

    public ArrayList<WarenkorbArtikel>WarenkorbListe = new ArrayList<>();

    //Getter und Setter Methoden

    public ArrayList<WarenkorbArtikel> getWarenkorbListe() {
        return WarenkorbListe;
    }
}
