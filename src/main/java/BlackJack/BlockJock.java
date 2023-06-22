package BlackJack;

public class BlockJock {
    public void Jugar() {

        String nombre = "Kurona";
        System.out.println("Su dealer sera "+ nombre);

        Dealer dealer = new Dealer(nombre);
        dealer.CrearMazito();
        dealer.mezclarMazo();
        dealer.darCartas();
        dealer.imprimirManoJugador();
        dealer.imprimirMano();
        dealer.calcularPuntaje();
    }
}
