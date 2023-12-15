package edu.upc.dsa.DAO;

import edu.upc.dsa.models.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class UsuarioDAOTest {


    @Test
    public void getUserTest(){
        UsuarioDAO userDAO = new UsuarioDAOImpl();
        Usuario user = userDAO.getUserbymail("jordi@gmail.com");
        Assert.assertEquals("Jordi", user.getUsername());
    }
    @Test
    public void addUsuarioTest() {
        UsuarioDAO userDAO = new UsuarioDAOImpl();
        userDAO.addUser("a2", "a2@gmail.com", "a2", "a2", "123", 3);
    }
}
