package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KPS {

    protected KPSParempiTekoaly(Scanner scanner, Tekoaly tekoaly) {
        super(scanner, tekoaly);
        pelaa();
    }

    public void pelaa() {
        new PelaaTekoaly(scanner, tekoaly).pelaa();
    }
}
