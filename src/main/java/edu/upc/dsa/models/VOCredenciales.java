package edu.upc.dsa.models;

public class VOCredenciales {
    private String mail;
    private String password;
<<<<<<< HEAD

    public VOCredenciales(){}

    public VOCredenciales(String username, String password) {
        this.setMail(mail);
        this.setPassword(password);
=======
    public VOCredenciales(){}
    public VOCredenciales(String mail, String password) {
        this.mail = mail;
        this.password = password;
>>>>>>> 54dbfb67f107444cc37fc18782cdc9a37fbc6e69
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
