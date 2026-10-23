package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
        "jdbc:mysql://localhost:3306/reservatic_db"
        + "?useSSL=false&serverTimezone=America/Bogota&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Pon aquí tu contraseña de MySQL

    private ConexionBD() {
    }

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}