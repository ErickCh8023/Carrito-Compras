package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.Conexion;

public class EmpleadoDAO {
	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public Empleado validar(String user, String dni) {
		Empleado em = new Empleado();
		String sql = "select * from empleado where User=? and Dni=?"; //Consulta en la base de datos
		
		try {
			con = cn.Conexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, dni);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				em.setId(rs.getInt("IdEmpleado"));
				em.setUser(rs.getString("User"));
				em.setDni(rs.getString("Dni"));
				em.setNom(rs.getString("Nombres"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return em;
	}
}
