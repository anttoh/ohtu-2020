package ohtu.intjoukkosovellus;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntJoukkoTest {

    IntJoukko joukko;

    @Before
    public void setUp() {
        joukko = new IntJoukko();
        joukko.lisaaJoukkoon(10);
        joukko.lisaaJoukkoon(3);
    }

    @Test
    public void lukujaLisattyMaara() {
        joukko.lisaaJoukkoon(4);
        assertEquals(3, joukko.palaautaAlkioidenLukumaara());
    }

    @Test
    public void samaLukuMeneeJoukkoonVaanKerran() {
        joukko.lisaaJoukkoon(10);
        joukko.lisaaJoukkoon(3);
        assertEquals(2, joukko.palaautaAlkioidenLukumaara());
    }

    @Test
    public void vainLisatytLuvutLoytyvat() {
        assertTrue(joukko.sisaltaakoJoukkoLuvun(10));
        assertFalse(joukko.sisaltaakoJoukkoLuvun(5));
        assertTrue(joukko.sisaltaakoJoukkoLuvun(3));
    }

    @Test
    public void poistettuEiOleEnaaJoukossa() {
        joukko.poistaJoukosta(3);
        assertFalse(joukko.sisaltaakoJoukkoLuvun(3));
        assertEquals(1, joukko.palaautaAlkioidenLukumaara());
    }

    @Test
    public void palautetaanOikeaTaulukko() {
        int[] odotettu = { 3, 55, 99 };

        joukko.lisaaJoukkoon(55);
        joukko.poistaJoukosta(10);
        joukko.lisaaJoukkoon(99);

        int[] vastaus = joukko.palautaJoukkoIntTaulukkona();
        Arrays.sort(vastaus);
        assertArrayEquals(odotettu, vastaus);
    }

    @Test
    public void toimiiKasvatuksenJalkeen() {
        int[] lisattavat = { 1, 2, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14 };
        for (int luku : lisattavat) {
            joukko.lisaaJoukkoon(luku);
        }
        assertEquals(14, joukko.palaautaAlkioidenLukumaara());
        assertTrue(joukko.sisaltaakoJoukkoLuvun(11));
        joukko.poistaJoukosta(11);
        assertFalse(joukko.sisaltaakoJoukkoLuvun(11));
        assertEquals(13, joukko.palaautaAlkioidenLukumaara());
    }

    @Test
    public void toStringToimii() {
        assertEquals("{3, 10}", joukko.toString());
    }

    @Test
    public void toStringToimiiYhdenKokoiselleJoukolla() {
        joukko = new IntJoukko();
        joukko.lisaaJoukkoon(1);
        assertEquals("{1}", joukko.toString());
    }

    @Test
    public void toStringToimiiTyhjallaJoukolla() {
        joukko = new IntJoukko();
        assertEquals("{}", joukko.toString());
    }
}
