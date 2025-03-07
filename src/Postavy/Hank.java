package Postavy;

import Hlavni.Svet;
import Predmety.Brokovnice;

public class Hank extends Postava{


    public Hank() {
        super("Hank", ": Potrebujes brokovnici ze?");
    }


    @Override
    public void interaguj(Svet svet) {
        System.out.println("Hank: Diky, ze jsi prisel, na vezmi si mou brokovnici.");
    }
}
