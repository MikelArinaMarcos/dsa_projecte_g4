package edu.upc.dsa.models;

public class Objeto {
    String Nombre;
    int Precio;
    int Daño;

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
