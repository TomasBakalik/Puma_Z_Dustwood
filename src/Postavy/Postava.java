package Postavy;

import Hlavni.Svet;
public abstract class Postava {
    protected String jmeno;
    protected String informace;

    public Postava(String jmeno, String informace) {
        this.jmeno = jmeno;
        this.informace = informace;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getInformace() {
        return informace;
    }

    public String pozdravHrace(){
        return jmeno + ": " + informace;
    }

    public abstract void interaguj(Svet svet);
}
