package ohtu.kivipaperisakset;

import java.util.Scanner;

public class PelaaTekoaly extends Pelaa {

    Tekoaly tekoaly;

    public PelaaTekoaly(Scanner scanner, Tekoaly tekoaly) {
        super(scanner);
        this.tekoaly = tekoaly;
    }

    @Override
    protected String tokanSiirto() {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(super.ekanSiirto);
        return tokanSiirto;
    }
}
