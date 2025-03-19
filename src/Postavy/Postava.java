package Postavy;

import Hlavni.Svet;

/**
 * Tato abstraktni trida postava predstavuje postavy ve hre.
 * Kazda postava ma sve jmeno a urcitou informaci, kterou sdeluje hraci.
 * Postavy maji take metodu interaguj, ktera definuje interakci s hracem.
 */
public abstract class Postava {
    protected String jmeno;
    protected String informace;

    public Postava(String jmeno, String informace) {
        this.jmeno = jmeno;
        this.informace = informace;
    }

    /**
     * Vrati jmeno postavy.
     * @return Jmeno postavy.
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Vrati informaci, kterou postava sdeluje.
     * @return Informace postavy.
     */
    public String getInformace() {
        return informace;
    }

    /**
     * Vrati pozdrav postavy.
     * @return Pozdrav obsahujici jmeno postavy a jeji informaci.
     */
    public String pozdravHrace(){
        return jmeno + ": " + informace;
    }

    /**
     * Abstraktni metoda pro interakci hrace s postavou.
     * Kazda postava ma vlastni implementaci teto metody.
     * @param svet Herni svet.
     * @return String obsahujici vysledek interakce s postavou.
     */
    public abstract String interaguj(Svet svet);
}
