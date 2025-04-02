package Postavy;

import Hlavni.Svet;
import Predmety.Predmet;

public class Nightmare extends Postava{

    public Nightmare() {
        super("Nightmare", "Vrci a chysta se zautocit.");
    }

    @Override
    public String interaguj(Svet svet) {
        if(svet.getHrac().getInventar().obsahujePredmet("Brokovnice") && svet.getHrac().jeBrokovniceNabita()){
            svet.getHrac().getInventar().odebratPredmet("Brokovnice");
            svet.getHrac().getInventar().pridatPredmet(new Predmety.KozichPumy());
            return "Nigtmare: Puma byla zastrelena! Nyni poves jeji kozich na dvere hospody.";
        }else{
            System.out.println("Nightmare: Vrci a chysta se zautocit.");
            System.out.println("Nightmare: Puma te roztrhala! Konec hry. Nemel jsi potrebne vybaveni na to pumu zastavit.");
            System.exit(0);
            return "";
        }

    }
}
