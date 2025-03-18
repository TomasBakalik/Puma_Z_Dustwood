package Prikazy;

import Hlavni.Svet;

public class Pomoc implements Prikaz{
    @Override
    public String proved(Svet svet) {
        String mistnost = svet.getAktualniMistnost().getNazev().toLowerCase();
        boolean maBrokovnici = svet.getHrac().getInventar().obsahujePredmet("Brokovnice");
        boolean maNaboje = svet.getHrac().getInventar().obsahujePredmet("Naboje");
        boolean jeNabito = svet.getHrac().jeBrokovniceNabita();

        switch (mistnost) {
            case "zoo":
                return "Mozna bz jsi mel promulivit s Charliem, ktery vi neco o pume nebo si vezmi kloubouk a pouzij ho. Nic jineho tu nenajdes, musis jit dal do hospody.";
            case "hospoda":
                return "Zeptej se Johna napumu, mozna vi neco duleziteho, jakmile zjistis nove informace, vezmi si doutnik, pouzij ho a pokracuj ke starostovi domu.";
            case "starostuv dum":
                return "Pokud chces zabit pumu musis mit brokovnici. Zadej prikaz vezmi brokovnice, abys ji vzal. Jakmile vezmes brokovnici musis jit dal.";
            case "obchod":
                if (!maBrokovnici) {
                    return "Neziskal jsi brokovnici, bez ni jsou ti naboje k nicemu";
                }
                return "Frank ti muze dat naboje, ale pouze, pokud mu prineses bavlnu. Nejdrive musis jit do ohrady a zadat vezmi bavlna, pak se vrat a napis vezmi naboje.";
            case "souseduv dum":
                return "Clark vi, kde se puma nejcasteji objevuje, protoze ji peclive studoval. Promluv s nim prikazem mluv clark, mozna ti rekne neco uzitecneho.";
            case "ohrada":
                return "Tady muzes najit bavlnu. Pokud ji chces, napis vezmi bavlna. Pak ji dones Frankovi do obchodu a napis vezmi naboje.";
            case "strecha hospody":
                if (!maBrokovnici) {
                    return "Jsi na strese hospody, ale nemas brokovnici! Ted uz se nemuzes vratit, hra je prohrana.";
                } else if (!maNaboje) {
                    return "Jsi na strese hospody, ale nemas naboje! Ted uz se nemuzes vratit, hra je prohrana.";
                } else if (!jeNabito) {
                    return "Mas brokovnici i naboje, ale broka neni nabita! Zadej nabit a pak strel!";
                }
                return "Mas vse, co potrebujes! Zadej strel, abys zabil pumu a, pote zadej poves (pro poveseni kozichu pumy) a hra se ukonci.";
            default:
                return "Tady zadna specialni napoveda neni. Podivej se do napovedy prikazem napoveda.";
        }
    }

    @Override
    public boolean konec() {
        return false;
    }
}
