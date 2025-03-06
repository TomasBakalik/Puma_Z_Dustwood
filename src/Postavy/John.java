package Postavy;

import Hlavni.Svet;

public class John extends Postava{
    public John() {
        super("John: ", "Vitej v hospode. Puma zabiji lidi i dobytek, mel by jsi si obstarat zbran.");
    }

    @Override
    public void interaguj(Svet svet) {
        System.out.println("John: Brokovnici ti muze dat jedine starosta, navstiv jeho dum, tam ji ziskas.");
    }
}
