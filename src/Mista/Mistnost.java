package Mista;

import Postavy.Postava;
import Predmety.Predmet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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

    public void pridatPostavu(Postava postava){
        if(!postavy.contains(postava)){
            postavy.add(postava);
        }
    }

    public void odebratPostavu(String jmeno){
        for(Postava postava : postavy){
            if(postava.getJmeno().equalsIgnoreCase(jmeno)){
                postavy.remove(postava);
                System.out.println("Postava " + jmeno + " byla odstranena.");
            }
        }
    }


    public void pridatPredmet(Predmet predmet){
        if(!predmety.contains(predmet)){
            predmety.add(predmet);
        }
    }

    public Predmet ziskatPredmet(String nazev){
        for(Predmet predmet : predmety){
            if(predmet.getJmeno().equalsIgnoreCase(nazev)){
                return predmet;
            }
        }
        return null;
    }


    public void odebratPredmet(String nazev){
        Iterator<Predmet> iterator = predmety.iterator();

        while(iterator.hasNext()){
            Predmet predmet = iterator.next();
            if(predmet.getJmeno().equalsIgnoreCase(nazev)){
                iterator.remove();
                return;
            }
        }
    }
}
