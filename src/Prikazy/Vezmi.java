package Prikazy;

import Hlavni.Svet;
import Mista.Mistnost;
import Postavy.Hrac;
import Predmety.Predmet;

public class Vezmi implements Prikaz{

    private String nazevPredmetu;

    public Vezmi(String nazevPredmetu) {
        this.nazevPredmetu = nazevPredmetu;
    }

    @Override
    public String proved(Svet svet) {
        Mistnost aktualniMistnost = svet.getAktualniMistnost();
        Predmet predmet = aktualniMistnost.ziskatPredmet(nazevPredmetu);

        if(predmet == null){
            return "Tento predet tu neni";
        }

        if(nazevPredmetu.equalsIgnoreCase("Naboje")){
            if(!svet.getHrac().getInventar().obsahujePredmet("Brokovnice")){
                return "Nemuzes vzit naboje, protoze nemas brokovnici.";
            } else if (!svet.getHrac().getInventar().obsahujePredmet("Bavlna")) {
                return "Frank ti neda naboje zadarmo, nejdrive mu dones bavlnu.";
            }else{
                svet.getHrac().getInventar().odebratPredmet("Bavlna");
                System.out.println("Frank si vzal bavlnu vymenou za naboje.");
            }
        }

        if(svet.getHrac().getInventar().pridatPredmet(predmet)){
            aktualniMistnost.odebratPredmet(nazevPredmetu);
            return "Vzal jsi " + nazevPredmetu + " do inventare";
        }else{
            return "Tvuj inventar je plny";
        }
    }

    @Override
    public boolean konec() {
        return false;
    }
}
