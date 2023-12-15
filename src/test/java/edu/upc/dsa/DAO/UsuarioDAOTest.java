package edu.upc.dsa.DAO;

import org.junit.Test;

public class UsuarioDAOTest {


    @Test
    public void getUserTest(){
        UsuarioDAO userDAO = new UsuarioDAOImpl();
        userDAO.getUserbymail("jordi@gmial.com");
    }
    @Test
    public void addUsuarioTest() {
        UsuarioDAO userDAO = new UsuarioDAOImpl();
        userDAO.addUser("a2", "a2@gmail.com", "a2", "a2", "123", 3);
    }
}
