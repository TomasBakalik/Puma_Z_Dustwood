package Prikazy;
import Hlavni.Svet;

/**
 * Rozhrani prikaz definuje zakladni strukturu pro vsechny prikazy.
 * Kazdy prikaz ma metodu proved, ktera dany prikaz vykonava.
 * Kazdy prikaz ma zaroven metodu konec, ktera urcuje, zda prikaz ukoncuje hru.
 */
public interface Prikaz {

    /**
     * Metoda, ktera spravuje konkretni prikazy.
     * @param svet Instance herniho sveta, ve kterem se prikaz vykonava.
     * @return String, obsahujici vysledek po provedeni prikazu.
     */
    String proved(Svet svet);

    /**
     * Metoda, ktera urcuje, zda prikaz znamena konec hry.
     * @return pokud prikaz hru ukoncuje, tak true, jinak false.
     */
    boolean konec();
}
