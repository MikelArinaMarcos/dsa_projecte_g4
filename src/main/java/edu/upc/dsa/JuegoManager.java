package edu.upc.dsa;

import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.VOCredenciales;

import java.util.HashMap;
import java.util.List;
public interface JuegoManager {
    public Usuario RegistrarUsuario(String mail, String username, String password);
    public Usuario LogIn(VOCredenciales credencialesu);
    public VOCredenciales getCredenciales(Usuario U);
    public String getUsername(VOCredenciales Credenciales);
    public HashMap<VOCredenciales, Usuario> getallusers();

    //Update
    public int size();
    public Usuario addUser(String  mail, String username, String password);
    public Usuario addUser(Usuario u);
    public Usuario getUser (String id);
    public List<Usuario> findAll();
    public Usuario deleteUser(String id);
    public Usuario updateUser(Usuario u);
    public Usuario authentification(String mail, String password);
}
