package Postavy;

import Predmety.Inventar;
import Hlavni.Svet;

public class Hrac extends Postava{

    private Inventar inventar;

    public Hrac(String jmeno){
        super(jmeno, "Jsem pripraven zastavit pumu");
        this.inventar = new Inventar(4);
    }

    public Inventar getInventar() {
        return inventar;
    }

    @Override
    public String interaguj(Svet svet){
        return "";
    }


}
