public class Nutzer {
    private String name;
    private int eindeutNummer;



    public Nutzer(String name, int nummer){
        this.name = name;
        this.eindeutNummer = nummer;
    }



    public void setEindeutNummer(int eindeutNummer) {
        this.eindeutNummer = eindeutNummer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEindeutNummer() {
        return eindeutNummer;
    }

    public String getName() {
        return name;
    }
}
