package Postavy;

import Hlavni.Svet;

public class Charlie extends Postava{
    public Charlie() {
        super("Charlie", "Nejvetsi puma ze zoo utekla, mej se na pozoru.");
    }

    @Override
    public String interaguj(Svet svet) {
        return "Charlie: Puma je doopravdy velka a hodne rychla. Slysel jsem, ze se casto objevuje na namesti, ale moc informaci o tom nevim. Jdi do hospody za Johnem, ten ti povi vice.";
    }
}
