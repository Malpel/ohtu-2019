
package ohtu.intjoukkosovellus;

public class IntJoukko {

    private int koko = 5; // aloitustalukon koko
    private int kasvatuskoko = 5;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;      // Joukon luvut säilytetään taulukon alkupäässä.
    private int alkioidenLkm = 0;    // Tyhjässä joukossa alkioiden_määrä on nolla.

    public IntJoukko() {
        lukujono = new int[koko];
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        lukujono = new int[kapasiteetti];
    }
    
    public IntJoukko(int ...args) {
        if (args[0] < 0 || args[1] < 0 ) {
            System.out.println("kapasiteetti tai kasvatuskoko ei voi olla negatiivinen");
        }
        lukujono = new int[args[0]];
        this.kasvatuskoko = args[1];

    }

    public void lisaa(int luku) {
        if (alkioidenLkm == 0) {
            lukujono[0] = luku;
            alkioidenLkm++;
        }

        if (!kuuluu(luku)) {
            eiKuulu(luku);
        }
    }

    public void eiKuulu(int luku) {
        lukujono[alkioidenLkm] = luku;
        alkioidenLkm++;
        if (alkioidenLkm % lukujono.length == 0) {
            int[] taulukkoOld = lukujono;
            lukujono = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(taulukkoOld, lukujono);
        }
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                return true;
            }
        }
        return false;
    }

    public void poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                lukujono[i] = 0;
                siirräAlkiot(i);
                alkioidenLkm--;
                break;
            }
        }
    }

    public void siirräAlkiot(int i) {
        int apu;
        for (int j = i; j < alkioidenLkm - 1; j++) {
            apu = lukujono[j];
            lukujono[j] = lukujono[j + 1];
            lukujono[j + 1] = apu;
        }
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + lukujono[0] + "}";
        } else {
            return formatString();
        }
    }

    public String formatString() {
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += lukujono[i];
            tuotos += ", ";
        }
        tuotos += lukujono[alkioidenLkm - 1];
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
            x.lisaa(bTaulu[i]);
        }

        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }
 
        return z;
    }
        
}
