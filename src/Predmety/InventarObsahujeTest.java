package Predmety;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventarObsahujeTest {


    private Inventar inventar;
    private Predmet brokovnice;

    /**
     * Inicializace pred kazdym testem.
     */
    @BeforeEach
    public void setUp() {
        inventar = new Inventar(4);
        brokovnice = new Predmet("Brokovnice", "Silna zbran") {
            @Override
            public String pouzij(Postavy.Hrac hrac) {
                return "Vystrelil jsi z brokovnice!";
            }
        };
    }

    /**
     * Testuje, zda obsahuje existujici predmet.
     */
    @Test
    public void testObsahujeExistujiciPredmet() {
        inventar.pridatPredmet(brokovnice);
        assertTrue(inventar.obsahujePredmet("Brokovnice"), "Inventar by mel obsahovat 'Brokovnici'.");
    }

    /**
     * Testuje, zda obsahuje neexistujici predmet.
     */
    @Test
    public void testObsahujeNeexistujiciPredmet() {
        assertFalse(inventar.obsahujePredmet("Klobouk"), "Inventar by nemel obsahovat 'Klobouk'.");
    }

    /**
     * Testuje, zda obsahuje predmet v prazdnem inventari.
     */
    @Test
    public void testObsahujeVyprazdnenyInventar() {
        assertFalse(inventar.obsahujePredmet("Brokovnice"), "Inventar je prazdny, nemel by obsahovat zadne predmety.");
    }

    /**
     * Testuje, zda obsahuje predmet s prazdnym nazvem.
     */
    @Test
    public void testObsahujePrazdnyNazev() {
        assertFalse(inventar.obsahujePredmet(""), "Nemel by jit najit predmet s prazdnym nazvem.");
    }

    /**
     * Testuje, zda obsahuje predmet s null hodnotou.
     */
    @Test
    public void testObsahujeNullPredmet() {
        assertFalse(inventar.obsahujePredmet(null), "Nemel by jit najit predmet s hodnotou null.");
    }

    /**
     * Testuje, zda metoda ignoruje velikost pismen.
     */
    @Test
    public void testObsahujeIgnoreCase() {
        inventar.pridatPredmet(brokovnice);
        assertTrue(inventar.obsahujePredmet("brokovnice"), "Inventar by mel najit 'Brokovnici' i pri jinem formatu pismen.");
    }
}