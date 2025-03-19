package Mista;

/**
 * Trida FactoryMistnost slouzi pro vytvareni instanci mistnosti na zaklade jejich nazvu.
 */
public class FactoryMistnost {

    /**
     * Staticka metoda pro vytvoreni instance mistnosti, podle zadaneho nazvu.
     * Pokud nazev odpovida nektere z jiz existujicich mistnosti, vrati se jeji instance.
     * Pokud je zadany nazev chybny/neplatny, vyvola se vyjimka.
     * @param nazev Nazev mistnosti, ktera ma byt vytvorena.
     * @return Instance mitnosti odpovidajici zadanemu nazvu.
     */
    public static Mistnost vytvorMistnost(String nazev){
        switch (nazev.toLowerCase()){
            case "namesti":
                return new Namesti();
            case "zoo":
                return new Zoo();
            case "hospoda":
                return new Hospoda();
            case "starostuv dum":
                return new StarostuvDum();
            case "obchod":
                return new Obchod();
            case "ohrada":
                return new Ohrada();
            case "souseduv dum":
                return new SouseduvDum();
            case "strecha hospody":
                return new StrechaHospody();
            default:
                throw new IllegalArgumentException("Neznama mistnost: " + nazev);
        }
    }
}
