package Prikazy;

import Hlavni.Svet;
import Postavy.Hrac;

public class Strel implements Prikaz{
    @Override
    public String proved(Svet svet) {
        Hrac hrac = svet.getHrac();
        if(svet.getAktualniMistnost().getNazev().equalsIgnoreCase("strecha hospody") && hrac.getInventar().obsahujePredmet("Brokovnice") && hrac.jeBrokovniceNabita()){
            svet.getAktualniMistnost().odebratPostavu("Nightmare");
            hrac.getInventar().odebratPredmet("Brokovnice");
            hrac.getInventar().pridatPredmet(new Predmety.KozichPumy());

            return "Zastrelil jsi pumu! Nyni muzes povesit jeji kozich na dvere hospody.";

        }else{
            return "Nemas potrebne vybaveni (nabita brokovnice) nebo nejsi na spravnem miste.";
        }
    }

    @Override
    public boolean konec() {
        return false;
    }
}
