package Predmety;

import Postavy.Hrac;

public class KozichPumy extends Predmet{
    public KozichPumy() {
        super("Kozich pumy: ", "Trofej z porazene pumy");
    }

    @Override
    public String pouzij(Hrac hrac) {
        return "";
    }
}
