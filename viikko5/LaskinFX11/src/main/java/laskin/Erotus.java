package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {

    public Erotus(Sovelluslogiikka sovelluslogiikka, TextField tuloskentta, TextField syotekentta, Button nollaa) {
        super(sovelluslogiikka, tuloskentta, syotekentta, nollaa);
    }

    @Override
    public void suorita() {
        try {
            setHistory();
            arvo = Integer.parseInt(syotekentta.getText());
            sovelluslogiikka.miinus(arvo);
            int laskunTulos = sovelluslogiikka.tulos();

            syotekentta.setText("");
            tuloskentta.setText("" + laskunTulos);

            if (laskunTulos == 0) {
                nollaa.disableProperty().set(true);
            } else {
                nollaa.disableProperty().set(false);
            }

        } catch (Exception e) {
        }
    }

    @Override
    public void peru() {
        sovelluslogiikka.plus(arvo);
        super.peru();
    }
}
