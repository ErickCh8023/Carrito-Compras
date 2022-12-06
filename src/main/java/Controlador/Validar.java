package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession(); //Objeto httpsession
		//Salir</button>
		//href="#"
		if(accion.equalsIgnoreCase("Ingresar")) { //Usuario presiona en el boton ingresar
			String user = request.getParameter("txtuser"); //name de la caja de texto
			String pass = request.getParameter("txtpass"); //name de la caja de texto
			em = edao.validar(user, pass);
			
			if(em.getUser() != null) { //Usuario existe
				
				session.setAttribute("usuario", em);
				//request.setAttribute("usuario", em);
				request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response); //Redirecciona al controlador
				System.out.println("Accion = Principal");
			}else {
				request.getRequestDispatcher("index.jsp").forward(request, response); //Refirege
			}
			
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		if(accion.equalsIgnoreCase("Salir")) {
			try {
				session = request.getSession();
				session.removeAttribute("usuario");
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
				//response.sendRedirect("index.jsp");
			} catch (Exception e) {
				System.out.println("Error en Validar: "+e);
			}
			
			/*if(session.getAttribute("usuario") == null) {
				
			}*/
		}
		
		if(session.getAttribute("usuario")==null) {
			try {
				response.sendRedirect("index.jsp");
			} catch (Exception e) {
				System.out.println("Error en validar: "+e);
			}
			
		}
	}

}
