package management;

import dataObjects.Artikel;

import java.util.ArrayList;
import java.util.Arrays;

public class ArtikelVW {

    private ArrayList<Artikel> artikelListe = new ArrayList<>();


    /**
     * Methode, die eine KOPIE der Artikelliste zurückgibt.
     * @return Liste aller Artikel in der artikelListe (Kopie)
     */
    public ArrayList<Artikel> getArtikelListe() {
        return new ArrayList<Artikel>(this.artikelListe);
    }


    /**
     * Methode, die eine Artikelliste zurückgibt, die alphabetisch sortiert ist.
     * @return sortierte Liste aller Artikel in der artikelListe (Kopie)
     */
    public ArrayList<Artikel> alphabet(){
        //String Array für Artikelbezeichnungen wird erzeugt
        String[] alphabetisch = new String[artikelListe.size()];
        int i = 0;
        //Hinzufügen von allen Artikelbezeichnungen der artikelListe in das alphabetisch Array
        for (Artikel artikel : artikelListe) {
            alphabetisch[i] = artikel.getBezeichnung();
            i++;
        }
        //Array sortieren
        Arrays.sort(alphabetisch);

        //Erzeugen eine neue Arraylist, in der die Artikel sortiert eingefügt werden
        ArrayList<Artikel> sort = new ArrayList<Artikel>();

        //For-Schleife in der die Artikelbezeichnung des Arrays und der Artikellist verglichen werden
        for (String bezeichnung : alphabetisch){
            for(Artikel artikel : artikelListe){
                //Bei Übereinstimmung wird der Artikel in die neue Arrayliste gepackt
                if(bezeichnung == artikel.getBezeichnung()){
                    sort.add(artikel);
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
        //int Array für Artikelbezeichnungen wird erzeugt
        int[] numereisch = new int[artikelListe.size()];
        int i = 0;
        //Hinzufügen von allen Artikelnummern der artikelListe in das numerisch Array
        for (Artikel artikel : artikelListe) {
            numereisch[i] = artikel.getArtikelnummer();
            i++;
        }
        //Array sortieren
        Arrays.sort(numereisch);
        //Erzeugen eine neue Arraylist, in der die Artikel sortiert eingefügt werden
        ArrayList<Artikel> sort = new ArrayList<Artikel>();
        //For-Schleife in der die Artikelnummern des Arrays und der Artikellist verglichen werden
        for (int nummer : numereisch){
            for(Artikel artikel : artikelListe){
                //Bei Übereinstimmung wird der Artikel in die neue Arrayliste gepackt
                if(nummer == artikel.getArtikelnummer()){
                    sort.add(artikel);
                    break;
                }
            }}
        return sort;
    }
}
