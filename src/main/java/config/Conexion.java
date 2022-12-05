package config;

import java.sql.*;

public class Conexion {
	Connection con;
	String url = "jdbc:mysql://localhost:3306/bd_ventas";
	String user = "root";
	String pass = "";
	
	public Connection Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexión Exitosa");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return con;
	}
	
}
