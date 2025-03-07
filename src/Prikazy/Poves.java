package Prikazy;

import Hlavni.Svet;
import Postavy.Hrac;

public class Poves implements Prikaz{
    @Override
    public String proved(Svet svet) {
        Hrac hrac = svet.getHrac();
        if(svet.getAktualniMistnost().getNazev().equalsIgnoreCase("hospoda") && hrac.getInventar().obsahujePredmet("Kozich pumy")){
            return "Povesil jsi kozich pumy na dvere hospody. Vitezstvi!";
        }else{
            return "Tady nemuzes povesit kozich pumy!";
        }
    }

    @Override
    public boolean konec() {
        return false;
    }
}
