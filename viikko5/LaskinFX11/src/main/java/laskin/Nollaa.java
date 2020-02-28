package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    public Nollaa(Sovelluslogiikka sovelluslogiikka, TextField tuloskentta, TextField syotekentta, Button nollaa) {
        super(sovelluslogiikka, tuloskentta, syotekentta, nollaa);
    }

    @Override
    public void suorita() {
        setHistory();
        sovelluslogiikka.nollaa();
        int laskunTulos = sovelluslogiikka.tulos();

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);

        if (laskunTulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
    }

    @Override
    public void peru() {
        sovelluslogiikka.plus(Integer.parseInt(tuloskenttaHistoria));
        super.peru();
    }
}
