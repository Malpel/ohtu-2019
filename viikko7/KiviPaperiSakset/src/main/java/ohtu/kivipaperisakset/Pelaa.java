package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class Pelaa {

    Tuomari tuomari;
    Scanner scanner;
    String ekanSiirto;
    String tokanSiirto;
    Boolean kaynnissa;

    public Pelaa(Scanner scanner) {
        tuomari = new Tuomari();
        this.scanner = scanner;
        kaynnissa = true;
    }

    public void pelaa() {
        gameLoop();
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);

    }

    public void gameLoop() {
        while (kaynnissa) {
            ekanSiirto = ekanSiirto();
            tokanSiirto = tokanSiirto();

            if (!onkoOkSiirto(ekanSiirto) || !onkoOkSiirto(tokanSiirto)) {
                kaynnissa = false;
            }

            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
        }
    }

    public String ekanSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }

    protected abstract String tokanSiirto();

    public static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

}
