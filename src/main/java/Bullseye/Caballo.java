package Bullseye;

public class Caballo {
        private String nombre;
        private String color;
        private int id;
        private int tiempo;

        public Caballo(String nombre,int ID, String color){
            this.nombre = nombre;
            this.color = color;
            this.id = id;
        }

        public void GetDatos(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Color: " + color);
        System.out.println("Id: " + id);
        }
        public void setTiempo() {
            this.tiempo = (int) (Math.random() * 20 + 1);
        }
        public int getTiempo(){
            return tiempo;
        }
        public int getId(){
        return id;
        }
        public String getNombre(){
        return nombre;}
        public String getColor(){
            return color;
        }

}
