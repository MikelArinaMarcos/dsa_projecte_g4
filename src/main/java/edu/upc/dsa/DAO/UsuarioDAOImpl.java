package edu.upc.dsa.DAO;

import edu.upc.dsa.DAO.UsuarioDAO;

import edu.upc.dsa.bbdd.FactorySesion;
import edu.upc.dsa.bbdd.Sesion;

import edu.upc.dsa.bbdd.SesionImpl;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.*;

import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import edu.upc.dsa.exceptions.ObjectNotExistException;
import edu.upc.dsa.exceptions.NotSufficientMoneyException;
import edu.upc.dsa.exceptions.EmailNotValidException;
import edu.upc.dsa.exceptions.IncorrectCredencialsException;
import edu.upc.dsa.exceptions.NameUserAlreadyInUseException;

public class UsuarioDAOImpl implements UsuarioDAO {

    final static Logger logger = Logger.getLogger(UsuarioDAOImpl.class);
    private static UsuarioDAOImpl instance;

    public static UsuarioDAOImpl getInstance() {
        if (instance == null) instance = new UsuarioDAOImpl();
        return instance;
    }

    public int addUser(String username, String mail, String name, String lastName, String password, int bolivares) {
        Sesion sesion = null;

        try {
            sesion = FactorySesion.open();
            Usuario user = new Usuario(username, mail, name, lastName, password, bolivares);
            sesion.save(user);
        } catch (Exception e) {
            // LOG
        } finally {
            sesion.close();
        }
        logger.info("usuario registrado");
        return 0;
    }


    public Usuario getUserbymail(String mail) {
        Sesion sesion = null;
        Usuario user = null;
        try {
            sesion = FactorySesion.open();
            user = (Usuario) sesion.get(Usuario.class, "mail", mail);
        } catch (Exception e) {
            logger.error("Error al obtener usuario por mail");
            return null;
            // LOG
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }

        return user;
    }
    public Mapas getMapas(int idMapa) {
        Sesion sesion = null;
        Mapas map= null;
        try {
            sesion = FactorySesion.open();
            map = (Mapas) sesion.get(Mapas.class, "idMapa", idMapa);
        } catch (Exception e) {
            e.printStackTrace();
            // LOG
        } finally {
            sesion.close();
        }

        return map;
    }

    public List<Backpack> getObjetosBackpack(String mail) {
        Sesion sesion = null;
        List<Backpack> backpack = null;
        try {
            sesion = FactorySesion.open();
            backpack = sesion.findAllbyId(Backpack.class,"idUsuario",mail);
        } catch (Exception e) {
            // LOG
        } finally {
            sesion.close();
        }
        return backpack;
    }
    public List<Insignia> getInsignia(String username) {
        Sesion sesion = null;
        List<Insignia> listaInsignia = null;
        /*try {
            sesion = FactorySesion.open();
            HashMap<String, String> criteria = new HashMap<>();
            criteria.put("username", username);
            listaInsignia = sesion.findAll(Insignia.class, criteria);
        }*/
        try {
            sesion = FactorySesion.open();
            listaInsignia = sesion.findAllbyId(Insignia.class,"username",username);
        } catch (Exception e) {
            // LOG
        } finally {
            sesion.close();
        }

        return listaInsignia;
    }
    public List<Usuario> getUsuarios() {

        Sesion sesion = null;
        List<Usuario> listaUsuarios = null;
        try {
            sesion = FactorySesion.open();
            listaUsuarios = sesion.findAll(Usuario.class);
        } catch (Exception e) {

        } finally {
            sesion.close();
        }
        return listaUsuarios;
    }

    public Usuario updateUsuario(Usuario u1,String mail){
        Sesion sesion = null;
        try {
            sesion = FactorySesion.open();
            sesion.update(u1, "mail", mail);
        } catch (Exception e) {

        } finally {
            sesion.close();
        }
        return u1;
    }

    public int deleteUsuario(Usuario u1,String mail){
        Sesion sesion = null;
        try {
            sesion = FactorySesion.open();
            int res = sesion.delete(u1,"mail",mail);
        } catch (Exception e) {
            return 1;
        } finally {
            sesion.close();
        }
        return 0;
    }
    /*public void buyItem(String id, String name, String mail) throws NotSufficientMoneyException, ObjectNotExistException,  SQLException {

        logger.info("Comprar objeto "+ id + " Para el usuario con mail " + mail);
        Sesion sesion = null;
        ObjetosDAO objetosDAO = new ObjetosDAOImpl();
        Objeto objeto = objetosDAO.getObjeto(id);
        Usuario user = getUserbymail(mail);
        logger.info(objeto.getPrecio());
        try {
            sesion = FactorySesion.open();
            user.adquirirObjeto(objeto);
            logger.info("Objeto adquirido");
            sesion.update(user, objeto.getId());

            sesion.save(objeto);
            logger.info("Adquisicion guardada, objeto: " + objeto.getNombre());

        } catch (NotSufficientMoneyException e) {
            logger.warn("No tienes suficiente dinero exception");
            throw new NotSufficientMoneyException();
        } catch(SQLException e){
            logger.warn("Objeto ya adquirido");
        throw new SQLException();
        }
        finally {

            sesion.close();
        }
}}*/
}
