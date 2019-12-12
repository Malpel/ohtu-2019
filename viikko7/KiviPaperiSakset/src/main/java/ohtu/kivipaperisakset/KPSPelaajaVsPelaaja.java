package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPS {

    protected KPSPelaajaVsPelaaja(Scanner scanner) {
        super(scanner);
        pelaa();
    }

    public void pelaa() {
        new PelaaPVP(scanner).pelaa();
    }
}