package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class Personaje {
    private int vida;
    private int bolivares;
    private int alimento;
    private List<Objeto> objetos;

    public Personaje(int vida, int alimento) {
        this.setVida(vida);
        this.setBolivares(100);
        this.setAlimento(alimento);
        this.inicializarObjetos();
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getBolivares() {
        return bolivares;
    }

    public void setBolivares(int bolivares) {
        this.bolivares = bolivares;
    }

    public int getAlimento() {
        return alimento;
    }

    public void setAlimento(int alimento) {
        this.alimento = alimento;
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<Objeto> objetos) {
        this.objetos = objetos;
    }

    public void addObjeto(Objeto o){
        this.objetos.add(o);
    }

    public void inicializarObjetos(){
        this.objetos = new LinkedList<Objeto>();
    }
}
