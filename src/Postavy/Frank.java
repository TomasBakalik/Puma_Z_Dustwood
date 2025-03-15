package Postavy;

import Hlavni.Svet;
import Predmety.Naboje;

public class Frank extends Postava{
    public Frank() {
        super("Frank", "Vitej v obchode! Chces naboje? Prines mi bavlnu");
    }

    @Override
    public String interaguj(Svet svet) {
        if (svet.getHrac().getInventar().obsahujePredmet("Bavlna")) {
            return "Frank: Vidim, ze mas v inventari bavlnu. Muzes vzit me naboje.";
        } else {
            return "Frank: Bez bavlny ti nic nedam.";
        }
    }
}
