package Prikazy;

import Hlavni.Svet;

public class Pomoc implements Prikaz{
    @Override
    public String proved(Svet svet) {
        return "Pouzij prikazy jako: jdi[mistnost], mluv[postava], vezmi[predmet], poloz[predmet]";
    }

    @Override
    public boolean konec() {
        return false;
    }
}
