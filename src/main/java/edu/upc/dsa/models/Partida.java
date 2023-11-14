package edu.upc.dsa.models;

public class Partida {
    private String Id;
    private String Dificultad;
    private int Duración;

    public Partida(String id, String dificultad, int duración) {
        Id = id;
        Dificultad = dificultad;
        Duración = duración;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDificultad() {
        return Dificultad;
    }

    public void setDificultad(String dificultad) {
        Dificultad = dificultad;
    }

    public int getDuración() {
        return Duración;
    }

    public void setDuración(int duración) {
        Duración = duración;
    }
}
