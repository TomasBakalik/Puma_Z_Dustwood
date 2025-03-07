package Prikazy;

import Hlavni.Svet;
import Mista.Mistnost;
import Postavy.Postava;

public class Mluv implements Prikaz{

    private String jmenoPostavy;


    @Override
    public String proved(Svet svet) {
        for(Postava postava: svet.getAktualniMistnost().getPostavy()){
            if(postava.getJmeno().equals(jmenoPostavy)){
                postava.interaguj(svet);
                return "";
            }
        }
        return "Takova postava tu neni";
    }


    @Override
    public boolean konec() {
        return false;
    }
}
