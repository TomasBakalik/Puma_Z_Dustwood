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
     /*


    @Override
    public String proved(Svet svet) {
        Mistnost aktualniMistnost = svet.getAktualniMistnost();
        Predmet predmet = aktualniMistnost.ziskatPredmet(nazevPredmetu);

        if (predmet == null) {
            return "Tento predmet tady neni.";
        }

        // ✅ Kontrola: Pokud chce hráč vzít náboje, musí mít brokovnici i bavlnu!
        if (nazevPredmetu.equalsIgnoreCase("Naboje")) {
            if (!svet.getHrac().getInventar().obsahujePredmet("Brokovnice")) {
                return "Nemuzes vzit naboje, protoze nemas brokovnici!";
            }
            if (!svet.getHrac().getInventar().obsahujePredmet("Bavlna")) {
                return "Frank ti neda naboje zadarmo! Nejdrive mu dones bavlnu.";
            }

            // ✅ Pokud hráč má brokovnici i bavlnu, bavlna se odstraní
            svet.getHrac().getInventar().odebratPredmet("Bavlna");
            System.out.println("Frank si vzal bavlnu jako vymenu za naboje.");
        }

        if (svet.getHrac().getInventar().pridatPredmet(predmet)) {
            aktualniMistnost.odebratPredmet(nazevPredmetu);
            return "Vzal jsi " + nazevPredmetu + " do inventare";
        } else {
            return "Tvuj inventar je plny!";
        }


        Hrac hrac = svet.getHrac();
        Predmet predmet = svet.getAktualniMistnost().ziskatPredmet(nazevPredmetu);

        if(predmet != null){
            boolean pridano = hrac.getInventar().pridatPredmet(predmet);
            if(pridano){
                svet.getAktualniMistnost().odebratPredmet(nazevPredmetu);
                return "Vzal jsi " + nazevPredmetu + " do inventare";
            }else{
                return "Inventar je plny! Nemuzes vzit " + nazevPredmetu;
            }
        }else{
            return "Tento predmet tu neni.";
        }
    }
      */

    @Override
    public boolean konec() {
        return false;
    }
}
