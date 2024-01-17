package edu.upc.dsa.models;

public class Backpack {
    String idUsuario;
    String idObjetos;
    public Backpack(){};

    public Backpack(String idUsuario, String idObjetos) {
        this.idUsuario = idUsuario;
        this.idObjetos = idObjetos;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdObjetos() {
        return idObjetos;
    }

    public void setIdObjetos(String idObjetos) {
        this.idObjetos = idObjetos;
    }
}
