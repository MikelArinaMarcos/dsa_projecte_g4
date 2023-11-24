package edu.upc.dsa.models;

public class Usuario {
    private String username;
    private String mail;
    private String name;
<<<<<<< HEAD
    private String lastName;
    private String password;

    public Usuario(){}
=======
    private String lastname;
    private String password;
>>>>>>> 54dbfb67f107444cc37fc18782cdc9a37fbc6e69

    public Usuario(){}
    public Usuario(String username, String mail, String name, String lastName, String password) {
        this.username = username;
        this.mail = mail;
        this.name = name;
<<<<<<< HEAD
        this.lastName = lastName;
=======
        lastname = lastName;
>>>>>>> 54dbfb67f107444cc37fc18782cdc9a37fbc6e69
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

<<<<<<< HEAD
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
=======
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
>>>>>>> 54dbfb67f107444cc37fc18782cdc9a37fbc6e69
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
