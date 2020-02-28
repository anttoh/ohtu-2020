package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {
    protected Sovelluslogiikka sovelluslogiikka;
    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Button nollaa;
    protected int arvo;
    protected String tuloskenttaHistoria;
    protected String syotekenttaHistoria;

    public Komento(Sovelluslogiikka sovelluslogiikka, TextField tuloskentta, TextField syotekentta, Button nollaa) {
        this.sovelluslogiikka = sovelluslogiikka;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.arvo = 0;
    }

    public void setHistory() {
        tuloskenttaHistoria = tuloskentta.getText();
        syotekenttaHistoria = syotekentta.getText();
    }

    public void peru() {
        syotekentta.setText(syotekenttaHistoria);
        tuloskentta.setText(tuloskenttaHistoria);
    }

    public abstract void suorita();

}
