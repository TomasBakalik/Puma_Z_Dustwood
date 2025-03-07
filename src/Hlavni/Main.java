package Hlavni;

import Mista.Mistnost;
import Mista.Obchod;

public class Main {
    public static void main(String[] args) {

        Svet svet = new Svet("mapa.csv");
        Konzole konzole = new Konzole(svet);
        konzole.start();

        Mistnost obchod = svet.getAktualniMistnost();
        System.out.println(obchod.getPredmety());

    }
}