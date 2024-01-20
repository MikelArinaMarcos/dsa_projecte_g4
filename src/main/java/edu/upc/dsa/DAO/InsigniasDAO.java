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

public interface InsigniasDAO {


    public List<Insignia>  getInsignias (String mail) throws NotInInventoryException;
}
