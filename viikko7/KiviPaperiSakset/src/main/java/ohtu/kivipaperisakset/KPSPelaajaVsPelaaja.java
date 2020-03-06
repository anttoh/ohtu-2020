package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends KPSPeli {

    @Override
    protected void tokaSiirto() {
        System.out.print("Toisen pelaajan siirto: ");
        tokanSiirto = lukija.nextLine();
    }
}