package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KPSPeli {

    private final Tuomari tuomari;
    protected final Scanner lukija;
    protected String ekanSiirto;
    protected String tokanSiirto;

    public KPSPeli() {
        this.tuomari = new Tuomari();
        this.lukija = new Scanner(System.in);
        this.ekanSiirto = "k";
        this.tokanSiirto = "k";
    }

    public void pelaa() {
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            ekaSiirto();
            tokaSiirto();
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    private void ekaSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        ekanSiirto = lukija.nextLine();
    }

    protected abstract void tokaSiirto();

    // Staattiset tehdasmetodit

    public static KPSPeli kaksinpeli() {
        return new KPSPelaajaVsPelaaja();
    }

    public static KPSPeli helppoYksinpeli() {
        return new KPSTekoaly();
    }

    public static KPSPeli vaikeaYksinpeli() {
        return new KPSParempiTekoaly();
    }
}
