package edu.upc.dsa.models;

import edu.upc.dsa.exceptions.NotSufficientMoneyException;

import java.util.*;

public class Usuario {
    private String username;
    private String mail;
    private String name;
    private String lastName;
    private String password;
    private int bolivares;
    //private List<Objeto> objetos;
    public Usuario() {}


    public Usuario(String username, String mail, String name, String lastName, String password) {
        this.setUsername(username);
        this.setMail(mail);
        this.setName(name);
        this.setLastName(lastName);
        this.setPassword(password);
        this.bolivares = 500;
       /*this.objetos = new List<Objeto>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Objeto> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Objeto objeto) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Objeto> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Objeto> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Objeto get(int index) {
                return null;
            }

            @Override
            public Objeto set(int index, Objeto element) {
                return null;
            }

            @Override
            public void add(int index, Objeto element) {

            }

            @Override
            public Objeto remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Objeto> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Objeto> listIterator(int index) {
                return null;
            }

            @Override
            public List<Objeto> subList(int fromIndex, int toIndex) {
                return null;
            }
        };*/

    }

    public Usuario(String username, String mail, String name, String lastName, String password, int bolivares) {
        this.setUsername(username);
        this.setMail(mail);
        this.setName(name);
        this.setLastName(lastName);
        this.setPassword(password);
        this.bolivares = 500;
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
/*
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

    public void adquirirObjeto(Objeto objeto) throws NotSufficientMoneyException {
        if(objeto.getPrecio()>this.bolivares){
            throw new NotSufficientMoneyException();
        }
        this.bolivares = this.bolivares - objeto.getPrecio();
    }
    public boolean tieneObjeto(Objeto o) {
        return this.objetos.stream().anyMatch(obj -> obj.getId() == o.getId());
    }

*/

}
