package edu.upc.dsa;

import edu.upc.dsa.bbdd.Sesion;
import edu.upc.dsa.DAO.*;
import edu.upc.dsa.models.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class JuegoManagerImpl implements JuegoManager {
    private static JuegoManager instance;
    protected List<Usuario> Usuarios;
    protected HashMap<String, Usuario> lUsuarios = new HashMap<String, Usuario>();
    protected HashMap<String, List<Insignia>> Insignias = new HashMap<String, List<Insignia>>();
    final static Logger logger = Logger.getLogger(JuegoManagerImpl.class);

    public static JuegoManager getInstance() {
        if (instance == null) instance = new JuegoManagerImpl();
        return instance;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public int sizeUsers() {
        int ret = this.lUsuarios.size();
        logger.info("size " + ret);

        return ret;
    }

    public int addUsuario(String username, String mail, String name, String lastName, String password) {
        Usuario u = new Usuario(username, mail, name, lastName, password);
        if (lUsuarios.containsKey(mail)) {
            logger.info("Mail ya en uso");
            return 1;
        }
        for (Map.Entry<String, Usuario> e : lUsuarios.entrySet()) {
            if (e.getValue().getName() == username)
                return 2;
        }
        logger.info("new user " + u.getName());
        this.lUsuarios.put(u.getMail(), u);
        logger.info("new user added");
        return 0;
    }

    public int registrarUsuario(Usuario u) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        int res = usuarioDAO.addUser(u.getUsername(),u.getMail(),u.getName(),u.getLastName(),u.getPassword(),500);
        if (res == 0) {
            logger.info("La base de datos funciona");
            return res;
        }
        if (!isValidEmail(u.getMail())) {
            logger.info("Formato de correo electrónico no válido");
            return 3;
        }

        if (lUsuarios.containsKey(u.getMail())) {
            logger.info("Mail ya en uso");
            return 1;
        }
        for (Map.Entry<String, Usuario> e : lUsuarios.entrySet()) {
            if (e.getValue().getName().equals(u.getUsername()))
                return 2;
        }
        logger.info("new user " + u.getName());
        u.setBolivares(500);
        //u.iniObjetos();
        this.lUsuarios.put(u.getMail(), u);
        logger.info("new user added");
        return 0;
    }

    @Override
    public Usuario login(VOCredenciales credencialesu) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Usuario usuario1 = usuarioDAO.getUserbymail(credencialesu.getMail());
        if (usuario1.getPassword().equals(credencialesu.getPassword())){
            logger.info("Logeado en la base de datos");
            return usuario1;
        } else {
            logger.info("Contraseña incorrecta");
            return null;
        }

        /*logger.info("login(" + credencialesu + ")");

        // Validar el formato del correo electrónico
        if (!isValidEmail(credencialesu.getMail())) {
            logger.info("Formato de correo electrónico no válido");
            return null;
        }

        if (lUsuarios.containsKey(credencialesu.getMail())) {
            Usuario usuario = lUsuarios.get(credencialesu.getMail());

            // Verificar la contraseña
            if (usuario.getPassword().equals(credencialesu.getPassword())) {
                logger.info("Login successful for user: " + usuario.getUsername());
                return usuario;
            } else {
                logger.warn("Incorrect password for user: " + usuario.getUsername());
            }
        } else {
            logger.warn("User with email " + credencialesu.getMail() + " not found");
        }

        return null;*/
    }

    public VOCredenciales getCredenciales(Usuario U) {
        logger.info("getCredenciales(" + U + ")");
        VOCredenciales VOC = new VOCredenciales(U.getUsername(), U.getPassword());
        return VOC;
    }

    public Usuario getUser(String mail) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Usuario user = usuarioDAO.getUserbymail(mail);
        logger.info("getUsername(" + mail + ")");

        if (user==null) {
            logger.info("Ha fallado en encontrar al usuario");
            return null;
        }
        logger.warn("Lo ha encontrado en la base de datos");
        return user;
    }

    public List<Usuario> getallusers() {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        List<Usuario> LU= usuarioDAO.getUsuarios();
        return LU;
        //return new ArrayList<>(this.lUsuarios.values());
    }

    @Override
    public int deleteUsuario(VOCredenciales credenciales) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Usuario u = usuarioDAO.getUserbymail(credenciales.getMail());
        logger.info("deleteUsuario() =" + credenciales.getMail());
        int res = usuarioDAO.deleteUsuario(u,credenciales.getMail());
        return res;
        // Verificar si el usuario existe
        /*if (lUsuarios.containsKey(credenciales.getMail())) {
            Usuario usuario = lUsuarios.get(credenciales.getMail());

            // Verificar la contraseña
            if (usuario.getPassword().equals(credenciales.getPassword())) {
                lUsuarios.remove(credenciales.getMail());
                logger.info("deleteUsuario(" + credenciales + ")" + usuario);
                return 1;
            } else {
                logger.warn("Incorrect password for user: " + usuario.getUsername());
                return 301; // Código para contraseña incorrecta
            }
        } else {
            logger.warn("User with email " + credenciales.getMail() + " not found");
            return 404; // Código para usuario no encontrado
        }*/
    }

    public Usuario actualizarUsuario(String mail, String newUsername, String newName, String newLastName, String newPassword, String newMail) {
        logger.info("actualizarUsuario(" + mail + ")");
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Usuario u1= new Usuario(newUsername, newMail, newName, newLastName, newPassword);
        Usuario uActualizado= usuarioDAO.updateUsuario(u1, mail);
        return uActualizado;
        // Verificar si el usuario existe
        /*if (lUsuarios.containsKey(mail)) {
            Usuario usuario = lUsuarios.get(mail);

            // Verificar que la nueva contraseña sea diferente de la contraseña actual
            if (newPassword != null && !newPassword.isEmpty() && !usuario.getPassword().equals(newPassword)) {
                usuario.setPassword(newPassword);
            }

            // Actualizar la información del usuario
            if (newUsername != null && !newUsername.isEmpty()) {
                usuario.setUsername(newUsername);
            }
            if (newName != null && !newName.isEmpty()) {
                usuario.setName(newName);
            }
            if (newLastName != null && !newLastName.isEmpty()) {
                usuario.setLastName(newLastName);
            }
            if (newMail != null && !newMail.isEmpty()) {
                // Verificar si el nuevo correo es diferente del anterior
                if (!newMail.equals(mail)) {
                    // Verificar si el nuevo correo ya está en uso por otro usuario
                    if (!lUsuarios.containsKey(newMail)) {
                        // Eliminar la entrada antigua y agregar la entrada actualizada con la nueva clave
                        lUsuarios.remove(mail);
                        lUsuarios.put(newMail, usuario);
                        usuario.setMail(newMail);  // Actualizar el correo en el objeto usuario
                    } else {
                        logger.warn("El nuevo correo electrónico ya está en uso");
                        return null; // Retornar null para indicar que el nuevo correo ya está en uso
                    }
                }
            }

            logger.info("Usuario actualizado exitosamente: " + usuario.getUsername());
            return usuario; // Retornar el objeto Usuario actualizado
        } else {
            logger.warn("Usuario con correo electrónico " + mail + " no encontrado");
            return null; // Retornar null para indicar que el usuario no fue encontrado
        }*/
    }

    public ArrayList<Insignia> getInsignias(String username){
        return new ArrayList<>(this.Insignias.get(username));
    }
    public void addInsignias(List<Insignia> i, String username){
        Insignias.put(username, i);
    }

    protected List<Mensaje> MensajesGenerales = new ArrayList<>();
    public List<Mensaje> getMensajesGenerales() {
        return new ArrayList<>(this.MensajesGenerales);
    }
    public void addMensajesGenerales(List<Mensaje> mensajes) {
        this.MensajesGenerales.addAll(mensajes);
    }
    public Mapas getMap(int idMapas){
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Mapas map= usuarioDAO.getMapas(idMapas);
        return map;
    }
    public List<Objeto> getMyBackpack(String mail){
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        ObjetosDAO objetoDAO = new ObjetosDAOImpl();
        List<Backpack> backpack = usuarioDAO.getObjetosBackpack(mail);
        List<Objeto> lObjeto= new ArrayList<>();
        for (Backpack mochila : backpack) {
            // Supongamos que getIdItems devuelve el ID del objeto en la mochila
            int idItem = mochila.getIdItems();

            // Supongamos que getObjeto toma un ID de objeto y devuelve un Objeto
            Objeto objeto = objetoDAO.getObjet(idItem);

            // Verificar si el objeto no es nulo antes de agregarlo a la lista
            if (objeto != null) {
                lObjeto.add(objeto);
            }
        }
        return lObjeto;
    }
}
