package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;

public class ProductoDAO {
	
	Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Producto buscar(int id){
        Producto p = new Producto();
        String sql = "select * from producto where IdProducto="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error metodo buscar ProductoDAO : "+e.getMessage());
        }
        return p;
    }
    
    public int actualizarStock(int id,int stock){
        String sql="update producto set Stock=? where IdProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en metodo actualizarStock en ProductoDAO : "+e.getMessage());
        }
        return r;
    }
    
    public Producto validar(String nom) {
        Producto prod = new Producto();
        String sql = "select * FROM producto WHERE Nombres=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();
            while (rs.next()) {
                prod.setId(rs.getInt("IdProducto"));
                prod.setNombre(rs.getString("Nombres"));
                prod.setPrecio(Double.parseDouble(rs.getString("Precio")));
                prod.setStock(rs.getInt("Stock"));
                prod.setEstado(rs.getString("Estado"));
            }
        } catch (Exception e) {
            System.out.println("Error en Validar en la clase ProductoDAO : " + e.getMessage());
        }
        return prod;
    }
    
    public List listar() {
        String sql = "SELECT * FROM producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setId(rs.getInt(1));
                prod.setNombre(rs.getString(2));
                prod.setPrecio(Double.parseDouble(rs.getString(3)));
                prod.setStock(rs.getInt(4));
                prod.setEstado(rs.getString(5));
                lista.add(prod);
            }
        } catch (Exception e) {
            System.out.println("Error metodo listar en clase ProductoDAO : " + e.getMessage());
        }
        return lista;
    }

    public int agregar(Producto prod) {
    	 String sql = "insert into producto(Nombres, Precio, Stock, Estado)values(?,?,?,?)";
         try {
             con = cn.Conexion();
             ps = con.prepareStatement(sql);
             ps.setString(1, prod.getNombre());
             ps.setDouble(2, prod.getPrecio());
             ps.setInt(3, prod.getStock());
             ps.setString(4, prod.getEstado());
             ps.executeUpdate();
         } catch (SQLException e) {
             System.out.println("Error en metodo agregar de la clase ProductoDAO : " + e.getMessage());
         }
         return r;
    }

    public Producto listarId(int id) {
        Producto prod = new Producto();
        String sql = "select * from producto WHERE IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                prod.setNombre(rs.getString(2));
                prod.setPrecio(rs.getDouble(3));
                prod.setStock(rs.getInt(4));
                prod.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo listarId en la clase ProductoDAO : " + e.getMessage());
        }
        return prod;
    }

    public int actualizar(Producto prod) {
        String sql = "UPDATE producto set Nombres=?, Precio=?, Stock=?, Estado=? WHERE IdProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getNombre());
            ps.setDouble(2, prod.getPrecio());
            ps.setInt(3, prod.getStock());
            ps.setString(4, prod.getEstado());
            ps.setInt(5, prod.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en metodo actualizar de la clase ProductoDAO : " + e.getMessage());
        }
        return r;
    }

    public void delete(int id) {
        String sql = "DELETE FROM producto WHERE IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en metodo delete de la clase ProductoDAO : " + e.getMessage());
        }
    }

}
