package Predmety;

import java.util.ArrayList;

public class Inventar {

    private int kapacita;
    private ArrayList<Predmet> predmety;

    public Inventar(int kapacita) {
        this.kapacita = kapacita;
        this.predmety = new ArrayList<>();
    }

    public boolean pridatPredmet(Predmet predmet) {
        if(predmety.size() < kapacita && !predmety.contains(predmet)) {
            predmety.add(predmet);
            System.out.println(predmet.getJmeno() + " byl pridan do inventare");
            return true;
        }else{
            System.out.println("Inventar je plny! Nemuzes vzit " + predmet.getJmeno());
            return false;
        }
    }

    public boolean odebratPredmet(String nazev) {
        for(Predmet predmet : predmety) {
            if(predmet.getJmeno().equalsIgnoreCase(nazev)) {
                predmety.remove(predmet);
                System.out.println(predmet.getJmeno() + " byl odstranen z inventare");
                return true;
            }
        }
        System.out.println("Nemas tento predmet v inventari. ");
        return false;
    }

    public boolean obsahujePredmet(String nazev){
        for(Predmet predmet : predmety) {
            if(predmet.getJmeno().equalsIgnoreCase(nazev)) {
                return true;
            }
        }
        return false;
    }

    public Predmet getPredmet(String nazev){
        for(Predmet predmet : predmety) {
            if(predmet.getJmeno().equalsIgnoreCase(nazev)) {
                return predmet;
            }
        }
        return null;
    }

    public void zobrazInventar(){
        if(predmety.isEmpty()) {
            System.out.println("Inventar je prazdny.");
        }else{
            System.out.println("Tvuj inventar obsahuje: ");
            for(Predmet predmet : predmety) {
                System.out.println("-- " + predmet.getJmeno());
            }
        }
    }

    public ArrayList<Predmet> getPredmety() {
        return predmety;
    }
}
