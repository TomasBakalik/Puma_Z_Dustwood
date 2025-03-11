package Prikazy;

import Hlavni.Svet;
import Mista.Mistnost;
import Postavy.Postava;

public class Mluv implements Prikaz{

    private String jmenoPostavy;

    public Mluv(String jmenoPostavy) {
        this.jmenoPostavy = jmenoPostavy;
    }


    @Override
    public String proved(Svet svet) {
        for(Postava postava: svet.getAktualniMistnost().getPostavy()){
            if(postava.getJmeno().trim().equalsIgnoreCase(jmenoPostavy.trim())){
                return postava.pozdravHrace() + "\n" + postava.interaguj(svet);
            }
        }
        return "Takova postava tu neni";
    }



    @Override
    public boolean konec() {
        return false;
    }
}
