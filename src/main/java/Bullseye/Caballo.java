package Bullseye;

public class Caballo {
    private String NameHorse;
    private int ID;
    private String Color;

    public Caballo(String nameHorse,int ID, String color){
        this.NameHorse = nameHorse;
        this.ID = ID;
        this.Color = color;
    }

    public int getID() {
        return ID;
    }

    public String getColor() {
        return Color;
    }

    public String getNameHorse() {
        return NameHorse;
    }
}


