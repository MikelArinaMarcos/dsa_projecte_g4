package edu.upc.dsa.DAO;

import edu.upc.dsa.DAO.UsuarioDAO;

import edu.upc.dsa.bbdd.FactorySesion;
import edu.upc.dsa.bbdd.Sesion;

import edu.upc.dsa.bbdd.SesionImpl;
import edu.upc.dsa.exceptions.NotInInventoryException;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.*;

import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InsigniasDAOImpl implements InsigniasDAO{

    final static Logger logger = Logger.getLogger(InsigniasDAOImpl.class);
    private static InsigniasDAOImpl instance;

    public List<Insignia> getInsignias(String mail) throws NotInInventoryException {
        Sesion sesion = null;
        HashMap<String, String> criteria = new HashMap<>();
        criteria.put("mail", mail);
        List<Insignia> listaInsignia = new ArrayList<>();

        try {
            sesion = FactorySesion.open();
            List<Object> insigniasInDatabase = sesion.findAll(Insignia.class, criteria);

            if (!insigniasInDatabase.isEmpty()) {
                for (Object object : insigniasInDatabase) {
                    Insignia insignia = (Insignia) object;
                    listaInsignia.add(insignia);
                }
                return listaInsignia;
            } else {
                throw new NotInInventoryException();
            }
        } catch (Exception e) {
            // Manejo de excepciones
        } finally {
            sesion.close();
        }

        return listaInsignia;
    }



}
