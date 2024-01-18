package edu.upc.dsa.models;

public class Backpack {
    String idUsuario;
    int idItems;
    public Backpack(){};


    public Backpack(String idUsuario, int idItems) {
        this.idUsuario = idUsuario;
        this.idItems = idItems;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdItems() {
        return idItems;
    }

    public void setIdItems(int idItems) {
        this.idItems = idItems;
    }
}
