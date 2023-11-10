package edu.upc.dsa.models;

public class Enemigo {
    private int Vida;
    private int Damage;

    public Enemigo(int vida, int damage) {
        Vida = vida;
        Damage = damage;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int vida) {
        Vida = vida;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }
}
