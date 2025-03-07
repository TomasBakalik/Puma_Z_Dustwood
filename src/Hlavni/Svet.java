
package Hlavni;


import Mista.FactoryMistnost;
import Mista.Mistnost;
import Postavy.*;
import Predmety.Bavlna;
import Predmety.Brokovnice;
import Predmety.Naboje;
import Predmety.Predmet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Svet {

    private HashMap<String, Mistnost> mistnosti = new HashMap<>();
    private Mistnost aktualniMistnost;
    private Hrac hrac;

    public Svet(String soubor){
        this.hrac = new Hrac("Imannuel");
        nacistSvetZeSouboru(soubor);
        inicializovatPostavy();
        inicializovatPredmety();

        if(mistnosti.containsKey("namesti")){
            aktualniMistnost = mistnosti.get("namesti");
        }else{
            System.out.println("Chyba, mistnost namesti pro start hry nebyla nalezena v souboru");
        }
    }

    public void nacistSvetZeSouboru(String soubor){
        try(BufferedReader br = new BufferedReader(new FileReader(soubor))){
            ArrayList<String[]> data = new ArrayList<>();
            String radek = "";

            while((radek = br.readLine()) != null){
                data.add(radek.split(";"));
            }

            for(String[] vstup : data){
                mistnosti.put(vstup[0].toLowerCase(), FactoryMistnost.vytvorMistnost(vstup[0]));
            }

            for(String[] vstup: data){
                Mistnost mistnost = mistnosti.get(vstup[0].toLowerCase());
                for(int i = 1; i < vstup.length; i++){
                    if(!vstup[i].isEmpty()){
                        Mistnost soused = mistnosti.get(vstup[i].toLowerCase());
                        if(soused != null){
                            mistnost.nastavitVychod(vstup[i].toLowerCase(), soused);
                        }else{
                            System.out.println("Chyba: Mista.Mistnost " + vstup[i] + " nebyla nalezena");
                        }
                    }
                }
            }

        }catch (IOException e){
            System.out.println("Chyba pri nacitani souboru: " + e.getMessage());
        }
    }

    public Mistnost getAktualniMistnost(){
        return aktualniMistnost;
    }

    public void setAktualniMistnost(Mistnost aktualniMistnost){
        this.aktualniMistnost = aktualniMistnost;
    }

    public Hrac getHrac() {
        return hrac;
    }


    public void pridatPostavuDoMistnosti(String nazevMistnosti, Postava postava){
        if(mistnosti.containsKey(nazevMistnosti)){
            mistnosti.get(nazevMistnosti).pridatPostavu(postava);
        }else{
            System.out.println("Chyba: Mistnost " + nazevMistnosti + " neexistuje, postava " + postava.getJmeno() + " nebyla pridana");
        }
    }


    public void pridatPredmetDoMistnosti(String nazevMistnosti, Predmet predmet){
        if(mistnosti.containsKey(nazevMistnosti)){
            mistnosti.get(nazevMistnosti).pridatPredmet(predmet);
        }else{
            System.out.println("Chyba: Mistnost " + nazevMistnosti + " neexistuje, premet " + predmet.getJmeno() + " nebyl pridan");
        }
    }


    public void inicializovatPostavy(){
        pridatPostavuDoMistnosti("zoo", new Charlie());
        pridatPostavuDoMistnosti("hospoda", new John());
        pridatPostavuDoMistnosti("starostuv dum", new Hank());
        pridatPostavuDoMistnosti("obchod", new Frank());
        pridatPostavuDoMistnosti("souseduv dum", new Clark());
        pridatPostavuDoMistnosti("strecha hospody", new Nightmare());
    }

    public void inicializovatPredmety(){
        pridatPredmetDoMistnosti("starostuv dum", new Brokovnice());
        pridatPredmetDoMistnosti("obchod", new Naboje());
        pridatPredmetDoMistnosti("ohrada", new Bavlna());
    }

    public void vypisObsahMistnosti() {
        for (String nazev : mistnosti.keySet()) {
            Mistnost mistnost = mistnosti.get(nazev);
            System.out.println("Mistnost: " + mistnost.getNazev());
            System.out.println("  Predmety: ");
            for (Predmet predmet : mistnost.getPredmety()) {
                System.out.println("   - " + predmet.getJmeno());
            }
            System.out.println("  Postavy: ");
            for (Postava postava : mistnost.getPostavy()) {
                System.out.println("   - " + postava.getJmeno());
            }
            System.out.println();
        }
    }
}
