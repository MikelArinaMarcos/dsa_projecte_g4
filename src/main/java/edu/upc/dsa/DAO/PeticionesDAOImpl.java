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
public class PeticionesDAOImpl implements PeticionesDAO{
    final static Logger logger = Logger.getLogger(PeticionesDAOImpl.class);
    private static PeticionesDAOImpl instance;

    public static PeticionesDAOImpl getInstance() {
        if (instance == null) instance = new PeticionesDAOImpl();
        return instance;
    }
    public List<Peticiones> getAllPeticiones(){
        Sesion sesion = null;
        List<Peticiones> listaPeticiones = null;
        try {
            sesion = FactorySesion.open();
            listaPeticiones = sesion.findAll(Peticiones.class);
        } catch (Exception e) {

        } finally {
            sesion.close();
        }
        return listaPeticiones;
    }

    public int addPeticion(Peticiones peticion) {
        Sesion sesion = null;

        try {
            sesion = FactorySesion.open();
            sesion.save(peticion);
        } catch (Exception e) {
            return 1;
        } finally {
            sesion.close();
        }
        logger.info("petición registrada");
        return 0;
    }
}
