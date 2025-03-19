package Hlavni;

import Predmety.Inventar;
import Prikazy.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Trida konzole se stara o interakci mezi hracem a hrou.
 * Jsou zde metody pro nacteni uvodniho textu (o cem hra je), nastavuji se zde prikazy,
 * zpracovavaji se zde vstypy hrace a spusteni hlavni herni smycky.
 */

public class Konzole {

    private boolean konecHry = false;
    private HashMap<String, Prikaz> mapa = new HashMap<>();
    private Svet svet;
    private Scanner scanner = new Scanner(System.in);

    public Konzole(Svet svet){
        this.svet = svet;
    }

    /**
     * Nacte uvodni text hry ze souboru a vypise jej hraci do konzole.
     * Kdyz se soubor nepodari nacist vypise se chyba.
     * @param soubor Nazev souboru, ve kterem je zapsany uvodni text.
     */
    public void zobrazitUvodniText(String soubor){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(soubor))){
            String radek = "";
            while((radek = bufferedReader.readLine()) != null){
                System.out.println(radek);
            }
        }catch(IOException e){
            System.out.println("Nepodarilo se nacist uvodni text ze souboru.");
        }
    }

    /**
     * Inicializuje dostupne prikazy ve hre a prida je do mapy.
     * Diky tomu mohou byt prikazy efektivne vyzivany a spravovany.
     */
    public void inicializace(){
        mapa.put("stop", new Stop());
        mapa.put("napoveda", new Napoveda());
        mapa.put("pomoc", new Pomoc());
        mapa.put("inventar", new ZobrazitInventar());
        mapa.put("nabit", new Nabit());
    }

    /**
     * Ceka na vstup hrace a vykonava zadany prikaz.
     * Kdyz je prikaz neznamy vypise se chybova zprava.
     */
    public void provedPrikaz(){
        System.out.println(">> ");
        String prikaz2 = scanner.nextLine().toLowerCase().trim();

        if(prikaz2.startsWith("jdi")){
            String smer = prikaz2.substring(4);
            Prikaz jdi = new Jdi(smer);
            System.out.println(">> " + jdi.proved(svet));
            if(jdi.konec()){
                konecHry = true;
            }
        } else if (prikaz2.startsWith("mluv")) {
            String postava = prikaz2.substring(5);
            Prikaz mluv = new Mluv(postava);
            System.out.println(">> " + mluv.proved(svet));
        } else if (prikaz2.startsWith("vezmi")) {
            String predmet = prikaz2.substring(6);
            Prikaz vezmi = new Vezmi(predmet);
            System.out.println(">> " + vezmi.proved(svet));
        } else if (prikaz2.startsWith("poloz")) {
            String predmet = prikaz2.substring(6);
            Prikaz poloz = new Poloz(predmet);
            System.out.println(">> " + poloz.proved(svet));
        } else if (prikaz2.startsWith("pouzij")) {
            String predmet = prikaz2.substring(7);
            Prikaz pouzij = new Pouzij(predmet);
            System.out.println(">> " + pouzij.proved(svet));
        } else if (prikaz2.equals("strel")) {
            Prikaz strel = new Strel();
            System.out.println(">> " + strel.proved(svet));
            if (strel.konec()) {
                konecHry = true;
            }
        } else if (prikaz2.equals("poves")) {
            Prikaz poves = new Poves();
            System.out.println(">> " + poves.proved(svet));
            if(poves.konec()){
                konecHry = true;
            }
        } else if (prikaz2.equals("nabit")) {
            Prikaz nabit = new Nabit();
            System.out.println(">> " + nabit.proved(svet));
        } else if (prikaz2.equals("inventar")) {
            Prikaz inventar = new ZobrazitInventar();
            System.out.println(">> " + inventar.proved(svet));
        } else if (mapa.containsKey(prikaz2)) {
            Prikaz prikaz = mapa.get(prikaz2);
            System.out.println(">> " + prikaz.proved(svet));
            if(prikaz.konec()){
                konecHry = true;
            }else{
                System.out.println(">> Neznamy prikaz");
            }
        }
    }

    /**
     * Spousti hlavni herni smycku.
     * Nejprve nacita uvodni text, nastavuje prikazy a pote provadi prikazy hrace dokud hra nekonci.
     */
    public void start(){
        zobrazitUvodniText("uvod.txt");
        inicializace();
        try{
            do{
                provedPrikaz();
            }while(!konecHry);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}



