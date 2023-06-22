package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Dealer {

    private String nombre;
    private ArrayList<JugadorBlack> players = new ArrayList<JugadorBlack>();
    private ArrayList<Carta> mazo = new ArrayList<Carta>();
    private ArrayList<Carta> mano = new ArrayList<Carta>();

    public void setPlayers() {
        Scanner keyb = new Scanner(System.in);
        System.out.println("Nombre de Jugador");
        nombre = keyb.nextLine();
        JugadorBlack player = new JugadorBlack(nombre);
        players.add(player);
    }

    public Dealer(String nombre) {
        this.nombre = nombre;
    }

    public void CrearMazito() {
        Mazo mazito = new Mazo();
        mazito.Mazo();
        mazo = mazito.getCarta();
    }

    public void mezclarMazo() {
        Collections.shuffle(mazo);
    }

    public void darCartas() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setMano(mazo.get(0));
            mazo.remove(0);
            players.get(i).setMano(mazo.get(0));
            mazo.remove(0);
            players.get(i).setMano(mazo.get(0));
            mazo.remove(0);

            players.get(i).setPuntaje();
        }

        mano.add(mazo.get(0));
        mazo.remove(0);
        mano.add(mazo.get(0));
        mazo.remove(0);
        mano.add(mazo.get(0));
        mazo.remove(0);
    }

    public void calcularPuntaje() {
        int puntajeDealer = mano.get(0).getvalor() + mano.get(1).getvalor() + mano.get(2).getvalor();

        for (int i = 0; i < players.size(); i++) {
            int puntajeJugador = players.get(i).getPuntaje();

            if (puntajeJugador > 21 && puntajeDealer > 21) {
                System.out.println( " Ninguno de los 2 tiene suerte jaj");
            } else if (puntajeJugador > 21) {
                System.out.println("El jugador: " + players.get(i).getNombre() + " Perdió, hermano la mala cuea");
            } else if (puntajeJugador <= 21 && puntajeJugador > puntajeDealer) {
                System.out.println("El jugador: " + players.get(i).getNombre() + " Ganó, HERMANO FELICIDADES PUEDES DEJAR LA CARRERA");
            } else if (puntajeDealer > 21) {
                System.out.println("El jugador: " + players.get(i).getNombre() + " Ganó, HERMANO FELICIDADES PUEDES DEJAR LA CARRERA");
            } else if (puntajeDealer <= 21 && puntajeDealer > puntajeJugador) {
                System.out.println("El jugador: " + players.get(i).getNombre() + " Perdió, hermano como te gana el dealer ");
            } else if (puntajeDealer <= 21 && puntajeDealer < puntajeJugador) {
                System.out.println("El jugador: " + players.get(i).getNombre() + " Perdió, hermano como te gana el dealer ");
            } else if (puntajeDealer <= 21 && puntajeDealer == puntajeJugador) {
                System.out.println("El jugador: " + players.get(i).getNombre() + " Empate, Los 2 igual de giles");
            }
        }
    }
    public void imprimirMano() {
        System.out.println("Mano del Dealer:");
        for (Carta carta : mano) {
            System.out.println( carta.getvalor()+ " de " + carta.getsymb());
        }
    }
    public void imprimirManoJugador() {
        for (JugadorBlack jugador : players) {
            jugador.imprimirMano();
        }
    }
}