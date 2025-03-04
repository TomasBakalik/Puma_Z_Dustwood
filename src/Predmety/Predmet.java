package Predmety;
import Postavy.Hrac;

public abstract class Predmet {
    protected String jmeno;
    protected String informace;

    public Predmet(String jmeno, String informace) {
        this.jmeno = jmeno;
        this.informace = informace;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getInformace() {
        return informace;
    }

    public abstract String pouzij(Hrac hrac);
}
