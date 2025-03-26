package Prikazy;

import Hlavni.Svet;
import Mista.Mistnost;
import Mista.Hospoda;
import Mista.Namesti;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testovaci trida pro prikaz Jdi.
 */
class JdiTest {

    private Svet svet;
    private Jdi prikazJdi;

    @BeforeEach
    public void setUp() {
        svet = new Svet("mapa.csv");
        System.out.println("Nastaveni sveta dokonceno");
    }

    /**
     * Testuje zda se hrac muze presunout do existujici mistnosti.
     */
    @Test
    public void testPresunDoExistujiciMistnosti() {
        System.out.println("Test: Presun do existujici mistnosti");

        svet.setAktualniMistnost(new Namesti());
        Mistnost hospoda = new Hospoda();
        svet.getAktualniMistnost().nastavitVychod("hospoda", hospoda);

        prikazJdi = new Jdi("hospoda");
        String vysledek = prikazJdi.proved(svet);

        System.out.println("Ocekavana mistnost: Hospoda");
        System.out.println("Skutecna mistnost: " + svet.getAktualniMistnost().getNazev());

        assertEquals(hospoda, svet.getAktualniMistnost(), "Hrac by mel byt v hospode.");
        assertTrue(vysledek.contains("Presunul jsi se do : Hospoda"), "Mela by se vypsat zprava o presunu.");
    }

    /**
     * Testuje, zda se hrac nemuze presunout do neexistujici mistnosti.
     */
    @Test
    public void testNeplatnyPresun() {
        System.out.println("Test: Neplatny presun");

        svet.setAktualniMistnost(new Namesti());

        prikazJdi = new Jdi("domov");
        String vysledek = prikazJdi.proved(svet);

        System.out.println("Ocekavana mistnost: Namesti (zmena by nemela nastat)");
        System.out.println("Skutecna mistnost: " + svet.getAktualniMistnost().getNazev());
        System.out.println("Vysledek prikazu: " + vysledek);

        assertEquals("Timto smerem nelze jit.", vysledek, "Hrac by se nemel presunout, protoze smer neexistuje.");
        assertEquals("Namesti", svet.getAktualniMistnost().getNazev(), "Hrac by mel zustat v namesti.");
    }
}