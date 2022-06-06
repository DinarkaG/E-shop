package management;

import java.util.ArrayList;

import dataObjects.Ereignis;
import exceptions.KeineEreignisse;

public class EreignisVW {
    // Attribute
    private ArrayList<Ereignis> ereignisListe;

    public EreignisVW() {
        ereignisListe = new ArrayList<Ereignis>();
    }

    /**
     * Methode zum Hinzufügen von Ereignissen in die Ereignisliste
     * 
     * @param ereignis
     */
    public void ereignisHinzufuegen(Ereignis ereignis) {
        ereignisListe.add(ereignis);
    }

    /**
     * Methode, um Ereginisse für einen bestimmten Artikel auszugeben (nach Datum
     * sortiert)
     * 
     * @param artikelname
     * @return
     * @throws KeineEreignisse
     */
    public ArrayList<Ereignis> getEreignisForArtikel(String artikelname) throws KeineEreignisse {
        ArrayList<Ereignis> newEreignisListe = new ArrayList<Ereignis>();
        for (Ereignis ereignis : ereignisListe) {
            if (ereignis.getArtikel().getBezeichnung() == artikelname) {
                newEreignisListe.add(ereignis);
            }
        }

        ereignisListe.sort(((o, o1) -> o.getDatum().compareTo(o1.getDatum())));
        if (ereignisListe.size() == 0) {
            throw new KeineEreignisse();
        }
        return newEreignisListe;
    }

    // Getter und Setter
    public ArrayList<Ereignis> getEreignisListe() {
        return this.ereignisListe;
    }
}
