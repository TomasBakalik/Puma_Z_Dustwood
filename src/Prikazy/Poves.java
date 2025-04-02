package Prikazy;

import Hlavni.Svet;
import Postavy.Hrac;

public class Poves implements Prikaz{
    private boolean vyhra = false;

    @Override
    public String proved(Svet svet) {
        Hrac hrac = svet.getHrac();
        if (svet.getAktualniMistnost().getNazev().equalsIgnoreCase("strecha hospody") && hrac.getInventar().obsahujePredmet("Kozich pumy")) {
            vyhra = true;
            return "Povesil jsi kozich pumy na dvere hospody. Vitezstvi!";
        } else {
            System.out.println("Nemuzes jentak povesit kozich pumy, prvne ho musis ziskat.");
            vyhra = false;
            return "";
        }
    }

    @Override
    public boolean konec() {
        return vyhra;
    }
}
