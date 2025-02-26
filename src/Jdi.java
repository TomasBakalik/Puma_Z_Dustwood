public class Jdi implements Prikaz{

    private String smer;

    public Jdi(String smer) {
        this.smer = smer.toLowerCase();
    }

    @Override
    public String proved(Svet svet) {
        if(svet.getAktualniMistnost() == null) {
            return "Chyba: Aktualni mistnost neni nastavena";
        }

        Mistnost novaMistnost = svet.getAktualniMistnost().ziskatVychod(smer);
        if(novaMistnost != null) {
            svet.setAktualniMistnost(novaMistnost);
            return "Presunul jsi se do : " + novaMistnost.getNazev() + "\n" + novaMistnost.getPopis();
        }else{
            return "Timto smerem nelze jit.";
        }
    }

    @Override
    public boolean konec() {
        return false;
    }
}
