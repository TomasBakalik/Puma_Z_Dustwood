package Postavy;

import Predmety.Inventar;
import Hlavni.Svet;

public class Hrac extends Postava{

    private Inventar inventar;
    private boolean brokovniceNabita;

    public Hrac(String jmeno){
        super(jmeno, "Jsem pripraven zastavit pumu");
        this.inventar = new Inventar(4);
        this.brokovniceNabita = false;
    }

    public Inventar getInventar() {
        return inventar;
    }

    @Override
    public String interaguj(Svet svet){
        return "";
    }

    public boolean jeBrokovniceNabita(){
        return brokovniceNabita;
    }

    public void nabitBrokovnici(){
        this.brokovniceNabita = true;
    }

    public void vystrelil(){
        this.brokovniceNabita = false;
    }


}
