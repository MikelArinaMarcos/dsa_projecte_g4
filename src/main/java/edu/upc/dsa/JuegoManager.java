package edu.upc.dsa;

import edu.upc.dsa.models.Insignia;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.VOCredenciales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public interface JuegoManager {
    public int addUsuario(String username, String mail, String name, String lastName, String password);
    public int registrarUsuario(Usuario u);
    public Usuario login(VOCredenciales credencialesu);
    public VOCredenciales getCredenciales(Usuario U);
    public Usuario getUser(String mail);
    public List<Usuario> getallusers();
    public int sizeUsers();
    public int deleteUsuario(VOCredenciales credenciales);

    public Usuario actualizarUsuario(String mail, String newUsername, String newName, String newLastName, String newPassword, String newMail);

    public ArrayList<Insignia> getInsignias(String id);
    public void addInsignias(List<Insignia> i, String id);

    }
