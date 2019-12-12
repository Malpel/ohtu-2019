package ohtu.kivipaperisakset;

import java.util.Scanner;

public class PelaaPVP extends Pelaa {

    public PelaaPVP(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected String tokanSiirto() {
        System.out.print("Toisen pelaajan siirto: ");
        return scanner.nextLine();
    }
}
