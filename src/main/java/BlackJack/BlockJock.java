package BlackJack;
import java.util.Scanner;
public class BlockJock {
    public void Jugar() {
        String nombreDeal = "Kurona";
        System.out.println("Su dealer sera "+ nombreDeal);

        Dealer dealer = new Dealer(nombreDeal);
        dealer.CrearMazito();
        dealer.setPlayers();
        dealer.mezclarMazo();
        dealer.darCartas();
        dealer.imprimirManoJugador();
        dealer.imprimirMano();
        dealer.calcularPuntaje();
    }
}
