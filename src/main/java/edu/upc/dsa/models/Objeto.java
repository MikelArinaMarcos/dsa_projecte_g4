package edu.upc.dsa.models;

public class Objeto {
    int id;
    int rareza;
    private String nombre;
    private int precio;
    private int damage;
    private String url;

    public Objeto(){}
    public Objeto(int id, int rareza, String nombre, int precio, int damage, String url){
        this.setId(id);
        this.setRareza(rareza);
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setDamage(damage);
        this.setUrl(url);
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
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}