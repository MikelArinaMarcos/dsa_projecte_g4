package edu.upc.dsa.DAO;

import edu.upc.dsa.models.*;
import edu.upc.dsa.DAO.UsuarioDAOImpl;
import edu.upc.dsa.exceptions.ObjectNotExistException;
import edu.upc.dsa.exceptions.NotSufficientMoneyException;
import edu.upc.dsa.exceptions.EmailNotValidException;
import edu.upc.dsa.exceptions.IncorrectCredencialsException;
import edu.upc.dsa.exceptions.NameUserAlreadyInUseException;

import java.util.List;
import java.sql.SQLException;


public interface UsuarioDAO {

    public int addUser(String username, String mail, String name, String lastName, String password, int bolivares);

    public Usuario getUserbymail(String mail);

    /*public Usuario getUsuarioPorEmail(String mail)*/

    public List<Usuario> getUsuarios();
    public Mapas getMapas(int idMapa);
    public Usuario updateUsuario(Usuario u1, String mail);
    int deleteUsuario(Usuario u1, String mail);
    public List<Backpack> getObjetosBackpack(String mail);

    List<Insignia> getInsignia(String username);
}
