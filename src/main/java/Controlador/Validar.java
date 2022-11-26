package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;

/**
 * Servlet implementation class Validar
 */
@WebServlet("/Validar")
public class Validar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmpleadoDAO edao = new EmpleadoDAO();
	Empleado em = new Empleado();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion"); //Nombre del boton que realiza la accion
		if(accion.equalsIgnoreCase("Ingresar")) { //Usuario presiona en el boton ingresar
			String user = request.getParameter("txtuser"); //name de la caja de texto
			String pass = request.getParameter("txtpass"); //name de la caja de texto
			em = edao.validar(user, pass);
			
			if(em.getUser() != null) { //Usuario existe
				request.setAttribute("usuario", em);
				request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response); //Redirecciona al controlador
				System.out.println("Accion = Principal");
			}else {
				request.getRequestDispatcher("index.jsp").forward(request, response); //Refirege
			}
			
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
