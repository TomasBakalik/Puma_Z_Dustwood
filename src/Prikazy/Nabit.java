package Prikazy;

import Hlavni.Svet;
import Postavy.Hrac;

public class Nabit implements Prikaz{
    @Override
    public String proved(Svet svet) {
        Hrac hrac = svet.getHrac();

        if(!hrac.getInventar().obsahujePredmet("Brokovnice")){
            return "Nemas brokovnici. Neni co nabijet.";
        } else if (!hrac.getInventar().obsahujePredmet("Naboje")) {
            return "Nemas naboje!";
        } else if (hrac.jeBrokovniceNabita()) {
            return "Brokovnice je nabita";
        }

        hrac.nabitBrokovnici();

        hrac.getInventar().odebratPredmet("Naboje");

        return "Nabil jsi brokovnici";
    }

    @Override
    public boolean konec() {
        return false;
    }
}
