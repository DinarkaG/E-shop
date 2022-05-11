package management;
import dataObjects.Artikel;
import java.util.Collections;
import java.util.Arrays;

import java.util.ArrayList;

public class ArtikelVW {
    private ArrayList<Artikel> artikelListe = new ArrayList<Artikel>();



    /**
     * Methode, die eine Artikelliste zurückgibt, die alphabetisch sortiert ist.
     * @return sortierte Liste aller Artikel in der ArtikelListe (Kopie)
     */
    public ArrayList<Artikel> alphabet(){
        //Erzeugen ein String  Array mit der Bezeichnung  der Artikeln
        String[] alp = new String[artikelListe.size()];
         int i = 0;
         //Hier geht man durch die Artikeln in ArtikelListe und fügt Artikelnbezeichnung in Array hinzu
        for (Artikel artikel : artikelListe) {
                alp[i] = artikel.getBezeichnung();
                i++;
        }
        //Sortieren Array
        Arrays.sort(alp);
        //Erzeugen eine neue Arraylist, in der die Artikel sortiert eingefügt werden
        ArrayList<Artikel> sort = new ArrayList<Artikel>();
        //For-Schleife in der, die Artikelbezeichnung des Arrays und die Artikelliste
        // vergliechen  und zurückgegeben werden
        for (String a : alp){
            for(Artikel b : artikelListe){
                if(a == b.getBezeichnung()){
                   sort.add(b);
                   break;
                }
            }}
            return sort;
    }


    /**
     * Methode, die eine Artikelliste zurückgibt, die numerisch sortiert ist.
     * @return sortierte Liste aller Artikel in der artikelListe (Kopie)
     */
    public ArrayList<Artikel> nummer(){
        //Erzeugen ein Int  Array mit der Nummern der Artikeln
        int[] num = new int[artikelListe.size()];
        int i = 0;
        //Hier geht man durch die Artikeln in ArtikelListe und fügt Artikelnnummer in Array hinzu
        for (Artikel artikel : artikelListe) {
            num[i] = artikel.getArtikelnummer();
            i++;
        }
        //Sortieren Array
        Arrays.sort(num);
        //Erzeugen eine neue Arraylist, in der die Artikel sortiert eingefügt werden
        ArrayList<Artikel> sort = new ArrayList<Artikel>();
    //For-Schleife in der, die Artikelbezeichnung des Arrays und die Artikelliste
    // vergliechen  und zurückgegeben werden
        for (int a : num){
            for(Artikel b : artikelListe){
                if(a == b.getArtikelnummer()){
                    sort.add(b);
                    break;
                }
            }}
        return sort;

    }
}
