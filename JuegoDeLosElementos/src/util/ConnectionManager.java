package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase resuelve el DriverManager y la conexion
 * @author dballestin
 *
 */
public class ConnectionManager {

	private static Connection conexion;
	
	public ConnectionManager() {
	}
	
	public static void conectar() throws ClassNotFoundException, SQLException  {
		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/inetum?serverTimezone=Europe/Madrid", "root", "sasa");
	}
	
	public static Connection getConexion() {
		return conexion;
	}
	
	public static void desconectar() throws SQLException {
		conexion.close();
	}
}
