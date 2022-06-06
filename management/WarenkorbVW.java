package management;

import java.util.ArrayList;

import dataObjects.Kunde;

public class WarenkorbVW {

    // Attritube
    private ArrayList<Warenkorb> warenkoerbe;

    public WarenkorbVW() {
        warenkoerbe = new ArrayList<Warenkorb>();
    }

    // Getter und Setter
    public ArrayList<Warenkorb> getWarenkoerbe() {
        return this.warenkoerbe;
    }

    public void setWarenkoerbe(ArrayList<Warenkorb> warenkoerbe) {
        this.warenkoerbe = warenkoerbe;
    }

    public void warenkorbHinzufuegen(Kunde kunde) {
        warenkoerbe.add(new Warenkorb(kunde));
    }

    // Generiert den Warenkorb zum eingeloggten Kunden
    public Warenkorb getWarenkorbForKunde(Kunde kunde) {
        for (Warenkorb warenkorb : this.warenkoerbe) {
            if (warenkorb.getKunde().getId() == kunde.getId()) {
                return warenkorb;
            }
        }
        return null;
    }

}