package BlackJack;

public class Carta {
    private String pinta;
    private int valor;
    private String symb;

    /**
     *
     * @param pinta
     * @param valor
     * @param symb
     */
    public Carta(String pinta, int valor, String symb) {
        this.pinta = pinta;
        this.valor = valor;
        this.symb = symb;
    }

    public int getvalor() {
        return valor;
    }

    public String getsymb() {
        return symb;
    }
}
