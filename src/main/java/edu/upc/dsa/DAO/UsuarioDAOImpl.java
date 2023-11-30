package edu.upc.dsa.DAO;



import edu.upc.dsa.bbdd.FactorySesion;
import edu.upc.dsa.bbdd.Sesion;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;


import edu.upc.dsa.exceptions.EmailNotValidException;
import edu.upc.dsa.exceptions.IncorrectCredencialsException;
import edu.upc.dsa.exceptions.NameUserAlreadyInUseException;

public class UsuarioDAOImpl {

    final static Logger logger = Logger.getLogger(UsuarioDAOImpl.class);
    private static UsuarioDAOImpl instance;

    public static UsuarioDAOImpl getInstance() {
        if (instance==null) instance = new UsuarioDAOImpl();
        return instance;
    }

    public int addUser(String username, String mail, String name, String lastName, String password, int bolivares, List<Objeto> objetos) {
        Sesion sesion = null;
        int employeeID = 0;
        try {
            sesion = FactorySesion.open();
            Usuario user = new Usuario( username,mail , name, lastName , password,bolivares, objetos );
            sesion.save(user);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            sesion.close();
        }

        return employeeID;
    }
    public Usuario getUsuario(String mail) {
        Sesion sesion = null;
        Usuario user = null;
        try {
            sesion = FactorySesion.open();
            user = (Usuario) sesion.get(Usuario.class, mail);
        }
        catch (Exception e) {
            e.printStackTrace();
            // LOG
        }
        finally {
            sesion.close();
        }
        logger.info("identificador del usuario con mail: "+ user.getMail());
        return user;
    }













}
