package edu.upc.dsa;

import edu.upc.dsa.models.Personaje;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.VOCredenciales;
import org.apache.log4j.Logger;

import java.util.HashMap;
<<<<<<< HEAD
=======
import java.util.LinkedHashMap;
>>>>>>> 54dbfb67f107444cc37fc18782cdc9a37fbc6e69
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JuegoManagerImpl implements JuegoManager{
    private static JuegoManager instance;
    protected List<Usuario> Usuarios;
<<<<<<< HEAD
    protected HashMap<String, Usuario> lUsuarios = new HashMap<String, Usuario>();
=======
    protected HashMap<String, Usuario> LUsuarios = new HashMap<String, Usuario>();
    private JuegoManagerImpl(){this.LUsuarios = new LinkedHashMap<>();}
>>>>>>> 54dbfb67f107444cc37fc18782cdc9a37fbc6e69
    protected List<Personaje> Personajes;
    final static Logger logger = Logger.getLogger(JuegoManagerImpl.class);
    public  static JuegoManager getInstance(){
        if (instance==null) instance = new JuegoManagerImpl();
        return instance;
    }
    public int sizeusers(){
        int ret = this.lUsuarios.size();
        logger.info("size " + ret);

        return ret;
    }
    public int partidassize() {
        int ret = this.Personajes.size();
        logger.info("size " + ret);

        return ret;
    }
    public int addUsuario(String username, String mail, String name, String lastName, String password){
        Usuario u=new Usuario(username, mail, name, lastName, password);
<<<<<<< HEAD
        if (lUsuarios.containsKey(mail)){
            logger.info("Mail ya en uso");
            return 1;
        }
        for(Map.Entry<String, Usuario> e : lUsuarios.entrySet()){
            if(e.getValue().getName() == username)
                return 2;
        }
        logger.info("new user "+u.getName());
        this.lUsuarios.put(u.getMail(),u);
        logger.info("new user added");
        return 0;
    }
    public int registrarUsuario(Usuario u){
        if (lUsuarios.containsKey(u.getMail())){
            logger.info("Mail ya en uso");
            return 1;
        }
        for(Map.Entry<String, Usuario> e : lUsuarios.entrySet()){
            if(e.getValue().getName() == u.getUsername())
                return 2;
        }
        logger.info("new user "+u.getName());
        this.lUsuarios.put(u.getMail(),u);
=======
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
>>>>>>> 54dbfb67f107444cc37fc18782cdc9a37fbc6e69
        logger.info("new user added");
        return 0;
    }
    @Override
<<<<<<< HEAD
    public Usuario LogIn(VOCredenciales credencialesu) {
        logger.info("login(" + credencialesu +")");
        if (lUsuarios.containsKey(credencialesu.getMail())){
            Usuario U= lUsuarios.get(credencialesu.getMail());
            logger.info("LogIn("+credencialesu.getMail()+")"+U.getUsername());
=======
    public Usuario LogIn(VOCredenciales credenciales) {
        logger.info("login(" + credenciales +")");
        if (LUsuarios.containsKey(credenciales)){
            Usuario U= LUsuarios.get(credenciales.getMail());
            logger.info("LogIn("+credenciales+")"+U);
>>>>>>> 54dbfb67f107444cc37fc18782cdc9a37fbc6e69
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
        if (lUsuarios.containsKey(credenciales.getMail())){
            Usuario U= lUsuarios.get(credenciales.getMail());
            logger.info("LogIn("+credenciales+")"+U);
            return U;
        }
        logger.warn(credenciales+"not found");
        return null;
    }
<<<<<<< HEAD
    public List<Usuario> getallusers() {
        return this.lUsuarios.values().stream().collect(Collectors.toList());
=======
    public HashMap<String, Usuario> getallusers() {
        return this.LUsuarios;
>>>>>>> 54dbfb67f107444cc37fc18782cdc9a37fbc6e69
    }
    @Override
    public Usuario deleteUsuario(VOCredenciales credenciales) {
        logger.info("deleteUsuario(" + credenciales +")");
<<<<<<< HEAD
        if (lUsuarios.containsKey(credenciales)){
            Usuario U= lUsuarios.get(credenciales);
            lUsuarios.remove(credenciales);
            logger.info("deleteUsuario("+credenciales+")"+U);
=======
        if (LUsuarios.containsKey(credenciales.getMail())){
            Usuario U= LUsuarios.get(credenciales.getMail());
            LUsuarios.remove(credenciales.getMail());
            logger.info("deleteUsuario("+credenciales.getMail()+")"+U);
>>>>>>> 54dbfb67f107444cc37fc18782cdc9a37fbc6e69
            return U;
        }
        logger.warn(credenciales+"not found");
        return null;
    }
}
