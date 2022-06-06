package management;

import dataObjects.Artikel;
import dataObjects.MassengutArtikel;
import exceptions.KeineArtikel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArtikelVW {

    // Attribute
    private ArrayList<Artikel> artikelListe;

    ObjectOutputStream oos;
    ObjectInputStream ois;
    File file = new File("persistence/Artikel.txt");

    public ArtikelVW() {
        artikelListe = new ArrayList<Artikel>();

        ladePersistenz();
    }

    /**
     * Methode zum Einfügen eines neuen Artikel in die artikelListe
     * 
     * @param bezeichnung
     * @param artikelbestand
     * @param preis
     * @param artikelnummer
     * @param packungsgroesse
     * @throws IOException
     * @throws FileNotFoundException
     */
    public Artikel artikelAnlegen(String bezeichnung, int artikelbestand, double preis, int artikelnummer,
            int packungsgroesse) throws FileNotFoundException, IOException {

        Artikel neuerArtikel;
        if (packungsgroesse <= 1) {
            neuerArtikel = new Artikel(bezeichnung, artikelbestand, preis, artikelnummer);
            artikelListe.add(neuerArtikel);
        } else {
            neuerArtikel = new MassengutArtikel(bezeichnung, artikelbestand, preis, artikelnummer,
                    packungsgroesse);
            artikelListe.add(neuerArtikel);
        }

        speicherePersistenz();

        return neuerArtikel;
    }

    /**
     * Methode zum Erhöhen des Bestands eines Artikels
     * 
     * @param artikel
     * @param anzahl
     */
    public void bestandErhoehen(Artikel artikel, int anzahl) {
        // In artikelListe nach gewünschten Artikel suchen
        for (Artikel lArtikel : artikelListe) {
            if (lArtikel.getArtikelnummer() == artikel.getArtikelnummer()) {
                // Bei übereinstimmung um gewünschte Anzahl erhöht
                artikel.setArtikelBestand(artikel.getArtikelBestand() + anzahl);
            }
        }

        speicherePersistenz();
    }

    /**
     * Methode zum Veringern des Bestands eines Artikels
     * 
     * @param artikel
     * @param anzahl
     */
    public void bestandVerringern(Artikel artikel, int anzahl) {
        // In artikelListe nach gewünschten Artikel suchen
        for (Artikel lArtikel : artikelListe) {
            if (lArtikel.getArtikelnummer() == artikel.getArtikelnummer()) {

                if (lArtikel.getArtikelBestand() > anzahl) {
                    // Wenn Anzahl kleiner ist als der Artikelbestands des gewünschten Artikels,
                    // wird der Bestand um Anzahl verringert
                    artikel.setArtikelBestand(artikel.getArtikelBestand() - anzahl);
                    // Ansonsten wird der gewünschte Artikel aus der artikelListe genommen
                } else {
                    artikelListe.remove(lArtikel);
                }
            }
        }

        speicherePersistenz();
    }

    /**
     * Methode, die eine Artikelliste zurückgibt, die alphabetisch sortiert ist.
     * 
     * @return sortierte Liste aller Artikel in der artikelListe (Kopie)
     * @throws KeineArtikel
     */
    public ArrayList<Artikel> alphabet() throws KeineArtikel {

        ArrayList<Artikel> kopie = new ArrayList<>(artikelListe);
        Collections.sort(kopie, new Comparator<Artikel>() {
            @Override
            public int compare(Artikel o1, Artikel o2) {
                return o1.getBezeichnung().compareTo(o2.getBezeichnung());
            }
        });
        if (kopie.size() > 0) {
            return kopie;
        } else {
            throw new KeineArtikel();
        }

    }

    /**
     * Methode, die eine Artikelliste zurückgibt, die numerisch sortiert ist.
     * 
     * @return sortierte Liste aller Artikel in der artikelListe (Kopie)
     * @throws KeineArtikel
     */
    public ArrayList<Artikel> nummer() throws KeineArtikel {

        ArrayList<Artikel> kopie = new ArrayList<>(artikelListe);
        Collections.sort(kopie, new Comparator<Artikel>() {
            @Override
            public int compare(Artikel o1, Artikel o2) {
                return o1.getArtikelnummer() - (o2.getArtikelnummer());
            }
        });
        if (kopie.size() > 0) {
            return kopie;
        } else {
            throw new KeineArtikel();
        }
    }

    /**
     * Methode, um einen Aartikel aus der Artikelliste zu löschen
     * 
     * @param artikel
     */
    public void artikelLoeschen(Artikel artikelZuLoeschen) {
        for (Artikel artikel : artikelListe) {
            if (artikel.getArtikelnummer() == artikelZuLoeschen.getArtikelnummer()) {
                artikelListe.remove(artikel);
                speicherePersistenz();
            }
        }
    }

    /**
     * Methode, um nach einem Artikel per Bezeichnung in der Artikelliste zu suchen
     * 
     * @param bezeichnung
     * @return den gesuchten Artikel
     */
    public Artikel artikelsuchen(String bezeichnung) {
        for (Artikel artikel : artikelListe) {
            if (artikel.getBezeichnung().equals(bezeichnung)) {
                return artikel;
            }
        }
        return null;
    }

    /**
     * Methode, um nach einem Artikel per Artikelnummer in der Artikelliste zu
     * suchen
     * 
     * @param nummer
     * @return den gesuchten Artikel
     */
    public Artikel artikelNummerSuchen(int nummer) {
        for (Artikel artikel : artikelListe) {
            if (artikel.getArtikelnummer() == nummer) {
                return artikel;
            }
        }
        return null;
    }

    public void speicherePersistenz() {
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(artikelListe);
            oos.close();

            ladePersistenz();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ladePersistenz() {
        try {
            if (file.isFile()) {
                ois = new ObjectInputStream(new FileInputStream(file));
                artikelListe = (ArrayList<Artikel>) ois.readObject();
                ois.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getter und Setter
    public ArrayList<Artikel> getArtikelListe() {
        return artikelListe;
    }
}
