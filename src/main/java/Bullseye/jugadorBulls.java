package Bullseye;

public class jugadorBulls {

    private String name;
    private int dinero;
    private Caballo caballoAsignado;

    public jugadorBulls(String name, int dinero) {
        this.name = name;
        this.dinero = dinero;
    }

    public String getName() {
        return name;
    }

    public int getDinero() {
        return dinero;
    }

    public Caballo getCaballoAsignado() {
        return caballoAsignado;
    }

    public void asignarCaballo(Caballo caballo) {
        caballoAsignado = caballo;
    }
}