package Prikazy;

import Hlavni.Svet;
import Postavy.Hrac;

public class Poves implements Prikaz{
    @Override
    public String proved(Svet svet) {
        Hrac hrac = svet.getHrac();
        if(svet.getAktualniMistnost().getNazev().equalsIgnoreCase("strecha hospody") && hrac.getInventar().obsahujePredmet("Kozich pumy")){
            return "Povesil jsi kozich pumy na dvere hospody. Vitezstvi!";
        }else{
            return "Nemas nabitou brokovnici! Puma te roztrhala, konec hry." ;
        }
    }

    @Override
    public boolean konec() {
        return true;
    }
}
