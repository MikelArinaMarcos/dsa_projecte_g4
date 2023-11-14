package edu.upc.dsa;

import edu.upc.dsa.models.Usuario;
import org.apache.log4j.Logger;

import java.util.List;

public class JuegoManagerImpl implements JuegoManager{
    private static JuegoManager instance;
    protected List<Usuario> Usuarios;
    final static Logger logger = Logger.getLogger(JuegoManagerImpl.class);
    public  static JuegoManager getInstance(){
        if (instance==null) instance = new JuegoManagerImpl();
        return instance;
    }
    public int size() {
        int ret = this.Usuarios.size();
        logger.info("size " + ret);

        return ret;
    }
    public Usuario RegistrarUsuario(String Username, String Password, String Name, String Lastname, String Mail){
    Usuario U=new Usuario(Username,Password,Name,Lastname,Mail);
    logger.info("new user"+U);
    this.Usuarios.add(U);
    logger.info("new user added");
    return U;
    }
    public Usuario LogIn(String Username, String Password) {
        logger.info("login(" + Username + "," + Password + ")");
        for (Usuario U : this.Usuarios) {
            if (U.getUsername().equals(Username)) {
                if (U.getPassword().equals(Password)) {
                    logger.info("login(" + Username + "," + Password + ")" + U);
                    return U;
                } else {
                    logger.info("wrong password");
                }
            }
        }
        logger.warn(Username+"not found");
        return null;
    }
}
