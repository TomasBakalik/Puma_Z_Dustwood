package Prikazy;

import Hlavni.Svet;

public class Napoveda implements Prikaz{
    @Override
    public String proved(Svet svet) {
        return "";
    }

    @Override
    public boolean konec() {
        return false;
    }
}
