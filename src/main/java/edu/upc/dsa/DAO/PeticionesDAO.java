package edu.upc.dsa.DAO;

import edu.upc.dsa.models.*;
import edu.upc.dsa.models.Mapas;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.DAO.UsuarioDAOImpl;
import edu.upc.dsa.exceptions.ObjectNotExistException;
import edu.upc.dsa.exceptions.NotSufficientMoneyException;
import edu.upc.dsa.exceptions.EmailNotValidException;
import edu.upc.dsa.exceptions.IncorrectCredencialsException;
import edu.upc.dsa.exceptions.NameUserAlreadyInUseException;
import edu.upc.dsa.models.Usuario;

import java.util.List;
import java.sql.SQLException;
public interface PeticionesDAO {
    public List<Peticiones> getAllPeticiones();
    public int addPeticion(Peticiones peticion);
}
