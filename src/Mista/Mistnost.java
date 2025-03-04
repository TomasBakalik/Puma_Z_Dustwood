package Mista;

import Postavy.Postava;
import Predmety.Predmet;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Mistnost {

    protected String nazev;
    protected String popis;
    protected HashMap<String, Mistnost> vychody;
    protected ArrayList<Postava> postavy;
    protected ArrayList<Predmet> predmety;

    public Mistnost(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        this.vychody = new HashMap<>();
        this.postavy = new ArrayList<>();
        this.predmety = new ArrayList<>();
    }

    public void nastavitVychod(String nazev, Mistnost mistnost){
        vychody.put(nazev.toLowerCase(), mistnost);
    }

    public Mistnost ziskatVychod(String nazev){
        return vychody.get(nazev.toLowerCase());
    }

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }

    public ArrayList<Postava> getPostavy() {
        return postavy;
    }

    public ArrayList<Predmet> getPredmety() {
        return predmety;
    }

    public void pridatPostavu(){

    }

    public void odebratPostavu(){

    }

    public void pridatPredmet(){

    }

    public void odebratPredmet(){

    }
}
