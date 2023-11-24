package edu.upc.dsa;

import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.VOCredenciales;

import java.util.HashMap;
import java.util.List;
public interface JuegoManager {
    public int addUsuario(String username, String mail, String name, String lastName, String password);
    public int registrarUsuario(Usuario u);
    public Usuario LogIn(VOCredenciales credencialesu);
    public VOCredenciales getCredenciales(Usuario U);
    public Usuario getUser(VOCredenciales Credenciales);
    public List<Usuario> getallusers();
    public int sizeusers();
    public Usuario deleteUsuario(VOCredenciales credenciales);
}
