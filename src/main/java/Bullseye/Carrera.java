package Bullseye;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Carrera {
    private JugadorBulls jugadorBulls;
    private ArrayList<Caballo> caballos = new ArrayList<>();
    private ArrayList<JugadorBulls> jugadoresBulls = new ArrayList<>();
    private Caballo caballoganador;

    public Carrera(JugadorBulls jugadorBulls) {
        this.jugadorBulls = jugadorBulls;
    }

    public void AñadirCaballos() {
        Caballo caballo1 = new Caballo("Epona", 0, "Bronce");
        caballos.add(caballo1);
        Caballo caballo2 = new Caballo("Agro", 1, "Negro");
        caballos.add(caballo2);
        Caballo caballo3 = new Caballo("Pegaso", 2, "Blanco");
        caballos.add(caballo3);
        Caballo caballo4 = new Caballo("Sardinilla", 3, "Cafe");
        caballos.add(caballo4);
        Caballo caballo5 = new Caballo("Calus", 4, "Marron");
        caballos.add(caballo5);
        Caballo caballo6 = new Caballo("Spirit", 5, "Anaranjado");
        caballos.add(caballo6);
    }
    public void Botbulls() {
        Random random = new Random();

        JugadorBulls botbulls1 = new JugadorBulls("Huevito Rey");
        botbulls1.SetNumero((int)(Math.random()*5));

        JugadorBulls botbulls2 = new JugadorBulls("Tio Rene");
        botbulls2.SetNumero((int)(Math.random()*5));

        JugadorBulls botbulls3 = new JugadorBulls("Papi Miki");
        botbulls3.SetNumero((int)(Math.random()*5));

        JugadorBulls botbulls4 = new JugadorBulls("Goku");
        botbulls4.SetNumero((int)(Math.random()*5));

        JugadorBulls botbulls5 = new JugadorBulls("Vendedor de leña");
        botbulls5.SetNumero((int)(Math.random()*5));

        jugadoresBulls.add(botbulls1);
        jugadoresBulls.add(botbulls2);
        jugadoresBulls.add(botbulls3);
        jugadoresBulls.add(botbulls4);
        jugadoresBulls.add(botbulls5);

        System.out.println((int)(Math.random()*5));
    }
    public void DarNumRAndomCaballos() {
        for (int i = 0; i < caballos.size(); i++) {
            caballos.get(i).setTiempo();
        }
    }
    public void DarNumJugador(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Eliga el numero del caballo por el que va a apostar del 0 al 5");
        int num = teclado.nextInt();

        jugadorBulls.SetNumero(num);
    }

    public int ElegirMontoApuesta() {
        int monto = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("ELiga monto que va a apostar");
        System.out.println("[1]500");
        System.out.println("[2]1000");
        System.out.println("[3]5000");
        System.out.println("[4]10000");
        System.out.println("[5]25000");
        System.out.println("[6]50000");
        int opcion = teclado.nextInt();
        switch (opcion) {
            case 1:
                monto = 500;
                break;
            case 2:
                monto = 1000;
                break;
            case 3:
                monto = 5000;
                break;
            case 4:
                monto = 10000;
                break;
            case 5:
                monto = 25000;
                break;
            case 6:
                monto = 50000;
        }
        return monto;
    }
    public int multiplicadorMonto(int opcion){
        int[] multiplicadores ={2,3,4,5,7,10};
        return multiplicadores[opcion-1];
    }
    public void ImprimirDatosCaballoganador(){
        System.out.println("El caballo ganador fue: ");
        caballoganador.GetDatos();
    }
    public void ElegirCaballoGanador(){
        caballoganador = caballos.get(0);

        for (int i = 0; i <caballos.size() ; i++) {
            if (caballos.get(i).getTiempo() > caballoganador.getTiempo()){
                caballoganador = caballos.get(i);
            }
        }
    }
    public void ResultadoJugador(int apuesta){
        int montoGanado;
        if (jugadorBulls.GetNumero() == caballoganador.getId()){
            montoGanado = multiplicadorMonto(apuesta);
            System.out.println("jugador " + jugadorBulls.GetNombre() + " gano: " + montoGanado);
        }else{
            montoGanado = (-apuesta);
            System.out.println("jugador " + jugadorBulls.GetNombre() + " perdio: " + montoGanado);
        }
        jugadorBulls.setMonto(montoGanado);

        System.out.println("Usted tiene: " + jugadorBulls.GetMonto() + " pesos");
    }
    public void ResultadoBots(){
        for (int i = 0; i < jugadoresBulls.size(); i++) {
            if (jugadoresBulls.get(i).GetNumero() == caballoganador.getId()){
                System.out.println("jugador " + jugadoresBulls.get(i).GetNombre() + " gano");
            }else{
                System.out.println("jugador " + jugadoresBulls.get(i).GetNombre() + " perdio");
            }
        }
    }
    public void MostrarCaballos() {
        for (Caballo caballo : caballos) {
            System.out.println(caballo.getId() + ".- " + caballo.getNombre() + " (" + caballo.getColor() + ")");
        }
    }

    public void Jugar(){
        AñadirCaballos();
        DarNumRAndomCaballos();
        MostrarCaballos();
        DarNumJugador();

        int apuesta = ElegirMontoApuesta();
        
        ElegirCaballoGanador();
        ImprimirDatosCaballoganador();
        System.out.println();
        ResultadoJugador(apuesta);

        Botbulls();
        ResultadoBots();
    }


}
