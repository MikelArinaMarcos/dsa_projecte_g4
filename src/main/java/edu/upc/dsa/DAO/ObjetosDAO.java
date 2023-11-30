package edu.upc.dsa.DAO;

import edu.upc.dsa.models.Objeto;

import edu.upc.dsa.exceptions.ObjectNotExistException;
import edu.upc.dsa.exceptions.NotSufficientMoneyException;
import edu.upc.dsa.exceptions.EmailNotValidException;
import edu.upc.dsa.exceptions.IncorrectCredencialsException;
import edu.upc.dsa.exceptions.NameUserAlreadyInUseException;

import java.sql.SQLException;
import java.util.List;

public interface ObjetosDAO {
    public List<Objeto> getObjetos();
    Objeto getObjeto(String idItem) throws ObjectNotExistException, SQLException;




}
