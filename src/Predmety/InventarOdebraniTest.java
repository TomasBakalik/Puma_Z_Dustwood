package Predmety;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventarOdebraniTest {

    private Inventar inventar;
    private Predmet brokovnice;
    private Predmet naboje;

    /**
     * Nastaveni testovaciho prostredi pred kazdym testem.
     */
    @BeforeEach
    public void setUp() {
        inventar = new Inventar(4);
        brokovnice = new Predmet("Brokovnice", "Silna zbran") {
            @Override
            public String pouzij(Postavy.Hrac hrac) {
                return "Pouzil jsi brokovnici.";
            }
        };
        naboje = new Predmet("Naboje", "Munice do brokovnice") {
            @Override
            public String pouzij(Postavy.Hrac hrac) {
                return "Pouzil jsi naboje.";
            }
        };
    }

    /**
     * Testuje spravne odebrani existujiciho predmetu.
     */
    @Test
    public void testOdebratExistujiciPredmet() {
        inventar.pridatPredmet(brokovnice);
        assertTrue(inventar.odebratPredmet("Brokovnice"), "Predmet mel byt uspesne odebran.");
        assertFalse(inventar.obsahujePredmet("Brokovnice"), "Inventar by jiz nemel obsahovat brokovnici.");
    }

    /**
     * Testuje pokus o odebrani neexistujiciho predmetu.
     */
    @Test
    public void testOdebratNeexistujiciPredmet() {
        assertFalse(inventar.odebratPredmet("Dynamit"), "Nemelo by jit odebrat predmet, ktery v inventari neni.");
    }

    /**
     * Testuje odebrani predmetu z prazdneho inventare.
     */
    @Test
    public void testOdebratZPrazdnehoInventare() {
        assertFalse(inventar.odebratPredmet("Brokovnice"), "Nemelo by jit odebrat predmet z prazdneho inventare.");
    }

    /**
     * Testuje pridani dvou predmetu a nasledne odebrani jednoho.
     */
    @Test
    public void testOdebratJednotlivyPredmet() {
        inventar.pridatPredmet(brokovnice);
        inventar.pridatPredmet(naboje);

        assertTrue(inventar.odebratPredmet("Brokovnice"), "Predmet mel byt uspesne odebran.");
        assertFalse(inventar.obsahujePredmet("Brokovnice"), "Inventar by jiz nemel obsahovat brokovnici.");
        assertTrue(inventar.obsahujePredmet("Naboje"), "Inventar by mel stale obsahovat naboje.");
    }

}