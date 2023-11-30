package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
    private String username;
    private String mail;
    private String name;
    private String lastName;
    private String password;
    private int bolivares;
    private List<Objeto> objetos;
    public Usuario(){}

    public Usuario(String username, String mail, String name, String lastName, String password, int bolivares, List<Objeto> objetos) {
        this.setUsername(username);
        this.setMail(mail);
        this.setName(name);
        this.setLastName(lastName);
        this.setPassword(password);
        this.setBolivares(bolivares);
        this.setObjetos(objetos);
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBolivares() {
        return bolivares;
    }

    public void setBolivares(int bolivares) {
        this.bolivares = bolivares;
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<Objeto> objetos) {
        this.objetos = objetos;
    }
    public void iniObjetos(){
        this.objetos = new LinkedList<Objeto>();
    }
    public void addObjeto(Objeto o){
        this.objetos.add(o);
    }
}
