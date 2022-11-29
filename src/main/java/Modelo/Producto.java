package Modelo;

public class Producto {
	private int idProducto, stock;
	private double precio;
	private String nombres, estado;
	
	public Producto(int idProducto, int stock, double precio, String nombres, String estado) {
		this.idProducto = idProducto;
		this.stock = stock;
		this.precio = precio;
		this.nombres = nombres;
		this.estado = estado;
	}
	public Producto() {
	}
	
	public int getId() {
		return idProducto;
	}
	public void setId(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombres;
	}
	public void setNombre(String nombres) {
		this.nombres = nombres;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "idProducto=" + idProducto + ", stock=" + stock + ", precio=" + precio + ", nombres=" + nombres
				+ ", estado=" + estado;
	}
}
