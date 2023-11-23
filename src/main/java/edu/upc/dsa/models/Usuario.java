package edu.upc.dsa.models;

public class Usuario {
    private String Username;
    private String Mail;
    private String Name;
    private String LastName;
    private String Password;

    public Usuario(String username, String mail, String name, String lastName, String password) {
        Username = username;
        Mail = mail;
        Name = name;
        LastName = lastName;
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
