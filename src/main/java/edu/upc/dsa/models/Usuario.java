package edu.upc.dsa.models;

public class Usuario {
    private String username;
    private String mail;
    private String name;
    private String lastname;
    private String password;

    public Usuario(){}
    public Usuario(String username, String mail, String name, String lastName, String password) {
        this.username = username;
        this.mail = mail;
        this.name = name;
        lastname = lastName;
        this.password = password;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
