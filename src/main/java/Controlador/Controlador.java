package Controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Empleado em = new Empleado();
	EmpleadoDAO edao = new EmpleadoDAO();
	Cliente c = new Cliente();
	ClienteDAO cdao = new ClienteDAO();
	Producto p = new Producto();
	ProductoDAO pdao = new ProductoDAO();
	int ide;
	int idc;
    Venta v = new Venta();
    List<Venta>lista = new ArrayList<>();
    int item, cod, cant;
    String descipcion;
    double precio, subtotal, totalPagar;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menu = request.getParameter("menu");
		String accion = request.getParameter("accion");
		
		
			if(menu.equals("Principal")) {
				request.getRequestDispatcher("Principal.jsp").forward(request, response);
			}
			
			if(menu.equals("Producto")) {
				request.getRequestDispatcher("Producto.jsp").forward(request, response);
			}
			
			if(menu.equals("Empleado")) {
				switch (accion) {
				case "Listar":
					List<Empleado> lista = edao.listar();
					request.setAttribute("listado", lista);
					break;
					
				case "Agregar":
					String dni = request.getParameter("txtDni");
					String nom = request.getParameter("txtNombre");
					String tel = request.getParameter("txtTel");
					String est = request.getParameter("txtEstado");
					String user = request.getParameter("txtUser");
					em.setDni(dni);
					em.setNom(nom);
					em.setTel(tel);
					em.setEstado(est);
					em.setUser(user);
					edao.agregar(em);
					request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
					break;
					
				case "Editar":
					ide = Integer.parseInt(request.getParameter("id"));
					Empleado e = edao.listaId(ide);
					request.setAttribute("empleado", e);
					request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
					break;
					
				case "Actualizar":
					String dni1 = request.getParameter("txtDni");
					String nom1 = request.getParameter("txtNombre");
					String tel1 = request.getParameter("txtTel");
					String est1 = request.getParameter("txtEstado");
					String user1 = request.getParameter("txtUser");
					em.setDni(dni1);
					em.setNom(nom1);
					em.setTel(tel1);
					em.setEstado(est1);
					em.setUser(user1);
					em.setId(ide);
					edao.actualizar(em);
					request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
					break;
				
				case "Delete":
					ide = Integer.parseInt(request.getParameter("id"));
					edao.delete(ide);
					request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
					break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + accion);
				}
				request.getRequestDispatcher("Empleado.jsp").forward(request, response);
			}
			
			if(menu.equals("Cliente")) {
				
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			}
			if (menu.equalsIgnoreCase("NuevaVenta")) {
				switch (accion) {
				case "BuscarCliente":
					String dni = request.getParameter("codigocliente");
					c.setDni(dni);
					c = cdao.buscar(dni);
					request.setAttribute("c", c);
					break;
				case "BuscarProducto":
					int id = Integer.parseInt(request.getParameter("codigoproducto"));
					p = pdao.listarId(id);
					request.setAttribute("producto", p);
					request.setAttribute("lista", lista);
					break;
				case "Agregar":
					totalPagar = 0.0;
					item = item+1;
					cod =p.getId();
					descipcion = request.getParameter("nomproducto");
					precio = Double.parseDouble(request.getParameter("precio"));
					cant = Integer.parseInt(request.getParameter("cantidad"));
					subtotal = precio*cant;
					v = new Venta();
					v.setItem(item);
					v.setId(cod);
					v.setDescripcionP(descipcion);
					v.setPrecio(precio);
					v.setCantidad(cant);
					v.setSubtotal(subtotal);
					lista.add(v);
					
					for(int i = 0; i < lista.size(); i++) {
						totalPagar = totalPagar + lista.get(i).getSubtotal();
					}
					
					request.setAttribute("totalpagar", totalPagar);
					request.setAttribute("lista", lista);
					break;
				default:
					//throw new AssertionError();
				}
	            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
	        }

	    }
		
		
	}
