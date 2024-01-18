package edu.upc.dsa.DAO;

import edu.upc.dsa.bbdd.FactorySesion;
import edu.upc.dsa.bbdd.Sesion;

import edu.upc.dsa.models.Backpack;

import edu.upc.dsa.models.Usuario;
import org.apache.log4j.Logger;

public class BackpackDAOImpl implements BackpackDAO{
    final static Logger logger = Logger.getLogger(BackpackDAOImpl.class);
    private static BackpackDAOImpl instance;

    public static BackpackDAOImpl getInstance() {
        if (instance == null) instance = new BackpackDAOImpl();
        return instance;
    }

    public int addItem(String idUsuario, int idItems) {
        Sesion sesion = null;
        String newIdObjetos = null;
        try {
            sesion = FactorySesion.open();
            Backpack backpack = new Backpack(idUsuario,idItems);
            sesion.save(backpack);
        } catch (Exception e) {
            return 1;
        } finally {
            sesion.close();
        }
        logger.info("item añadido");
        return 0;
    }
}
