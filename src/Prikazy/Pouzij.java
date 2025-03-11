package Prikazy;

import Hlavni.Svet;
import Predmety.Predmet;

public class Pouzij implements Prikaz{

    private String nazevPredmetu;

    public Pouzij(String nazevPredmetu) {
        this.nazevPredmetu = nazevPredmetu;
    }

    @Override
    public String proved(Svet svet) {
        Predmet predmet = svet.getHrac().getInventar().getPredmet(nazevPredmetu);
        if(predmet == null){
            return "Tento predmet nemas v inventari.";
        }

        return predmet.pouzij(svet.getHrac());
    }

    @Override
    public boolean konec() {
        return false;
    }
}
