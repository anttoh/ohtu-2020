package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tapahtumankuuntelija implements EventHandler {
    private Komentotehdas komentotehdas;
    private Komento edellinen = null;
    private Button undo;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa,
            Button undo) {
        this.undo = undo;
        this.komentotehdas = new Komentotehdas(new Sovelluslogiikka(), tuloskentta, syotekentta, plus, miinus, nollaa);
    }

    @Override
    public void handle(Event event) {
        if (event.getTarget() != undo) {
            Komento komento = this.komentotehdas.hae((Button) event.getTarget());
            komento.suorita();
            edellinen = komento;
            this.undo.disableProperty().set(false);
        } else if (edellinen != null) {
            edellinen.peru();
            edellinen = null;
            this.undo.disableProperty().set(true);
        }
    }

}
