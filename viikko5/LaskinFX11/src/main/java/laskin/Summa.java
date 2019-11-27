package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Summa extends Komento {

    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private int edellinenPlus = 0;

    public Summa(TextField tuloskentta, TextField syotekentta,
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
        sovellus.plus(Integer.parseInt(syotekentta.getText()));
        edellinenPlus = Integer.parseInt(syotekentta.getText());
        tuloskentta.setText(String.valueOf(sovellus.tulos()));
        syotekentta.setText("");

    }

    @Override
    public void peru() {
        sovellus.miinus(edellinenPlus);
        tuloskentta.setText(String.valueOf(sovellus.tulos()));
    }
}
