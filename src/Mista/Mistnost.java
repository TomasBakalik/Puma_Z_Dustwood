package Mista;

import java.util.HashMap;

public abstract class Mistnost {

    protected String nazev;
    protected String popis;
    protected HashMap<String, Mistnost> vychody;

    public Mistnost(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        this.vychody = new HashMap<>();
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
}
