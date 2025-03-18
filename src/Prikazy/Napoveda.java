package Prikazy;

import Hlavni.Svet;

public class Napoveda implements Prikaz{
    @Override
    public String proved(Svet svet) {
        return "Dostupne prikazy: jdi[mistnost], pouzij[predmet], mluv[postava], strel, vezmi[predmet], poloz[predmet], inventar, nabit, poves, pomoc, stop,";
    }

    @Override
    public boolean konec() {
        return false;
    }
}
