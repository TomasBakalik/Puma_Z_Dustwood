package Prikazy;

import Hlavni.Svet;
import Mista.Mistnost;
import Postavy.Postava;

public class Mluv implements Prikaz{

    private String jmenoPostavy;


    @Override
    public String proved(Svet svet) {
        return null;
    }


    @Override
    public boolean konec() {
        return false;
    }
}
