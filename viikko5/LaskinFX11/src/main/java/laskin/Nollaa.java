package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private int viimeTulos = 0;

    public Nollaa(TextField tuloskentta, TextField syotekentta,
                  Button nollaa, Button undo,
                  Sovelluslogiikka sovellus) {
        super();
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        viimeTulos = sovellus.tulos();
        sovellus.nollaa();
        tuloskentta.setText(String.valueOf(0));
        syotekentta.setText("");
    }

    @Override
    public void peru() {
        sovellus.plus(viimeTulos);
        tuloskentta.setText(String.valueOf(sovellus.tulos()));
    }
}
