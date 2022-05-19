package management;

public class ShopVW {

    // Attribute
    private ArtikelVW meineArtikel;
    private KundenVW meineKunden;
    private MitarbeiterVW meineMitarbeiter;
    private WarenkorbVW meineWarenkörbe;

    public ShopVW() {
        meineArtikel = new ArtikelVW();
        meineKunden = new KundenVW();
        meineMitarbeiter = new MitarbeiterVW();
        meineWarenkörbe = new WarenkorbVW();
    }

    public ArtikelVW getMeineArtikel() {
        return this.meineArtikel;
    }

    public void setMeineArtikel(ArtikelVW meineArtikel) {
        this.meineArtikel = meineArtikel;
    }

    public KundenVW getMeineKunden() {
        return this.meineKunden;
    }

    public void setMeineKunden(KundenVW meineKunden) {
        this.meineKunden = meineKunden;
    }

    public MitarbeiterVW getMeineMitarbeiter() {
        return this.meineMitarbeiter;
    }

    public void setMeineMitarbeiter(MitarbeiterVW meineMitarbeiter) {
        this.meineMitarbeiter = meineMitarbeiter;
    }

    public WarenkorbVW getMeineWarenkörbe() {
        return this.meineWarenkörbe;
    }

    public void setMeineWarenkörbe(WarenkorbVW meineWarenkörbe) {
        this.meineWarenkörbe = meineWarenkörbe;
    }

}
