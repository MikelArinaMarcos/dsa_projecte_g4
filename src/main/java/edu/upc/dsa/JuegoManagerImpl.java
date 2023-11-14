package edu.upc.dsa;

import edu.upc.dsa.models.Personaje;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.VOCredenciales;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;

public class JuegoManagerImpl implements JuegoManager{
    private static JuegoManager instance;
    protected List<Usuario> Usuarios;
    protected HashMap<VOCredenciales, Usuario> LUsuarios = new HashMap<VOCredenciales, Usuario>();
    protected List<Personaje> Personajes;
    final static Logger logger = Logger.getLogger(JuegoManagerImpl.class);
    public  static JuegoManager getInstance(){
        if (instance==null) instance = new JuegoManagerImpl();
        return instance;
    }
    public int sizeusers(){
        int ret = this.LUsuarios.size();
        logger.info("size " + ret);

        return ret;
    }
    public int partidassize() {
        int ret = this.Personajes.size();
        logger.info("size " + ret);

        return ret;
    }
    @Override
    public Usuario RegistrarUsuario(String Username, String Mail, String Name, String Lastname, String Password){
    Usuario U=new Usuario(Username,Mail,Name,Lastname,Password);
    VOCredenciales VOC=new VOCredenciales(Username,Password);
    logger.info("new user"+U);
    this.LUsuarios.put(VOC,U);
    logger.info("new user added");
    return U;
    }
    public Usuario LogIn(VOCredenciales credencialesu) {
        logger.info("login(" + credencialesu +")");
        if (LUsuarios.containsKey(credencialesu)){
            Usuario U= LUsuarios.get(credencialesu);
            logger.info("LogIn("+credencialesu+")"+U);
            return U;
        }
        logger.warn(credencialesu+"not found");
        return null;
    }
    public VOCredenciales getCredenciales(Usuario U){
        logger.info("getCredenciales("+U+")");
        VOCredenciales VOC=new VOCredenciales(U.getUsername(),U.getPassword());
        return VOC;
    }
    public String getUsername(VOCredenciales Credenciales){
        logger.info("getUsername("+Credenciales+")");

        logger.info("login(" + Credenciales +")");
        if (LUsuarios.containsKey(Credenciales)){
            Usuario U= LUsuarios.get(Credenciales);
            logger.info("LogIn("+Credenciales+")"+U);
            return U.getUsername();
        }
        logger.warn(Credenciales+"not found");
        return null;
    }
    public HashMap<VOCredenciales, Usuario> getallusers() {
        return this.LUsuarios;
    }


}
