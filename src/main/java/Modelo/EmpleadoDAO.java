package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;

public class EmpleadoDAO {
	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int r;
	
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
			System.out.println(e);
		}
		
		return em;
	}
	
	//Operaciones CRUD
	public List listar() {
		String sql = "select * from empleado";
		List<Empleado>lista = new ArrayList<>();
		try {
			con = cn.Conexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Empleado emp = new Empleado();
				emp.setId(rs.getInt(1));
				emp.setDni(rs.getString(2));
				emp.setNom(rs.getString(3));
				emp.setTel(rs.getString(4));
				emp.setEstado(rs.getString(5));
				emp.setUser(rs.getString(6));
				lista.add(emp);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getId());
		}
		return lista;
	}
	
	public int agregar(Empleado emp) {
		String sql = "insert into empleado (Dni, Nombres, Telefono, Estado, User) values (?,?,?,?,?)";
		try {
			con = cn.Conexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, emp.getDni());
			ps.setString(2, emp.getNom());
			ps.setString(3, emp.getTel());
			ps.setString(4, emp.getEstado());
			ps.setString(5, emp.getUser());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return r;
	}
	
	public Empleado listaId(int id) {
		Empleado emp = new Empleado();
		String sql = "select * from empleado where IdEmpleado="+id;
		try {
			con = cn.Conexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				emp.setDni(rs.getString(2));
				emp.setNom(rs.getString(3));
				emp.setTel(rs.getString(4));
				emp.setEstado(rs.getString(5));
				emp.setUser(rs.getString(6));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return emp;
	}
	
	public int actualizar(Empleado emp) {
		String sql = "update empleado set Dni=?, Nombres=?, Telefono=?, Estado=?, User=? where IdEmpleado=?";
		try {
			con = cn.Conexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, emp.getDni());
			ps.setString(2, emp.getNom());
			ps.setString(3, emp.getTel());
			ps.setString(4, emp.getEstado());
			ps.setString(5, emp.getUser());
			ps.setInt(6, emp.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return r;
	}
	
	public void delete(int id) {
		String sql = "delete from empleado where IdEmpleado="+id;
		try {
			con = cn.Conexion();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
