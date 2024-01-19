package edu.upc.dsa;

import edu.upc.dsa.bbdd.Sesion;
import edu.upc.dsa.DAO.*;
import edu.upc.dsa.models.*;
import edu.upc.dsa.models.Peticiones;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PeticionesManagerImpl implements PeticionesManager {
    private static PeticionesManager instance;
    protected List<Peticiones> LPeticiones = new ArrayList<>();
    final static Logger logger = Logger.getLogger(PeticionesManagerImpl.class);

    public static PeticionesManager getInstance() {
        if (instance == null) instance = new PeticionesManagerImpl();
        return instance;
    }

    public int addPeticiones(String date, String title, String message, String sender) {
        Peticiones p = new Peticiones(date, title, message, sender);
        logger.info("new petición ");
        this.LPeticiones.add(p);
        logger.info("new petición added");
        return 0;
    }
    public int addPeticiones(Peticiones p) {
        logger.info("new petición ");
        PeticionesDAO peticionesDAO = new PeticionesDAOImpl();
        int res= peticionesDAO.addPeticion(p);
        logger.info("new petición added");
        return res;
        //this.LPeticiones.add(p);
    }
    public List<Peticiones> getAllPeticiones() {
        PeticionesDAO peticionesDAO = new PeticionesDAOImpl();
        List<Peticiones> LP= peticionesDAO.getAllPeticiones();
        return LP;
        //return new ArrayList<>(this.LPeticiones);
    }

    public int sizeP() {
        int ret = this.LPeticiones.size();
        logger.info("size " + ret);

        return ret;
    }
}
