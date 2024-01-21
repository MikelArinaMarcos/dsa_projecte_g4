package edu.upc.dsa.models;

public class Enemigo {
    private int vida;
    private int damage;

    public Enemigo(int vida, int damage) {
        this.vida = vida;
        this.damage = damage;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
