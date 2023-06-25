package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Dealer {
    private JugadorBlack player1;
    private ArrayList<JugadorBlack> Jugadores = new ArrayList<JugadorBlack>();
    private ArrayList<Carta> mazo = new ArrayList<Carta>();
    private ArrayList<Carta> mano = new ArrayList<Carta>();

    public void setPlayers() {

        JugadorBlack player = new JugadorBlack(player1.getNombre());
        Jugadores.add(player);
    }

    public Dealer(String nombre) {
        player1 = new JugadorBlack(nombre);

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
        for (int i = 0; i < Jugadores.size(); i++) {
            Jugadores.get(i).setMano(mazo.get(0));
            mazo.remove(0);
            Jugadores.get(i).setMano(mazo.get(0));
            mazo.remove(0);
            Jugadores.get(i).setMano(mazo.get(0));
            mazo.remove(0);

            Jugadores.get(i).setPuntaje();
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

        for (int i = 0; i < Jugadores.size(); i++) {
            int puntajeJugador = Jugadores.get(i).getPuntaje();

            if (puntajeJugador > 21 && puntajeDealer > 21) {
                System.out.println( " Ninguno de los 2 tiene suerte jaj");
            } else if (puntajeJugador > 21) {
                System.out.println("El jugador: " + Jugadores.get(i).getNombre() + " Perdió, hermano la mala cuea");
            } else if (puntajeJugador <= 21 && puntajeJugador > puntajeDealer) {
                System.out.println("El jugador: " + Jugadores.get(i).getNombre() + " Ganó, HERMANO FELICIDADES PUEDES DEJAR LA CARRERA");
            } else if (puntajeDealer > 21) {
                System.out.println("El jugador: " + Jugadores.get(i).getNombre() + " Ganó, HERMANO FELICIDADES PUEDES DEJAR LA CARRERA");
            } else if (puntajeDealer <= 21 && puntajeDealer > puntajeJugador) {
                System.out.println("El jugador: " + Jugadores.get(i).getNombre() + " Perdió, hermano como te gana el dealer ");
            } else if (puntajeDealer <= 21 && puntajeDealer < puntajeJugador) {
                System.out.println("El jugador: " + Jugadores.get(i).getNombre() + " Perdió, hermano como te gana el dealer ");
            } else if (puntajeDealer <= 21 && puntajeDealer == puntajeJugador) {
                System.out.println("El jugador: " + Jugadores.get(i).getNombre() + " Empate, Los 2 igual de giles");
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
        for (JugadorBlack jugador1 : Jugadores) {
            jugador1.imprimirManoJ();
        }
    }
    public void volverAJugar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Volver A Jugar? (S/N)");
        System.out.println("");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("S")) {
            Jugar();
        } else {
            System.exit(0);
        }
    }
    public void limpiarManos() {
        Jugadores.clear();
        mano.clear();
    }

    public void Jugar() {

        CrearMazito();
        setPlayers();
        mezclarMazo();
        darCartas();
        imprimirManoJugador();
        imprimirMano();
        calcularPuntaje();
        limpiarManos();
        volverAJugar();
    }
}
