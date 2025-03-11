package Postavy;

import Hlavni.Svet;
import Predmety.Brokovnice;

public class Hank extends Postava{


    public Hank() {
        super("Hank", "Potrebujes brokovnici ze?");
    }


    @Override
    public String interaguj(Svet svet) {
        return "Hank: Diky, ze jsi prisel, na vezmi si mou brokovnici.";
    }
}
