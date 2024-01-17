package edu.upc.dsa.DAO;

import edu.upc.dsa.DAO.UsuarioDAO;

import edu.upc.dsa.bbdd.FactorySesion;
import edu.upc.dsa.bbdd.Sesion;

import edu.upc.dsa.bbdd.SesionImpl;
import edu.upc.dsa.models.Backpack;
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
public class BackpackDAOImpl {
    final static Logger logger = Logger.getLogger(BackpackDAOImpl.class);
    private static BackpackDAOImpl instance;

    public static BackpackDAOImpl getInstance() {
        if (instance == null) instance = new BackpackDAOImpl();
        return instance;
    }

    public int addItem(String idUsuario, String idItem) {
        Sesion sesion = null;
        Backpack backpack = null;
        String newIdObjetos = null;
        try {
            sesion = FactorySesion.open();
            backpack = (Backpack) sesion.get(Backpack.class, "idUsuario", idUsuario);
            newIdObjetos=backpack.getIdObjetos()+"/"+idItem;
            backpack.setIdObjetos(newIdObjetos);
            sesion.save(backpack);
        } catch (Exception e) {
            // LOG
        } finally {
            sesion.close();
        }
        logger.info("item añadido");
        return 0;
    }
}
