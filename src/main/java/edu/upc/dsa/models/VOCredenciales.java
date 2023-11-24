package edu.upc.dsa.models;

public class VOCredenciales {
    private String mail;
    private String password;
    public VOCredenciales(){}

    public VOCredenciales(String mail, String password) {
        this.setMail(mail);
        this.setPassword(password);
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
