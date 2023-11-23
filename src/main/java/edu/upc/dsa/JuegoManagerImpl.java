package edu.upc.dsa;

import edu.upc.dsa.models.Personaje;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.VOCredenciales;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
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
    public Usuario addUsuario(String username, String mail, String name, String lastName, String password){
        Usuario u=new Usuario(username, mail, name, lastName, password);
        VOCredenciales VOC=new VOCredenciales(username, password);
        logger.info("new user"+u);
        this.LUsuarios.put(VOC,u);
        logger.info("new user added");
        return u;
    }
    public int RegistrarUsuario(Usuario usuarios){
        Usuario U=new Usuario(usuarios.getUsername(),usuarios.getMail(),usuarios.getName(),usuarios.getLastName(),usuarios.getPassword());
        VOCredenciales VOC=new VOCredenciales(usuarios.getUsername(),usuarios.getPassword());
        for (HashMap.Entry<VOCredenciales, Usuario> entry : LUsuarios.entrySet()) {
            if (U.getMail().equals(LUsuarios.get(entry.getKey()).getMail())){
                return 1;
            }
            if (U.getUsername().equals(LUsuarios.get(entry.getKey()).getUsername())){
                return 2;
            }
        }
        logger.info("new user"+U);
        this.LUsuarios.put(VOC,U);
        logger.info("new user added");
        return 0;
    }
    @Override
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
    public Usuario getUser(VOCredenciales credenciales){
        logger.info("getUsername("+credenciales+")");

        logger.info("login(" + credenciales +")");
        if (LUsuarios.containsKey(credenciales)){
            Usuario U= LUsuarios.get(credenciales);
            logger.info("LogIn("+credenciales+")"+U);
            return U;
        }
        logger.warn(credenciales+"not found");
        return null;
    }
    public HashMap<VOCredenciales, Usuario> getallusers() {
        return this.LUsuarios;
    }
    @Override
    public Usuario deleteUsuario(VOCredenciales credenciales) {
        logger.info("deleteUsuario(" + credenciales +")");
        if (LUsuarios.containsKey(credenciales)){
            Usuario U= LUsuarios.get(credenciales);
            LUsuarios.remove(credenciales);
            logger.info("deleteUsuario("+credenciales+")"+U);
            return U;
        }
        logger.warn(credenciales+"not found");
        return null;
    }
}
