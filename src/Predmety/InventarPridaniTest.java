package Predmety;

import static org.junit.jupiter.api.Assertions.*;

import Postavy.Hrac;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testovaci trida pro metodu pridatPredmet() ve tride Inventar.
 */
class InventarPridaniTest {

    private Inventar inventar;
    private Predmet brokovnice;
    private Predmet naboje;
    private Predmet klobouk;

    /**
     * Nastavi testovaci prostredi pred kazdym testem.
     */
    @BeforeEach
    public void setUp() {
        inventar = new Inventar(3);
        brokovnice = new Predmet("Brokovnice", "Brokovnice pro lov pumy") {
            @Override
            public String pouzij(Hrac hrac) {
                return "Pouzil jsi brokovnici.";
            }
        };
        naboje = new Predmet("Naboje", "Naboje do brokovnice") {
            @Override
            public String pouzij(Hrac hrac) {
                return "Pouzil jsi naboje.";
            }
        };
        klobouk = new Predmet("Klobouk", "Stylovy kovbojsky klobouk") {
            @Override
            public String pouzij(Hrac hrac) {
                return "Nasadil sis klobouk.";
            }
        };
    }

    /**
     * Testuje uspesne pridani predmetu do inventare.
     */
    @Test
    public void testPridatPredmetUspesne() {
        assertTrue(inventar.pridatPredmet(brokovnice), "Brokovnice by mela byt uspesne pridana.");
        assertTrue(inventar.obsahujePredmet("Brokovnice"), "Inventar by mel obsahovat brokovnici.");
    }

    /**
     * Testuje, ze nelze pridat stejny predmet dvakrat.
     */
    @Test
    public void testPridatStejnyPredmet() {
        inventar.pridatPredmet(brokovnice);
        assertFalse(inventar.pridatPredmet(brokovnice), "Nemel by jit pridat stejny predmet dvakrat.");
    }

    /**
     * Testuje, ze lze pridat vice ruznych predmetu do inventare.
     */
    @Test
    public void testPridatVicePredmetu() {
        assertTrue(inventar.pridatPredmet(brokovnice), "Prvni predmet mel byt uspesne pridan.");
        assertTrue(inventar.pridatPredmet(naboje), "Druhy predmet mel byt uspesne pridan.");
        assertTrue(inventar.pridatPredmet(klobouk), "Treti predmet mel byt uspesne pridan.");
        assertTrue(inventar.obsahujePredmet("Brokovnice"), "Inventar by mel obsahovat brokovnici.");
        assertTrue(inventar.obsahujePredmet("Naboje"), "Inventar by mel obsahovat naboje.");
        assertTrue(inventar.obsahujePredmet("Klobouk"), "Inventar by mel obsahovat klobouk.");
    }

    /**
     * Testuje, ze nelze pridat predmet, pokud je inventar plny.
     */
    @Test
    public void testPridatPredmetDoPlnehoInventare() {
        inventar.pridatPredmet(brokovnice);
        inventar.pridatPredmet(naboje);
        inventar.pridatPredmet(klobouk);

        Predmet doutnik = new Predmet("Doutnik", "Kvalitni doutnik") {
            @Override
            public String pouzij(Hrac hrac) {
                return "Zapalis si doutnik.";
            }
        };

        assertFalse(inventar.pridatPredmet(doutnik), "Nemel by jit pridat predmet, pokud je inventar plny.");
    }

    /**
     * Testuje, ze nelze pridat null hodnotu do inventare.
     */
    @Test
    public void testPridatNullPredmet() {
        assertFalse(inventar.pridatPredmet(null), "Nemel by jit pridat null predmet.");
    }
}