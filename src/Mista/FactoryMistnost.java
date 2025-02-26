package Mista;

public class FactoryMistnost {

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
