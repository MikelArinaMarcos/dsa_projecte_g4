package edu.upc.dsa;

import edu.upc.dsa.models.Personaje;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.VOCredenciales;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JuegoManagerImpl implements JuegoManager{
    private static JuegoManager instance;
    protected List<Usuario> Usuarios;
    protected HashMap<String, Usuario> lUsuarios = new HashMap<String, Usuario>();
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
        logger.info("new user added");
        return 0;
    }
    @Override
    public Usuario LogIn(VOCredenciales credencialesu) {
        logger.info("login(" + credencialesu +")");
        if (lUsuarios.containsKey(credencialesu.getMail())){
            Usuario U= lUsuarios.get(credencialesu.getMail());
            logger.info("LogIn("+credencialesu.getMail()+")"+U.getUsername());
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
        if (lUsuarios.containsKey(credenciales.getMail())){
            Usuario U= lUsuarios.get(credenciales.getMail());
            logger.info("LogIn("+credenciales+")"+U);
            return U;
        }
        logger.warn(credenciales+"not found");
        return null;
    }
    public List<Usuario> getallusers() {
        return new ArrayList<>(this.lUsuarios.values());
    }
    @Override
    public Usuario deleteUsuario(VOCredenciales credenciales) {
        logger.info("deleteUsuario(" + credenciales +")");
        if (lUsuarios.containsKey(credenciales.getMail())){
            Usuario U= lUsuarios.get(credenciales.getMail());
            lUsuarios.remove(credenciales.getMail());
            logger.info("deleteUsuario("+credenciales+")"+U);
            return U;
        }
        logger.warn(credenciales+"not found");
        return null;
    }
}
