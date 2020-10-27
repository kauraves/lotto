package com.kauraset.lotto;

import java.util.*;

public class Lottery {
    public static final int LOTTONUMEROITA = 7;
    public static final int MAX_LOTTONUMERO = 40;


    public static void main(String[] args) {
        Set<Integer> kuponki = null;
        Set<Integer> lottonumerot = null;
        int lisanumero = 0;
        int numeroitaOikein = 0;
        boolean lisanumeroOikein = false;

        lottonumerot = arvoLottonumerot();
        kuponki = luePelaajanNumerot();
        lisanumero = arvoLisanumero(lottonumerot);

        // Varsinaiset numerot
        Set<Integer> oikeitaNumeroita = new TreeSet<Integer>(kuponki);
        oikeitaNumeroita.retainAll(lottonumerot);
        if (oikeitaNumeroita != null) {
            numeroitaOikein = oikeitaNumeroita.size();
        }

        // Lisänumero
        if (kuponki.contains(lisanumero)) {
            lisanumeroOikein = true;
        }

        if (numeroitaOikein == 7) {
            System.out.println("Seitsemän (7) oikein!");
        } else if (numeroitaOikein == 6 && lisanumeroOikein) {
            System.out.println("Kuusi (6) ja lisänumero oikein");
        } else if (numeroitaOikein == 6) {
            System.out.println("Kuusi (6) oikein");
        } else if (numeroitaOikein == 5) {
            System.out.println("Viisi (5) oikein");
        } else if (numeroitaOikein == 4) {
            System.out.println("Neljä (4) oikein");
        } else if (numeroitaOikein == 3 && lisanumeroOikein) {
            System.out.println("Kolme (3) ja lisänumero oikein");
        } else {
            System.out.println("Ei voittoa.");
        }

    }

    public static Set<Integer> arvoLottonumerot() {
        Set<Integer> lottonumerot = new TreeSet<Integer>();
        int numero = 0;

        Random r = new Random();
        while (lottonumerot.size() < LOTTONUMEROITA) {
            numero = r.nextInt(MAX_LOTTONUMERO) + 1;
            lottonumerot.add(numero);
        }
        return lottonumerot;
    }

    public static int arvoLisanumero(Set<Integer> lottonumerot) {

        boolean found = false;
        int lisanumero = 0;

        Random r = new Random();
        while (!found) {
            lisanumero = r.nextInt(MAX_LOTTONUMERO) + 1;
            if (!lottonumerot.contains(lisanumero)) {
                // Lisänumero saatiin.
                found = true;
            }
        }
        return lisanumero;
    }

    public static Set<Integer> luePelaajanNumerot() {
        Set<Integer> kupunki = new TreeSet<Integer>();
        Scanner console = new Scanner(System.in);
        System.out.print("Anna " + LOTTONUMEROITA + " lottonumeroa: ");
        while (kupunki.size() < LOTTONUMEROITA) {
            int numero = console.nextInt();
            kupunki.add(numero);
        }
        return kupunki;
    }    

}
