package Prikazy;

import Hlavni.Svet;

public class Mluv implements Prikaz{

    private String jmenoPostavy;

    @Override
    public String proved(Svet svet) {
        return "";
    }

    @Override
    public boolean konec() {
        return false;
    }
}
