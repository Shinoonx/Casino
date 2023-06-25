package BlackJack;

import Casino.Usuario;

import java.util.ArrayList;

public class JugadorBlack extends Usuario {

    private int puntaje;
    private ArrayList<Carta> mano = new ArrayList<Carta>();

    public JugadorBlack(String nombre) {
        super(nombre);
        this.nombre = nombre;
    }

    public void setMano(Carta carta) {
        mano.add(carta);
    }


    public String getNombre() {
        return nombre;
    }

    public void setPuntaje() {
        for (int i = 0; i < mano.size(); i++) {
            puntaje = puntaje + mano.get(1).getvalor();

        }
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void imprimirManoJ() {
        System.out.println("Mano de " + nombre + ":");
        for (Carta carta : mano) {
            System.out.println(carta.getvalor() + " de " + carta.getsymb());
        }
    }

}