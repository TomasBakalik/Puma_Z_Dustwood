package Hlavni;

import Mista.Mistnost;
import Mista.Hospoda;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testovaci trida pro metodu getAktualniMistnost() ve tride Svet.
 */
class SvetAktualniMistnostTest {

    private Svet svet;

    @BeforeEach
    void setUp() {
        svet = new Svet("mapa.csv");
        System.out.println("Svet nastaven.");
    }

    /**
     * Testuje, zda se po inicializaci hry nachazi hrac v ocekavane mistnosti.
     */
    @Test
    void testVychoziMistnost() {
        String nazevMistnosti = svet.getAktualniMistnost().getNazev();
        System.out.println("Vychozi mistnost hrace: " + nazevMistnosti);
        assertNotNull(svet.getAktualniMistnost(), "Aktualni mistnost by nemela byt null.");
        assertEquals("Namesti", nazevMistnosti, "Hrac by mel zacit na namesti.");
        System.out.println("Test vychozi mistnosti uspesne dokoncen.");
    }

    /**
     * Testuje, zda se aktualni mistnost spravne meni pri pouziti metody setAktualniMistnost().
     */
    @Test
    void testZmenaMistnosti() {
        Mistnost novaMistnost = new Hospoda();
        svet.setAktualniMistnost(novaMistnost);
        System.out.println("Hrac se presunul do: " + svet.getAktualniMistnost().getNazev());
        assertEquals(novaMistnost, svet.getAktualniMistnost(), "Mistnost by se mela spravne zmenit na hospodu.");
        System.out.println("Test zmeny mistnosti uspesne dokoncen.");
    }
}