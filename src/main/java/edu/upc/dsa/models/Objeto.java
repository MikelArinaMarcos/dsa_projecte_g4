package edu.upc.dsa.models;

public class Objeto {
    int id;
    int rareza;
    private String Nombre;
    private int Precio;
    private int Daño;

    public Objeto(){}
    public Objeto(int id, int rareza, String nombre, int precio, int daño){
        this.setId(id);
        this.setRareza(rareza);
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setDaño(daño);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRareza() {
        return rareza;
    }

    public void setRareza(int rareza) {
        this.rareza = rareza;
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