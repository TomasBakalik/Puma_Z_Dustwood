package Prikazy;

import Hlavni.Svet;

public class Napoveda implements Prikaz{
    @Override
    public String proved(Svet svet) {
        return "Dostupne prikazy: jdi, mluv, strel, vezmi, poloz, poves, pomoc, stop,";
    }

    @Override
    public boolean konec() {
        return false;
    }
}
