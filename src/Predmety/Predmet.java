package Predmety;
import Postavy.Hrac;

/**
 * Abstraktni tria predmet predstavuje zaklad pro vsechny predmety.
 * Kazdy predmet ma svuj nazev, popis a metodu pouzij, ktera definuje, co se stane pri pouziti predmetu.
 */
public abstract class Predmet {
    protected String jmeno;
    protected String informace;

    public Predmet(String jmeno, String informace) {
        this.jmeno = jmeno;
        this.informace = informace;
    }

    /**
     * Vrati nazev premetu.
     * @return Nazev predmetu.
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Vrati informace o predmetu.
     * @return Popis nebo informace predmetu.
     */
    public String getInformace() {
        return informace;
    }

    /**
     * Abstraktni metoda pro pouziti predmetu.
     * Kazdy predmet implementuje tuto metodu podle sebe a podle toho, co dela.
     * @param hrac Hrac, ktery predmet vyuziva.
     * @return String obsahujici vysledek pouziti predmetu.
     */
    public abstract String pouzij(Hrac hrac);
}
