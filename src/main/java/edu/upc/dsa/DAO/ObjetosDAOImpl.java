package edu.upc.dsa.DAO;

import org.apache.log4j.Logger;

import edu.upc.dsa.bbdd.FactorySesion;
import edu.upc.dsa.bbdd.Sesion;
import edu.upc.dsa.exceptions.ObjectNotExistException;
import edu.upc.dsa.models.Objeto;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import edu.upc.dsa.exceptions.ObjectNotExistException;
import edu.upc.dsa.exceptions.NotSufficientMoneyException;
import edu.upc.dsa.exceptions.EmailNotValidException;
import edu.upc.dsa.exceptions.IncorrectCredencialsException;
import edu.upc.dsa.exceptions.NameUserAlreadyInUseException;


public class ObjetosDAOImpl implements ObjetosDAO {


    final static Logger logger = Logger.getLogger(ObjetosDAOImpl.class);



    public Objeto getObjeto(String id) throws ObjectNotExistException {
        Sesion sesion = null;
        Objeto objeto = null;
        try {
            sesion = FactorySesion.open();
            objeto = (Objeto) sesion.get(Objeto.class,"id", id);
        } finally {
            //sesion.save(item);
            sesion.close();
        }

        return objeto;
    }

    public List<Objeto> getObjetos() {
        Sesion sesion = null;
        List<Objeto> objetos =null;
        try {
            sesion = FactorySesion.open();
            objetos = sesion.findAll(Objeto.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            sesion.close();
        }
        return objetos;
    }

    public static void main(String[] args) {
        ObjetosDAO dao = new ObjetosDAOImpl();

        try {
           List<Objeto> list = dao.getObjetos();

            for(Objeto o : list) {
                System.out.println(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
