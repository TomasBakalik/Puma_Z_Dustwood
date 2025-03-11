package Hlavni;

import Predmety.Inventar;
import Prikazy.*;
import java.util.HashMap;
import java.util.Scanner;

public class Konzole {

    private boolean konecHry = false;
    private HashMap<String, Prikaz> mapa = new HashMap<>();
    private Svet svet;
    private Scanner scanner = new Scanner(System.in);

    public Konzole(Svet svet){
        this.svet = svet;
    }

    public void inicializace(){
        mapa.put("stop", new Stop());
        mapa.put("napoveda", new Napoveda());
        mapa.put("pomoc", new Pomoc());
        mapa.put("inventar", new ZobrazitInventar());
        mapa.put("nabit", new Nabit());
    }

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

    public void start(){
        inicializace();
        System.out.println("Vitej ve hre! Napis prikaz 'napoveda' pro seznam prikazu nebo 'stop' pro konec hry.");
        try{
            do{
                provedPrikaz();
            }while(!konecHry);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}



