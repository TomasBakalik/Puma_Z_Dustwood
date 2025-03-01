package Postavy;

import Hlavni.Svet;

public class Hank extends Postava{

    private boolean dalBrokovnici = false;

    public Hank() {
        super("Hank: ", "Potrebujes brokovnici ze?");
    }


    @Override
    public void interaguj(Svet svet) {

    }
}
