package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KPS{

    protected KPSTekoaly(Scanner scanner, Tekoaly tekoaly) {
        super(scanner, tekoaly);
        pelaa();
    }

    public void pelaa() {
        new PelaaTekoaly(scanner, tekoaly).pelaa();
    }
}