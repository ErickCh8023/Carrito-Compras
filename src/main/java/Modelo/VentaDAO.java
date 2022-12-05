package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentaDAO {
	int r;
	Connection con;
	Conexion cn = new Conexion();
	PreparedStatement ps;
	ResultSet rs;
	
	public String GenerarSerie() {
		String numserie="";
		String sql="select max(NumeroSerie) from ventas";
		try {
			con=cn.Conexion();	
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				numserie=rs.getString(1);
			}
		}catch(Exception e) {
			System.out.println("Error al generar numero de serie "+e.getMessage());
		}
		return numserie;
	}
	public String IdVentas(){
		String idVentas="";
		String sql="select max(IdVentas) from ventas";
		try {
			con=cn.Conexion();	
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				idVentas=rs.getString(1);
			}
		}catch(Exception e) {
			System.out.println("Error al generar venta "+e.getMessage());
		}
		return idVentas;
	}
	public int GuardarVenta(Venta v) {
		String sql="insert into ventas(IdCliente, IdEmpleado, NumeroSerie, FechaVentas, Monto, Estado)values(?,?,?,?,?,?)";
		try {
			con=cn.Conexion();	
			ps=con.prepareStatement(sql);
			ps.setInt(1, v.getIdCliente());
			ps.setInt(2, v.getIdEmpleado());
			ps.setString(3, v.getNumSerie());
			ps.setString(4, v.getFecha());
			ps.setDouble(5, v.getPrecio());
			ps.setString(6, v.getEstado());
			ps.executeUpdate();			
		}catch(Exception e) {
			System.out.println("Error al guardar venta "+e.getMessage());
		}
		return r;
	}
	public int GuardarD_Ventas(Venta vn) {
		String sql = "insert into detalle_ventas(IdVentas, IdProducto, Cantidad, PrecioVenta)values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, vn.getId());
            ps.setInt(2, vn.getIdProducto());
            ps.setInt(3, vn.getCantidad());
            ps.setDouble(4, vn.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en metodo guardarDetalleventas clase VentaDAO : " + e.getMessage());
        }
        return r;
	}
}
