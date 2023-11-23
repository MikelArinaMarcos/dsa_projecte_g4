package edu.upc.dsa;

import edu.upc.dsa.models.Personaje;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.VOCredenciales;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class JuegoManagerImpl implements JuegoManager{
    private static JuegoManager instance;

    protected List<Usuario> Usuarios;
    private JuegoManagerImpl() {
        this.Usuarios = new LinkedList<>();
    }
    protected HashMap<VOCredenciales, Usuario> LUsuarios = new HashMap<VOCredenciales, Usuario>();
    protected List<Personaje> Personajes;
    final static Logger logger = Logger.getLogger(JuegoManagerImpl.class);
    public  static JuegoManager getInstance(){
        if (instance==null) instance = new JuegoManagerImpl() {
            @Override
            public Usuario loginJugador(VOCredenciales credenciales) {
                return null;
            }

            @Override
            public Usuario loginUsuario(VOCredenciales credencials) {
                return null;
            }
        };
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

    public Usuario RegistrarUsuario(String mail, String username, String password){
        Usuario U=new Usuario(mail,username,password);
        VOCredenciales VOC=new VOCredenciales(username,password);
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

    //update
    public int size() {
        int ret = this.Usuarios.size();
        logger.info("size " + ret);

        return ret;
    }

    public Usuario addUser(Usuario u) {

        logger.info("El nuevo usuario: " + u + " debe ser añadido");

        for (Usuario a : this.Usuarios) {
            if (a.getMail().equals(u.getMail())){
                logger.warn("Ya existe un usuario con este correo");
                return null;
            }
        }
        this.Usuarios.add(u);
        logger.info("nuevo usuario " + u + " añadido");
        return u;
    }

    public Usuario addUser(String mail, String username, String password) {
        return this.addUser(new Usuario(mail, username, password));
    }

    public Usuario getUser(String id) {

        logger.info("Queremos asociar el usuario con: " + id);

        for (Usuario u: this.Usuarios) {
            if (u.getId().equals(id)) {
                logger.info("El usuario es " + u);
                return u;
            }
        }
        logger.warn("Ningún usuario asociado con: " + id);
        return null;
    }
    public List<Usuario> findAll() {
        return this.Usuarios;
    }

    @Override
    public Usuario deleteUser(String id) {

        Usuario u = this.getUser(id);

        if (u==null) {
            logger.warn("Ningún usuario asociado con: " + id);
        }
        else {
            logger.info(u +" eliminado ");
            this.Usuarios.remove(u);
        }
        return u;
    }

    // Función para cambiar el nombre de usuario
    @Override
    public Usuario updateUser(Usuario u) {

        Usuario t = this.getUser(u.getId());

        if (t!=null) {
            logger.info(u + " ¡Recibido! ");

            t.setUsername(u.getUsername());
            t.setMail(u.getMail());
            t.setPassword(u.getPassword());

            logger.info(t + " Actualizado ");
        }
        else {
            logger.warn("Ningún usuario asociado con: " + u);
        }

        return t;
    }

    @Override
    public Usuario authentification(String mail, String password) {

        for (Usuario c: this.Usuarios) {
            if (c.getMail().equals(mail)) {
                if (c.getPassword().equals(password)) {
                    logger.info("Usuario encontrado");
                    return c;
                } else {
                    logger.warn("Contraseña incorrecta");
                    return null;
                }
            }
        }
        logger.warn("Usuario no encontrado");
        return null;
    }



}
