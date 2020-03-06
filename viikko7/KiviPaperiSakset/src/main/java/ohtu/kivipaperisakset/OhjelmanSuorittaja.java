package ohtu.kivipaperisakset;

import java.util.Scanner;

public class OhjelmanSuorittaja {

    private static final Scanner scanner = new Scanner(System.in);
    private static String vastaus = null;
    private static KPSPeli peli = null;

    public static void kaynnista() {
        suoritusLoop: while (true) {
            System.out.println("\nValitse pelataanko" + "\n (a) ihmistä vastaan " + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan" + "\nmuilla valinnoilla lopetataan");

            vastaus = scanner.nextLine();
            switch (vastaus) {
                case "a":
                    peli = KPSPeli.kaksinpeli();
                    break;
                case "b":
                    peli = KPSPeli.helppoYksinpeli();
                    break;
                case "c":
                    peli = KPSPeli.vaikeaYksinpeli();
                    break;
                default:
                    break suoritusLoop;
            }
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            peli.pelaa();
        }
    }
}
