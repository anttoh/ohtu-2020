package ohtu.kivipaperisakset;

public class KPSTekoaly extends KPSPeli {

    protected Tekoaly tekoaly;

    public KPSTekoaly() {
        this.tekoaly = new Tekoaly();
    }

    @Override
    protected void tokaSiirto() {
        tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);
    }
}