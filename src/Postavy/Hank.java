package Postavy;

import Hlavni.Svet;
import Predmety.Brokovnice;

public class Hank extends Postava{

    private boolean dalBrokovnici = false;

    public Hank() {
        super("Hank: ", "Potrebujes brokovnici ze?");
    }


    @Override
    public void interaguj(Svet svet) {
        if(!dalBrokovnici){
            svet.getHrac().getInventar().pridatPredmet(new Brokovnice());
            dalBrokovnici = true;
            System.out.println("Hank: Tady mas brokovnici. Ted si musis zajit do obchodu pro naboje.");
        }else{
            System.out.println("Hank: Brokovnici uz jsem ti predal. Hodne stesti.");
        }
    }
}
