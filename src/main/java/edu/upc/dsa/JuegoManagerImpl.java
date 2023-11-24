package edu.upc.dsa;

import edu.upc.dsa.models.Personaje;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.VOCredenciales;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class JuegoManagerImpl implements JuegoManager{
    private static JuegoManager instance;
    protected List<Usuario> Usuarios;
    protected HashMap<String, Usuario> LUsuarios = new HashMap<String, Usuario>();
    private JuegoManagerImpl(){this.LUsuarios = new LinkedHashMap<>();}
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
        logger.info("new user"+u);
        this.LUsuarios.put(u.getMail(),u);
        logger.info("new user added");
        return u;
    }
    public int RegistrarUsuario(Usuario usuarios){
        Usuario U=new Usuario(usuarios.getUsername(),usuarios.getMail(),usuarios.getName(),usuarios.getLastname(),usuarios.getPassword());
        for (HashMap.Entry<String, Usuario> entry : LUsuarios.entrySet()) {
            if (U.getMail().equals(LUsuarios.get(entry.getKey()).getMail())){
                return 1;
            }
            if (U.getUsername().equals(LUsuarios.get(entry.getKey()).getUsername())){
                return 2;
            }
        }
        logger.info("new user"+U);
        this.LUsuarios.put(U.getMail(),U);
        logger.info("new user added");
        return 0;
    }
    @Override
    public Usuario LogIn(VOCredenciales credenciales) {
        logger.info("login(" + credenciales +")");
        if (LUsuarios.containsKey(credenciales)){
            Usuario U= LUsuarios.get(credenciales.getMail());
            logger.info("LogIn("+credenciales+")"+U);
            return U;
        }
        logger.warn(credenciales+"not found");
        return null;
    }
    public VOCredenciales getCredenciales(Usuario U){
        logger.info("getCredenciales("+U+")");
        VOCredenciales VOC=new VOCredenciales(U.getMail(),U.getPassword());
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
    public HashMap<String, Usuario> getallusers() {
        return this.LUsuarios;
    }
    @Override
    public Usuario deleteUsuario(VOCredenciales credenciales) {
        logger.info("deleteUsuario(" + credenciales +")");
        if (LUsuarios.containsKey(credenciales.getMail())){
            Usuario U= LUsuarios.get(credenciales.getMail());
            LUsuarios.remove(credenciales.getMail());
            logger.info("deleteUsuario("+credenciales.getMail()+")"+U);
            return U;
        }
        logger.warn(credenciales+"not found");
        return null;
    }
}
