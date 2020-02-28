package laskin;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Komentotehdas {
    private Map<Button, Komento> komennot;

    public Komentotehdas(Sovelluslogiikka sovelluslogiikka, TextField tuloskentta, TextField syotekentta, Button plus,
            Button miinus, Button nollaa) {
        komennot = new HashMap<>();
        komennot.put(plus, new Summa(sovelluslogiikka, tuloskentta, syotekentta, nollaa));
        komennot.put(miinus, new Erotus(sovelluslogiikka, tuloskentta, syotekentta, nollaa));
        komennot.put(nollaa, new Nollaa(sovelluslogiikka, tuloskentta, syotekentta, nollaa));

    }

    public Komento hae(Button nappi) {
        return komennot.get(nappi);
    }
}