package Prikazy;

import Hlavni.Svet;
import Predmety.Brokovnice;
import Predmety.Naboje;
import Predmety.Bavlna;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testovaci trida pro prikaz Vezmi.
 */
class VezmiTest {

    private Svet svet;

    @BeforeEach
    void setUp() {
        svet = new Svet("mapa.csv");
        svet.getAktualniMistnost().pridatPredmet(new Brokovnice());
        svet.getAktualniMistnost().pridatPredmet(new Naboje());
        svet.getAktualniMistnost().pridatPredmet(new Bavlna());
        System.out.println("Svet nastaven a predmety pridany do mistnosti.");
    }

    /**
     * Testuje zda hrac muze vzit predmet, ktery existuje v mistnosti.
     */
    @Test
    void testVezmiExistujiciPredmet() {
        System.out.println("Test: Vezmi existujici predmet");

        Vezmi prikaz = new Vezmi("Brokovnice");
        String vysledek = prikaz.proved(svet);

        System.out.println("Ocekavany vysledek: Vzal jsi Brokovnice do inventare.");
        System.out.println("Skutecny vysledek: " + vysledek);

        assertTrue(svet.getHrac().getInventar().obsahujePredmet("Brokovnice"), "Inventar by mel obsahovat brokovnici.");
        assertEquals("Vzal jsi Brokovnice do inventare", vysledek, "Zprava by mela odpovidat.");
    }

    /**
     * Testuje zda nelze vzit predmet, ktery v mistnosti neni.
     */
    @Test
    void testVezmiNeexistujiciPredmet() {
        System.out.println("Test: Vezmi neexistujici predmet");

        Vezmi prikaz = new Vezmi("neexistujici_predmet");
        String vysledek = prikaz.proved(svet);

        System.out.println("Ocekavany vysledek: Tento predet tu neni.");
        System.out.println("Skutecny vysledek: " + vysledek);

        assertEquals("Tento predet tu neni", vysledek, "Zprava by mela odpovidat.");
    }

    /**
     * Testuje, zda hrac nemuze vzit naboje bez brokovnice.
     */
    @Test
    void testVezmiNabojeBezBrokovnice() {
        System.out.println("Test: Vezmi naboje bez brokovnice");

        Vezmi prikaz = new Vezmi("Naboje");
        String vysledek = prikaz.proved(svet);

        System.out.println("Ocekavany vysledek: Nemuzes vzit naboje, protoze nemas brokovnici.");
        System.out.println("Skutecny vysledek: " + vysledek);

        assertEquals("Nemuzes vzit naboje, protoze nemas brokovnici.", vysledek, "Zprava by mela odpovidat.");
    }

    /**
     * Testuje, zda hrac nemuze vzit naboje, pokud nema bavlnu.
     */
    @Test
    void testVezmiNabojeBezBavlny() {
        System.out.println("Test: Vezmi naboje bez bavlny");

        svet.getHrac().getInventar().pridatPredmet(new Brokovnice()); // Hrac dostane brokovnici

        Vezmi prikaz = new Vezmi("Naboje");
        String vysledek = prikaz.proved(svet);

        System.out.println("Ocekavany vysledek: Frank ti neda naboje zadarmo, nejdrive mu dones bavlnu.");
        System.out.println("Skutecny vysledek: " + vysledek);

        assertEquals("Frank ti neda naboje zadarmo, nejdrive mu dones bavlnu.", vysledek, "Zprava by mela odpovidat.");
    }

    /**
     * Testuje, zda hrac muze vzit naboje, pokud ma bavlnu a brokovnici.
     */
    @Test
    void testVezmiNabojeSeSpravnymiPodminkami() {
        System.out.println("Test: Vezmi naboje s bavlnou a brokovnici");

        svet.getHrac().getInventar().pridatPredmet(new Brokovnice());
        svet.getHrac().getInventar().pridatPredmet(new Bavlna());

        Vezmi prikaz = new Vezmi("Naboje");
        String vysledek = prikaz.proved(svet);

        System.out.println("Ocekavany vysledek: Vzal jsi Naboje do inventare.");
        System.out.println("Skutecny vysledek: " + vysledek);

        assertFalse(svet.getHrac().getInventar().obsahujePredmet("Bavlna"), "Bavlna by mela byt odebrana z inventare.");
        assertTrue(svet.getHrac().getInventar().obsahujePredmet("Naboje"), "Inventar by mel obsahovat naboje.");
        assertEquals("Vzal jsi Naboje do inventare", vysledek, "Zprava by mela odpovidat.");
    }
}
