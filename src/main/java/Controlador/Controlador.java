package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		System.out.println(accion);
		switch (accion) {
		case "Principal": 
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
			System.out.println("Entro a Principal.jsp");
			break;
		case "Producto":
			request.getRequestDispatcher("Producto.jsp").forward(request, response);
			System.out.println("Entro a Producto.jsp");
			break;
		case "Cliente":
			request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			System.out.println("Entro a Cliente.jsp");
			break;
		case "NuevaVenta":
			request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
			System.out.println("Entro a NuevaVenta.jsp");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + accion);
		}
	}

}
