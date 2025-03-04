package Predmety;

import java.util.ArrayList;

public class Inventar {

    private int kapacita;
    private ArrayList<Predmet> predmety;

    public Inventar(int kapacita) {
        this.kapacita = kapacita;
        this.predmety = new ArrayList<>();
    }

    public boolean pridatPredmet(Predmet predmet) {
        return true;
    }

    public boolean odebratPredmet(String nazev) {
        return true;
    }

    public boolean obsahujePredmet(String nazev){
        return true;
    }

    public ArrayList<Predmet> getPredmety() {
        return predmety;
    }
}
