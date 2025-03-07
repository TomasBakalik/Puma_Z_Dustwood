package Predmety;

import Postavy.Hrac;

public class Doutnik extends Predmet{
    public Doutnik() {
        super("Doutnik", ": Stary dobry doutnik. Proste klasika, ktera na divokem zapade nesmi chybet");
    }

    @Override
    public String pouzij(Hrac hrac) {
        return "Zapalil jsi si doutnik. To je ale skvela atmosfera.";
    }
}
