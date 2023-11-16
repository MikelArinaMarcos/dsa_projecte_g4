package edu.upc.dsa.models;

public class Objeto {
    private String Nombre;
    private int Precio;
    private int Daño;

    public Objeto(){}
    public Objeto(String nombre, int precio, int daño){
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setDaño(daño);
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    public int getDaño() {
        return Daño;
    }

    public void setDaño(int daño) {
        Daño = daño;
    }
}
