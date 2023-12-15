package edu.upc.dsa.DAO;

import edu.upc.dsa.DAO.UsuarioDAO;

import edu.upc.dsa.bbdd.FactorySesion;
import edu.upc.dsa.bbdd.Sesion;

import edu.upc.dsa.bbdd.SesionImpl;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;

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
        return 1;
    }


    public Usuario getUserbymail(String mail) {
        Sesion sesion = null;
        Usuario user = null;
        try {
            sesion = FactorySesion.open();
            user = (Usuario) sesion.get(Usuario.class, "mail", mail);
        } catch (Exception e) {
            e.printStackTrace();
            // LOG
        } finally {
            sesion.close();
        }

        return user;
    }

    public List<Objeto> getObjetos() {
        Sesion sesion = null;
        List<Objeto> objetos = null;
        try {
            sesion = FactorySesion.open();
            objetos = sesion.findAll(Objeto.class);
        } catch (Exception e) {
            // LOG
        } finally {
            sesion.close();
        }
        return objetos;
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
