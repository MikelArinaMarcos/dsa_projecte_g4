package edu.upc.dsa.models;

public class Personaje {
    private int Vida;
    private int Alimento;

    public Personaje(int vida, int alimento) {
        Vida = vida;
        Alimento = alimento;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int vida) {
        Vida = vida;
    }

    public int getAlimento() {
        return Alimento;
    }

    public void setAlimento(int alimento) {
        Alimento = alimento;
    }
}
