package Prikazy;

import Hlavni.Svet;
import Predmety.Predmet;

import java.util.ArrayList;

public class ZobrazitInventar implements Prikaz{


    @Override
    public String proved(Svet svet) {
        ArrayList<Predmet> predmety = svet.getHrac().getInventar().getPredmety();

        if(predmety.isEmpty()){
            return "Tvuj inventar je prazdny";
        }

        ArrayList<String> seznamPredmetu = new ArrayList<>();
        for(Predmet predmet : predmety){
            seznamPredmetu.add(predmet.getJmeno());
        }
        return "Tvuj inventar obsahuje:\n" + seznamPredmetu.toString();
    }

    @Override
    public boolean konec() {
        return false;
    }
}
