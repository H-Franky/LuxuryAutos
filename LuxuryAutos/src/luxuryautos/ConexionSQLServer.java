/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luxuryautos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author gonza
 */
public class ConexionSQLServer {
    private static final String URL = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3711625";
    private static final String USER = "sql3711625";
    private static final String PASSWORD = "5EsucEMDCr";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


