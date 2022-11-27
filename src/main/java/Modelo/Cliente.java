package Modelo;

public class Cliente {
	private int id;
	private String dni, nombres, direccion, estado;
	
	public Cliente(int id, String dni, String nombres, String direccion, String estado) {
		this.id = id;
		this.dni = dni;
		this.nombres = nombres;
		this.direccion = direccion;
		this.estado = estado;
	}
	public Cliente() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", dni=" + dni + ", nombres=" + nombres + ", direccion=" + direccion + ", estado="
			+ estado + "]";
	}
}
