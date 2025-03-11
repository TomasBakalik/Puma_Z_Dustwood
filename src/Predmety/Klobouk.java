package Predmety;

import Postavy.Hrac;

public class Klobouk extends Predmet{
    public Klobouk() {
        super("Klobouk", ": Tvuj verny kovbojsky klobouk");
    }

    @Override
    public String pouzij(Hrac hrac) {
        return "Nasadil jsi si klobouk. Ted jsi jako opravdovy kovboj.";
    }
}
