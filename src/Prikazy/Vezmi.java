package Prikazy;

import Hlavni.Svet;
import Postavy.Hrac;
import Predmety.Predmet;

public class Vezmi implements Prikaz{

    private String nazevPredmetu;

    public Vezmi(String nazevPredmetu) {
        this.nazevPredmetu = nazevPredmetu;
    }

    @Override
    public String proved(Svet svet) {
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

    @Override
    public boolean konec() {
        return false;
    }
}
