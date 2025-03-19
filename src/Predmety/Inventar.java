package Predmety;

import java.util.ArrayList;

/**
 * Trida inventar reprezentuje inventar hrace.
 * Umoznuje pridavani, odebirani a spravu predmetu.
 */
public class Inventar {

    private int kapacita;
    private ArrayList<Predmet> predmety;

    public Inventar(int kapacita) {
        this.kapacita = kapacita;
        this.predmety = new ArrayList<>();
    }

    /**
     * Prida predmet do inventare, pokud neni plny nebo v inventari predmet jiz neni.
     * @param predmet Predmet, ktery se ma pridat.
     * @return true, pokud byl uspesne pridan, jinak false
     */
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

    /**
     * Odebere predmet z inventare, pokud v nem existuje.
     * @param nazev Nazev predmetu, ktery se ma odebrat.
     * @return true, pokud byl uspesne odebran, jinak false.
     */
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

    /**
     * Kontroluje, zda se v inventari nachazi predmet s danym nazvem.
     * @param nazev Nazev hledaneho predmetu.
     * @return true, pokud je predmet v inventari, jinak false.
     */
    public boolean obsahujePredmet(String nazev){
        for(Predmet predmet : predmety) {
            if(predmet.getJmeno().equalsIgnoreCase(nazev)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Vrati predmet s danym nazvem, pokud existuje v inventari.
     * @param nazev Nazev hledaneho predmetu.
     * @return Instance predmetu, pokud existuje.
     */
    public Predmet getPredmet(String nazev){
        for(Predmet predmet : predmety) {
            if(predmet.getJmeno().equalsIgnoreCase(nazev)) {
                return predmet;
            }
        }
        return null;
    }

    /**
     * Vypise obsah inventare do konzole.
     * Pokud je inventar prazdny, sdeli se informace o tom, ze je prazdny.
     */
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

    /**
     * Vraci seznam vsech predmetu v inventari.
     * @return Seznam predmetu v invntari.
     */
    public ArrayList<Predmet> getPredmety() {
        return predmety;
    }
}
