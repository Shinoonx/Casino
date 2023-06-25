package Bullseye;

import Casino.Casino;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Carrera {

    private List<Caballo> caballos = new ArrayList<>();
    private List<JugadorBulls> jugadores = new ArrayList<>();
    private JugadorBulls jugador1;
    private int dinero = 50000;
    private int dineroApostado;

    public Carrera(String nombre) {
        jugador1 = new JugadorBulls(nombre);
        jugadores();
    }

    public void caballos() {
        Caballo caballo1 = new Caballo("Epona", 1, "Bronce");
        caballos.add(caballo1);
        Caballo caballo2 = new Caballo("Agro", 2, "Negro");
        caballos.add(caballo2);
        Caballo caballo3 = new Caballo("Pegaso", 3, "Blanco");
        caballos.add(caballo3);
        Caballo caballo4 = new Caballo("Sardinilla", 4, "Cafe");
        caballos.add(caballo4);
        Caballo caballo5 = new Caballo("Calus", 5, "Marron");
        caballos.add(caballo5);
        Caballo caballo6 = new Caballo("Spirit", 6, "Anaranjado");
        caballos.add(caballo6);
    }


    public void jugadores() {
        jugador1 = new JugadorBulls(jugador1.getNombre());
        jugadores.add(jugador1);
        JugadorBulls bot1 = new JugadorBulls("Vendedor de Madera");
        JugadorBulls bot2 = new JugadorBulls("Papi Miki");
        JugadorBulls bot3 = new JugadorBulls("Goku");
        JugadorBulls bot4 = new JugadorBulls("Tio Rene");
        JugadorBulls bot5 = new JugadorBulls("Vendedor de Leña");


        jugadores.add(bot1);
        jugadores.add(bot2);
        jugadores.add(bot3);
        jugadores.add(bot4);
        jugadores.add(bot5);
    }

    public void seleccionarCaballo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un Caballo");

        int opcion = scanner.nextInt();
        Caballo caballoSeleccionado = caballos.get(opcion - 1);

        jugador1.asignarCaballo(caballoSeleccionado);

        Random random = new Random();
        for (JugadorBulls jugador : jugadores) {
            if (jugador != jugador1) {
                int index = random.nextInt(caballos.size());
                Caballo caballoAsignado = caballos.get(index);
                jugador.asignarCaballo(caballoAsignado);
            }
        }
    }

    public void iniciarCarrera() {

        Scanner scanner = new Scanner(System.in);
        caballos();
        BienvenidaBulls();
        MostrarParticipantes();
        while (true) {
            hud();
            seleccionarCaballo();

            System.out.println("-------------------------------------------------------------------");
            System.out.println("Selecciona el monto para apostar:");
            System.out.println("1. $500");
            System.out.println("2. $1000");
            System.out.println("3. $5000");
            System.out.println("4. $10000");
            System.out.println("5. $25000");
            System.out.println("6. $50000");
            System.out.println("7. Salir");

            int opcion = scanner.nextInt();

            if (opcion == 7) {
                break;
            }
            int monto = obtenerMonto(opcion);
            if (monto > dinero) {
                System.out.println("No tienes suficiente dinero para apostar");
                continue;
            }
            dineroApostado = monto;
            dinero -= dineroApostado;

            System.out.println("Has apostado: $" + dineroApostado + " por " + jugador1.getCaballoAsignado().getNameHorse());
            System.out.println("");
            System.out.println("");
            System.out.println("Empieza la carrera");

            int[] tiempos = generarTiempos();

            System.out.println("");
            System.out.println("--------------------------[Resultados de la carrera]------------------------");
            for (int i = 0; i < jugadores.size(); i++) {
                JugadorBulls jugador = jugadores.get(i);
                Caballo caballo = jugador.getCaballoAsignado();
                int tiempo = tiempos[i];

                System.out.println(jugador.getnombre() + " - " + caballo.getNameHorse() + " (" + caballo.getColor() + "): " + tiempo + " segundos");
            }
            System.out.println("");
            System.out.println("");
            System.out.println("--------------------------[GANADOR!!!]------------------------");
            int tiempoGanador = obtenerGanador(tiempos);
            JugadorBulls jugadorGanador = jugadores.get(tiempoGanador);
            Caballo caballoGanador = jugadorGanador.getCaballoAsignado();
            System.out.println("");
            System.out.println(jugadorGanador.getnombre() + " - " + caballoGanador.getNameHorse() + " (" + caballoGanador.getColor() + ")");

            if (jugadorGanador == jugador1){
                int premio = obtenerPremio(opcion);
                dinero += dineroApostado * premio;
                System.out.println("¡Felicidades! Has ganado $" + (dineroApostado * premio));
            } else {
                System.out.println("Lo siento, has perdido.");
                System.out.println("");
                System.out.println("Dinero actual: $" + dinero);
                dineroApostado = 0;
                if (dinero < 0){
                    System.out.println("Te has quedado sin dinero. El juego ha terminado");
                    break;
                }
            }
            continuarJugando();
            System.out.println("");
            System.out.println("Gracias por jugar");
            System.out.println("-------------------------------------------------------------------");
        }
    }

    public int obtenerMonto(int opcion) {
        int[] montos = {500, 1000, 5000, 10000, 25000, 50000};
        return montos[opcion - 1];
    }

    public int[] generarTiempos() {
        Random random = new Random();
        int[] tiempos = new int[jugadores.size()];

        for (int i = 0; i < tiempos.length; i++) {
            tiempos[i] = random.nextInt(8) + 4;
        }
        return tiempos;
    }

    public int obtenerGanador(int[] tiempos) {
        int ganador = 0;

        for (int i = 1; i < tiempos.length; i++) {
            if (tiempos[i] < tiempos[ganador]) {
                ganador = i;
            }
        }
        return ganador;
    }

    public int obtenerPremio(int opcion){
        int[] multiplicadores ={2,3,4,5,7,10};
        return multiplicadores[opcion-1];
    }
    public void hud(){
        System.out.println("-------------------------------" + "Jugador: " + jugador1.getnombre() + "----------------------------");
        System.out.println("Monto actual: $" + dinero);
        System.out.println("");
        System.out.println("Caballos disponibles para apostar:");

        for (Caballo caballo : caballos) {
            System.out.println(caballo.getID() + ". " + caballo.getNameHorse() + " (" + caballo.getColor() + ")");
        }
    }
    public void BienvenidaBulls(){
        System.out.println("----------------------------" + "Bienvenido a Bullseye" + "----------------------------");
        System.out.println("Jugador: " + jugador1.getnombre());
        System.out.println("");
    }
    public void MostrarParticipantes(){
        System.out.println("Participantes: ");
        for (int i = 0; i < jugadores.size(); i++) {
            JugadorBulls jugador = jugadores.get(i);
            if (jugador != null) {
                System.out.println("-" + jugador.getnombre());
            }
        }
        System.out.println("");
    }
    public void continuarJugando() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Deseas seguir jugando? (S/N)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("S")) {
            iniciarCarrera();
        } else
            System.exit(0);
    }
}
