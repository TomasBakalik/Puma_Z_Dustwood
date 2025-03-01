package Predmety;

import Postavy.Hrac;

public class Brokovnice extends Predmet{


    public Brokovnice() {
        super("Brokovnice: ", "Pomuze ti porazit pumu");
    }

    @Override
    public String pouzij(Hrac hrac) {
        return "";
    }
}
