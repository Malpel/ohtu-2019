package laskin;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {

    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private int edellinenMiinus = 0;

    public Erotus(TextField tuloskentta, TextField syotekentta,
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
        sovellus.miinus(Integer.parseInt(syotekentta.getText()));
        edellinenMiinus = Integer.parseInt(syotekentta.getText());
        tuloskentta.setText(String.valueOf(sovellus.tulos()));
        syotekentta.setText("");

    }

    @Override
    public void peru() {
        sovellus.plus(edellinenMiinus);
        tuloskentta.setText(String.valueOf(sovellus.tulos()));
    }
}
