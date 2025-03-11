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
        } else if (!nazevPredmetu.equalsIgnoreCase("doutnik") && !nazevPredmetu.equalsIgnoreCase("klobouk")) {
            return "Tento predmet nelze pouzit. Muzes pouzit pouze doutnik nebo klobouk.";
        }

        String vysledek = predmet.pouzij(svet.getHrac());

        svet.getHrac().getInventar().odebratPredmet(nazevPredmetu);

        return vysledek;
    }

    @Override
    public boolean konec() {
        return false;
    }
}
