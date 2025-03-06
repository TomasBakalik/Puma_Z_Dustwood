package Postavy;

import Hlavni.Svet;

public class Clark extends Postava{
    public Clark() {
        super("Clark: ", "Vcera v noci jsem pumu videl");
    }

    @Override
    public void interaguj(Svet svet) {
        System.out.println("Clark: Kazdou noc se vraci na namesti. Mel by jsi se se svou zbrani dostat na strechu hospody a odtamud ukoncit radeni te bestie.");
    }
}
