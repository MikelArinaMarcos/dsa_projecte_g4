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

public class MensajeDAOImpl implements MensajeDAO{
    final static Logger logger = Logger.getLogger(MensajeDAOImpl.class);
    private static MensajeDAOImpl instance;

    public static MensajeDAOImpl getInstance() {
        if (instance == null) instance = new MensajeDAOImpl();
        return instance;
    }

    public List<Mensaje> getMensaje(){
        Sesion sesion = null;
        List<Mensaje> listaMensaje = null;
        try {
            sesion = FactorySesion.open();
            listaMensaje = sesion.findAll(Mensaje.class);
        } catch (Exception e) {

        } finally {
            sesion.close();
        }
        return listaMensaje;
    }




}
