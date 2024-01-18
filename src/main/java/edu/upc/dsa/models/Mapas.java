package edu.upc.dsa.models;

public class Mapas {
    int idMapa;
    String mapa;
    public Mapas(){};
    public Mapas(int idMapa, String mapa) {
        this.idMapa = idMapa;
        this.mapa = mapa;
    }

    public int getIdMapa() {
        return idMapa;
    }

    public void setIdMapa(int idMapa) {
        this.idMapa = idMapa;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }
}
