package edu.upc.dsa;

import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.VOCredenciales;

import java.util.HashMap;
import java.util.List;
public interface JuegoManager {
    public Usuario RegistrarUsuario(String Username, String Mail, String Name, String Lastname, String Password);
    public Usuario LogIn(VOCredenciales credencialesu);
    public VOCredenciales getCredenciales(Usuario U);
    public String getUsername(VOCredenciales Credenciales);
    public HashMap<VOCredenciales, Usuario> getallusers();
}
