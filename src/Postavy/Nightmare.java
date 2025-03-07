package Postavy;

import Hlavni.Svet;
import Predmety.Predmet;

public class Nightmare extends Postava{

    public Nightmare() {
        super("Nightmare", ": Vrci a chysta se zautocit.");
    }

    @Override
    public void interaguj(Svet svet) {
        if(svet.getHrac().getInventar().obsahujePredmet("Brokovnice") && svet.getHrac().getInventar().obsahujePredmet("Naboje")){
            System.out.println("Nigtmare: Puma byla zastrelena! Nyni poves jeji kozich na dvere hospody.");
            svet.getHrac().getInventar().odebratPredmet("Brokovnice");
            svet.getHrac().getInventar().odebratPredmet("Naboje");
            svet.getHrac().getInventar().pridatPredmet(new Predmety.KozichPumy());
        }else{
            System.out.println("Nightmare: Puma te roztrhala! Konec hry.");
            System.exit(0);
        }

    }
}
