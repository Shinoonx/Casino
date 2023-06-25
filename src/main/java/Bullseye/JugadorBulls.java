package Bullseye;

import Casino.Usuario;

public class JugadorBulls extends Usuario {
    private int dinero;
    private Caballo caballoAsignado;

    public JugadorBulls(String nombre) {
        super(nombre);
        this.dinero = dinero;
        this.nombre = nombre;
    }

    public Caballo getCaballoAsignado() {
        return caballoAsignado;
    }

    public void asignarCaballo(Caballo caballo) {
        caballoAsignado = caballo;
    }

    public String getnombre(){
        return nombre;
    }

}