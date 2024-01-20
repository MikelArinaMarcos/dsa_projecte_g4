package edu.upc.dsa;

import edu.upc.dsa.exceptions.NotInInventoryException;
import edu.upc.dsa.models.*;

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
    public int comprobarUnico(Usuario u);

    public Usuario actualizarUsuario(String mail, String newUsername, String newName, String newLastName, String newPassword, String newMail);

    public void addInsignias(List<Insignia> i, String username);
    public List<Insignia> getInsignias(String username) throws NotInInventoryException;

    List<Mensaje> getMensajesGenerales();

    public void addMensajesGenerales(List<Mensaje> mensajes);
    public Mapas getMap(int idMapas);
    public List<Objeto> getMyBackpack(String mail);

    }
