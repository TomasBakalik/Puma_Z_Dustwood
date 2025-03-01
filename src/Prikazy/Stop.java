package Prikazy;
import Hlavni.Svet;

public class Stop implements Prikaz {
    @Override
    public String proved(Svet svet) {
        return "Hra byla ukonena";
    }

    @Override
    public boolean konec() {
        return true;
    }
}
