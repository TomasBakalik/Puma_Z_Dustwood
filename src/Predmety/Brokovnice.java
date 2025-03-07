package Predmety;

import Postavy.Hrac;

public class Brokovnice extends Predmet{


    public Brokovnice() {
        super("Brokovnice: ", "Pomuze ti porazit pumu");
    }

    @Override
    public String pouzij(Hrac hrac) {
        if(hrac.getInventar().obsahujePredmet("Naboje")){
            return "Brokovnice je nabita, jsi pripraven strilet";
        }else{
            return "Nemas naboje, brokovnice je k nicemu";
        }
    }
}
