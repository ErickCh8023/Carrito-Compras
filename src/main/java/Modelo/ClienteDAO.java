package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;

public class ClienteDAO {
	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int r;
	
	public Cliente buscar(String dni) {
		Cliente c = new Cliente();
		String sql= "Select * from cliente where Dni="+dni;
		try {
			con=cn.Conexion();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				c.setId(rs.getInt(1));
				c.setDni(rs.getString(2));
				c.setNombres(rs.getString(3));
				c.setDireccion(rs.getString(4));
				c.setEstado(rs.getString(5));
			}
		} catch (Exception e) {
			System.out.println("Error al buscar cliente "+e.getMessage());
		}
		return c;
	}	
	public List listar() {
		String sql = "select * from cliente";
		List<Cliente>lista = new ArrayList<>();
		try {
			con = cn.Conexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Cliente cli = new Cliente();
				cli.setId(rs.getInt(1));
				cli.setDni(rs.getString(2));
				cli.setNombres(rs.getString(3));
				cli.setDireccion(rs.getString(4)); 
				cli.setEstado(rs.getString(5));
				lista.add(cli);
			}
			
		} catch (Exception e) {
			System.out.println("Error al listar cliente "+e.getMessage());
		}
		return lista;
	}
	
	public int agregar(Cliente emp) {
		String sql = "insert into cliente (Dni, Nombres, Direccion, Estado) values (?,?,?,?)";
		try {
			con = cn.Conexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, emp.getDni());
			ps.setString(2, emp.getNombres());
			ps.setString(3, emp.getDireccion());
			ps.setString(4, emp.getEstado());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al registrar cliente "+e.getMessage());
		}
		return r;
	}
	
	public Cliente listaId(int id) {
		Cliente emp = new Cliente();
		String sql = "select * from cliente where IdCliente="+id;
		try {
			con = cn.Conexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				emp.setDni(rs.getString(2));
				emp.setNombres(rs.getString(3));
				emp.setDireccion(rs.getString(4));
				emp.setEstado(rs.getString(5));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return emp;
	}
	
	public int actualizar(Cliente emp) {
		String sql = "update cliente set Dni=?, Nombres=?, Direccion=?, Estado=? where IdCliente=?";
		try {
			con = cn.Conexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, emp.getDni());
			ps.setString(2, emp.getNombres());
			ps.setString(3, emp.getDireccion());
			ps.setString(4, emp.getEstado());
			ps.setInt(5, emp.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return r;
	}
	
	public void delete(int id) {
		String sql = "delete from cliente where IdCliente="+id;
		try {
			con = cn.Conexion();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
