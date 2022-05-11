package management;
import dataObjects.Artikel;
import dataObjects.Mitarbeiter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.ArrayList;
    public class MitarbeiterVW {

        private ArrayList<Mitarbeiter> mitarbeiterListe = new ArrayList<>();
        private BufferedReader in;
        // Verwaltung des Artikelbestands in einer verketteten Liste


        public MitarbeiterVW(){
            // Stream-Objekt fuer Texteingabe ueber Konsolenfenster erzeugen
            in = new BufferedReader(new InputStreamReader(System.in));
        }


        /* (non-Javadoc)
         *
         * Interne (private) Methode zum Einlesen von Mitarbeitereingaben.
         */
        private String liesEingabe() throws IOException {
            // einlesen von Konsole
            return in.readLine();
        }

        /**
         *
         * METHODE : EINLOGGEN
         *
         */

        public void einloggen() throws IOException {
        String name;
        String password;


        //Input (Name, Nummer, Passwort)
        System.out.println("Geben Sie bitte den Namen ein: ");
        name = liesEingabe();
        System.out.println("Geben Sie bitte die Nummer ein: ");
        int nummer = Integer.parseInt(liesEingabe());
        System.out.println("Geben Sie bitte das Passwort ein");
        password = liesEingabe();

        Mitarbeiter m = null;

            if (name.equals(m.getName())) {
                if(nummer != m.getNummer()){
                    if(password.equals(m.getPasswort())){
                    }else if(name.equals(m.getName())){
                        System.out.println("Nummer und Passwort sind falsch");
                    }else if(nummer != m.getNummer()){
                        System.out.println("Name und Passwort sind falsch");
                    }else if(password.equals(m.getPasswort())){
                        System.out.println("Name und Nummer sind falsch");
                    }else if((name.equals(m.getName()))&& (nummer != m.getNummer())){
                        System.out.println("Passwort ist falsch");
                    }else if((name.equals(m.getName()))&&(password.equals(m.getPasswort()))) {
                        System.out.println("Nummer ist falsch");
                    }else if((nummer != m.getNummer())&&(password.equals(m.getPasswort()))){
                        System.out.println("Name ist falsch");
                                }else{
                                    System.out.println("Name und Nummer und Passwort sind falsch");
                    }
        }}
        }


        /**
         *
         * METHODE : REGISTRIEREN
         *
         */
        public void registrieren() throws IOException {
            String name;
            int nummer = 0;
            String passwort;
            System.out.println("Erzeugen eines neuen Mitarbeiter");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Geben Sie bitte Ihren Namen ein");
            try{
                name = liesEingabe();
            }catch (IOException e){
                System.out.println("Bitte nur die Buchstaben nutzen ");
            }


            System.out.println("Geben Sie bitte Ihres Passwort ein");
            passwort = liesEingabe();

            //HIER NOCH BESPRECHEN
            nummer++;
        }

        /**
         *
         * METHODE : ABMELDEN
         *
         */

        public void abmelden(String antwort){
            System.out.println("Wollen Sie abmelden?\n" +
                    "'Abmelden' für Ja");
            switch (antwort){
                case "Abmelden":
                    break;

            }
        }




        /**
         *
         * METHODE : FUEGEN(neue Artikel hinzufügen)
         *
         */
        public Artikel fuegenArtikelEin(String bezeichnung, int artikelbestand, int preis, int artikelnummer){

            Artikel a = new Artikel(bezeichnung, artikelbestand,preis, artikelnummer);

            return a;
        }

        /*public void einfuegen(Artikel einArtikel) throws ArtikelExistiertBereitsException {
            if (buchBestand.enthaelt(einBuch)) {
                throw new BuchExistiertBereitsException(einBuch, " - in 'einfuegen()'");
            }

            // das übernimmt die BuchListe:
            buchBestand.einfuegen(einBuch);
        }*/





    }
