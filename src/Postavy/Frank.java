package Postavy;

import Hlavni.Svet;
import Predmety.Naboje;

public class Frank extends Postava{
    public Frank() {
        super("Frank", ": Vitej v obchode! Chces naboje? Prines mi bavlnu");
    }

    @Override
    public void interaguj(Svet svet) {
        if(svet.getHrac().getInventar().obsahujePredmet("Bavlna")){
            svet.getHrac().getInventar().odebratPredmet("Bavlna");
            svet.getHrac().getInventar().pridatPredmet(new Naboje());
            System.out.println("Frank: Diky za bavlnu! Tady mas naboje.");
        }else{
            System.out.println("Frank: Bez bavlny ti nic nedam.");
        }
    }
}
