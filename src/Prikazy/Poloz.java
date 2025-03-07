package Prikazy;

import Hlavni.Svet;
import Postavy.Hrac;
import Predmety.Predmet;

public class Poloz implements Prikaz{

    private String nazevPredmetu;

    public Poloz(String nazevPredmetu) {
        this.nazevPredmetu = nazevPredmetu;
    }

    @Override
    public String proved(Svet svet) {
        Hrac hrac = svet.getHrac();
        Predmet predmet = hrac.getInventar().getPredmet(nazevPredmetu);

        if(predmet != null){
            hrac.getInventar().odebratPredmet(nazevPredmetu);
            svet.getAktualniMistnost().pridatPredmet(predmet);
            return "Polozil jsi " + nazevPredmetu + " na zem.";
        }else{
            return "Tento predmet nemas v inventari";
        }
    }

    @Override
    public boolean konec() {
        return false;
    }
}
