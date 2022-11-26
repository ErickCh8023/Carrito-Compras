package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Empleado em = new Empleado();
	EmpleadoDAO edao = new EmpleadoDAO(); 
       
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
		String accion = request.getParameter("accion");
		String menu = request.getParameter("menu");
		
		if(menu.equals("Principal")) {
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
		}
		
		if(menu.equals("Producto")) {
			request.getRequestDispatcher("Producto.jsp").forward(request, response);
		}
		
		if(menu.equals("Empleado")) {
			request.getRequestDispatcher("Empleado.jsp").forward(request, response);
			switch (accion) {
			case "Listar":
				List lista = edao.listar();
				request.setAttribute("em", lista);
				break;
				
			case "Agregar":
				break;
				
			case "Editar":
				break;
			
			case "Delete":
				break;
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + accion);
			}
		}
		
		if(menu.equals("Cliente")) {
			request.getRequestDispatcher("Clientes.jsp").forward(request, response);
		}
		
		if(menu.equals("NuevaVenta")) {
			request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
		}
		
	}

}
