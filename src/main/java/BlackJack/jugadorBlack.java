package BlackJack;

import Casino.Usuario;
import com.sun.management.UnixOperatingSystemMXBean;

import java.util.ArrayList;

public class jugadorBlack extends Usuario {

    private int puntaje;
    private ArrayList<Carta> mano = new ArrayList<Carta>();



    public void setMano(Carta carta) {
        mano.add(carta);
    }

    public jugadorBlack(String usuario) {
        super(usuario);
        this.nombre = usuario;
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

    public void imprimirMano() {
        System.out.println("Mano de " + nombre + ":");
        for (Carta carta : mano) {
            System.out.println(carta.getvalor() + " de " + carta.getsymb());
        }
    }

}