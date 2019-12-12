package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPS {

    Scanner scanner;
    Tekoaly tekoaly;

    public static KPS pelaajaVsPelaaja(Scanner scanner) {
        return new KPSPelaajaVsPelaaja(scanner);
    }

    public static KPS tekoaly(Scanner scanner) {
        return new KPSTekoaly(scanner, new TekoalyImpl());
    }

    public static KPS parempiTekoaly(Scanner scanner){
        return new KPSParempiTekoaly(scanner, new TekoalyParannettu(20));
    }

    protected KPS(Scanner scanner, Tekoaly tekoaly) {
        this.tekoaly = tekoaly;
        this.scanner = scanner;
    }

    protected KPS(Scanner scanner) {
        this.scanner = scanner;
    }

}
