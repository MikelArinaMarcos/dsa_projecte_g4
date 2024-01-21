package edu.upc.dsa.DAO;

import edu.upc.dsa.models.Backpack;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.DAO.BackpackDAOImpl;
import edu.upc.dsa.exceptions.ObjectNotExistException;
import edu.upc.dsa.exceptions.NotSufficientMoneyException;
import edu.upc.dsa.exceptions.EmailNotValidException;
import edu.upc.dsa.exceptions.IncorrectCredencialsException;
import edu.upc.dsa.exceptions.NameUserAlreadyInUseException;
import edu.upc.dsa.models.Usuario;

import java.util.List;
import java.sql.SQLException;

public interface BackpackDAO {
    int addItem(String idUsuario, int idItems);
    public int deleteBackpack(Backpack bk,String mail);
}
