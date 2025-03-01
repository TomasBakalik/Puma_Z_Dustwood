package Prikazy;

import Hlavni.Svet;

public class Pomoc implements Prikaz{
    @Override
    public String proved(Svet svet) {
        return "";
    }

    @Override
    public boolean konec() {
        return false;
    }
}
