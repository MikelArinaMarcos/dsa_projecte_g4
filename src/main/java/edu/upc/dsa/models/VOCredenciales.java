package edu.upc.dsa.models;

import edu.upc.dsa.Main;

public class VOCredenciales {
    private String Mail;
    private String Password;

    public VOCredenciales(String mail, String password) {
        Mail = mail;
        Password = password;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


}
