package edu.upc.dsa.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FactorySesion {

    public static Sesion open() {

        Connection conn = getConnection();

        Sesion sesion = new SesionImpl(conn);

        return sesion;
    }

    private static Connection getConnection() {
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mariadb://localhost:3306/juego?user=root&password=grupo4");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection con = getConnection();
        Statement st = null;

        try {
            st = con.createStatement();
            st.execute("INSERT INTO items (name) VALUES ('Bryan')");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }




    }


}
