package Prikazy;

import Hlavni.Svet;

public class Poloz implements Prikaz{

    private String nazevPredmetu;

    @Override
    public String proved(Svet svet) {
        return "";
    }

    @Override
    public boolean konec() {
        return false;
    }
}
