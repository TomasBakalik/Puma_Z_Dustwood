package Mista;

import Postavy.Postava;
import Predmety.Predmet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Abstraktni trida mistnost predstavuje jednotliva mista ve hre.
 * Kazda mistnost ma svuj nazev, popis, seznam moznych vychodu, seznam postav a seznam predmetu
 */
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

    /**
     * Nastavi vychod z nynejsi mistnosti do jine mistnosti.
     * @param nazev Nazev vychodu
     * @param mistnost Mistnost, do ktere vychod vede
     */
    public void nastavitVychod(String nazev, Mistnost mistnost){
        vychody.put(nazev.toLowerCase(), mistnost);
    }

    /**
     * Vrati mistnost, do ktere dany vychod vede.
     * @param nazev Nazev vychodu
     * @return Mistnost, pokud existuje dany vychod
     */
    public Mistnost ziskatVychod(String nazev){
        return vychody.get(nazev.toLowerCase());
    }

    /**
     * Vrati nazev mistnosti.
     * @return Nazev mistnosti.
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Vrati popis mistnosti.
     * @return Popis mistnosti.
     */
    public String getPopis() {
        return popis;
    }

    /**
     * Vrati seznam postav, ktere se nachazeji v mistnosti.
     * @return Seznam postav.
     */
    public ArrayList<Postava> getPostavy() {
        return postavy;
    }

    /**
     * Vrati seznam predmetu, ktere se nachazeji v mistnosti.
     * @return Seznam predmetu.
     */
    public ArrayList<Predmet> getPredmety() {
        return predmety;
    }

    /**
     * Prida postavu domistnosti, pokud tam jiz neni.
     * @param postava Postava, ktera se ma pridat.
     */
    public void pridatPostavu(Postava postava){
        if(!postavy.contains(postava)){
            postavy.add(postava);
        }
    }

    /**
     * Odebere postavu z mistnosti podle jmena.
     * @param jmeno Jmeno postavy, ktera se ma odebrat.
     */
    public void odebratPostavu(String jmeno){
        Iterator<Postava> iterator = postavy.iterator();
        while(iterator.hasNext()){
            Postava postava = iterator.next();
            if(postava.getJmeno().equalsIgnoreCase(jmeno)){
                iterator.remove();
                System.out.println("Postava " + jmeno + " byla odstranena.");
                return;
            }
        }
    }

    /**
     * Prida predmet do mistnosti, pokud tam jiz neni.
     * @param predmet Predmet, ktery se ma pridat.
     */
    public void pridatPredmet(Predmet predmet){
        if(!predmety.contains(predmet)){
            predmety.add(predmet);
        }
    }

    /**
     * Vrati predmet z mistnosti podle nazvu.
     * @param nazev Nazev hledaneho predmetu.
     * @return Predmet, pokud existuje
     */
    public Predmet ziskatPredmet(String nazev){
        for(Predmet predmet : predmety){
            if(predmet.getJmeno().equalsIgnoreCase(nazev)){
                return predmet;
            }
        }
        return null;
    }


    /**
     * Odebere predmet z mistnosti podle nazvu.
     * @param nazev Nazev predmetu, ktery se ma odstranit.
     */
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
