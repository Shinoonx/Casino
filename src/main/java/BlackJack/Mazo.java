package BlackJack;

import java.util.ArrayList;

public class Mazo {
    private ArrayList<Carta> mazo = new ArrayList<Carta>();

    public void Mazo() {
        String symb = "";
        int valor = 0;

        for (int i = 1; i <= 13; i++) {

            if (i == 1) {
                symb = "As";
                valor = 11;
            } else if (i == 11) {
                symb = "J";
                valor = 10;
            } else if (i == 12) {
                symb = "Q";
                valor = 10;
            } else if (i == 13) {
                symb = "K";
                valor = 10;
            } else {
                symb = Integer.toString(i);
                valor = i;
            }

            Carta carPica = new Carta(symb, valor, "Pica");
            Carta carTreb = new Carta(symb, valor, "Trébol");
            Carta carDiam = new Carta(symb, valor, "Diamante");
            Carta carCora = new Carta(symb, valor, "Corazón");

            mazo.add(carPica);
            mazo.add(carTreb);
            mazo.add(carDiam);
            mazo.add(carCora);
        }
    }

    public ArrayList<Carta> getCarta() {
        return mazo;
    }

}
