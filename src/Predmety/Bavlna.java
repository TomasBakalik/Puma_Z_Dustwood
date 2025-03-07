package Predmety;

import Postavy.Hrac;

public class Bavlna extends Predmet {
    public Bavlna() {
        super("Bavlna", ": Muzes ji vymenit za naboje u Franka v obchode");
    }

    @Override
    public String pouzij(Hrac hrac) {
        return "Bavlna sama o sobe k nicemu neni, dej ji v obchode Frankovi a on ti za ni da naboje";
    }
}
