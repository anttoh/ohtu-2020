package ohtu.intjoukkosovellus;

import java.util.HashSet;

public class IntJoukko {

    private HashSet<Integer> joukko;

    public IntJoukko(Object... args) {
        joukko = new HashSet<>();
    }

    public boolean sisaltaakoJoukkoLuvun(int luku) {
        return joukko.contains(luku);
    }

    public boolean lisaaJoukkoon(int luku) {
        if (sisaltaakoJoukkoLuvun(luku)) {
            return false;
        }
        joukko.add(luku);
        return true;
    }

    public boolean poistaJoukosta(int luku) {
        if (!sisaltaakoJoukkoLuvun(luku)) {
            return false;
        }
        joukko.remove(luku);
        return true;
    }

    public int palaautaAlkioidenLukumaara() {
        return joukko.size();
    }

    public int[] palautaJoukkoIntTaulukkona() {
        return joukko.stream().mapToInt(Number::intValue).toArray();
    }

    public static IntJoukko yhdiste(IntJoukko joukko1, IntJoukko joukko2) {
        IntJoukko yhdisteJoukko = luoJaPalautaKopioJoukosta(joukko1);
        for (int luku : joukko2.palautaJoukkoIntTaulukkona()) {
            yhdisteJoukko.lisaaJoukkoon(luku);
        }
        return yhdisteJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko joukko1, IntJoukko joukko2) {
        IntJoukko leikkausJoukko = luoJaPalautaKopioJoukosta(joukko1);
        for (int luku : leikkausJoukko.palautaJoukkoIntTaulukkona()) {
            if (!joukko2.sisaltaakoJoukkoLuvun(luku)) {
                leikkausJoukko.poistaJoukosta(luku);
            }
        }
        return leikkausJoukko;
    }

    public static IntJoukko erotus(IntJoukko joukko1, IntJoukko joukko2) {
        IntJoukko erotusJoukko = luoJaPalautaKopioJoukosta(joukko1);
        for (int luku : joukko2.palautaJoukkoIntTaulukkona()) {
            erotusJoukko.poistaJoukosta(luku);
        }
        return erotusJoukko;
    }

    private static IntJoukko luoJaPalautaKopioJoukosta(IntJoukko joukko) {
        IntJoukko kopio = new IntJoukko();
        for (int luku : joukko.palautaJoukkoIntTaulukkona()) {
            kopio.lisaaJoukkoon(luku);
        }
        return kopio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        String vali = "";
        for (int luku : palautaJoukkoIntTaulukkona()) {
            sb.append(vali + luku);
            vali = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
