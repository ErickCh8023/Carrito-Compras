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
import Modelo.VentaDAO;
import config.GenerarSerie;

/**
 * Servlet implementation class Controlador
 */
//fredy se la come XDDD
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Empleado em = new Empleado();
	EmpleadoDAO edao = new EmpleadoDAO();
	
	Cliente c = new Cliente();
	ClienteDAO cdao = new ClienteDAO();
	
	Producto p = new Producto();
	ProductoDAO pdao = new ProductoDAO();
	
	int ide, idc, idp;
    Venta v = new Venta();
    List<Venta>lista = new ArrayList<>();
    int item, cod, cant;
    String descripcion;
    double precio, subtotal, totalPagar;
    String numserie;
	VentaDAO vdao = new VentaDAO();
    
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
			//PRODUCTO
			if(menu.equals("Producto")) {
				switch (accion) {
				case "Listar":
					List<Producto> lista = pdao.listar();
					request.setAttribute("listado", lista);
					break;
					
				case "Agregar":
					String nom = request.getParameter("txtNombre");
					String pre = request.getParameter("txtPrecio");
					String stock = request.getParameter("txtStock");
					String est = request.getParameter("txtEstado");
					p.setNombre(nom);
					p.setPrecio(Double.parseDouble(pre));
					p.setStock(Integer.parseInt(stock));
					p.setEstado(est);
					pdao.agregar(p);
					request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
					break;
					
				case "Editar":
					idp = Integer.parseInt(request.getParameter("id"));
                    Producto ca = pdao.listarId(idp);
                    request.setAttribute("pro", ca);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
				case "Actualizar":
					String nom1 = request.getParameter("txtNombre");
					String pre1 = request.getParameter("txtPrecio");
					String stock1 = request.getParameter("txtStock");
					String est1 = request.getParameter("txtEstado");
					p.setNombre(nom1);
					p.setPrecio(Double.parseDouble(pre1));
					p.setStock(Integer.parseInt(stock1));
					p.setEstado(est1);
					p.setId(idp);
					pdao.actualizar(p);
					request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
					break;
				
				case "Delete":
					idp = Integer.parseInt(request.getParameter("id"));
					pdao.delete(idp);
					request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
					break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + accion);
				}
				request.getRequestDispatcher("Producto.jsp").forward(request, response);
			}
			//EMPLEADO
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
		// Cliente
			if(menu.equals("Cliente")) {
				switch (accion) {
				case "Listar":
					List<Cliente> lista = cdao.listar();
					request.setAttribute("listado", lista);
					break;
					
				case "Agregar":
					String dni = request.getParameter("txtDni");
					String nom = request.getParameter("txtNombre");
					String dir = request.getParameter("txtDir");
					String est = request.getParameter("txtEstado");
					c.setDni(dni);
					c.setNombres(nom);
					c.setDireccion(dir);
					c.setEstado(est);
					cdao.agregar(c);
					request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
					break;
					
				case "Editar":
					idc = Integer.parseInt(request.getParameter("id"));
                    Cliente ca = cdao.listaId(idc);
                    request.setAttribute("cli", ca);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
				case "Actualizar":
					String dni1 = request.getParameter("txtDni");
					String nom1 = request.getParameter("txtNombre");
					String dir1 = request.getParameter("txtDir");
					String est1 = request.getParameter("txtEstado");
					c.setDni(dni1);
					c.setNombres(nom1);
					c.setDireccion(dir1);
					c.setEstado(est1);
					c.setId(idc);
					cdao.actualizar(c);
					request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
					break;
				
				case "Delete":
					idc = Integer.parseInt(request.getParameter("id"));
					cdao.delete(idc);
					request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
					break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + accion);
				}
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			}
			if (menu.equalsIgnoreCase("NuevaVenta")) {
				switch (accion) {
				case "BuscarCliente":
					String dni = request.getParameter("codigocliente");
					c.setDni(dni);
					c = cdao.buscar(dni);
					request.setAttribute("c", c);
					request.setAttribute("nserie", numserie);
					break;
				case "BuscarProducto":
					int id = Integer.parseInt(request.getParameter("codigoproducto"));
					p = pdao.listarId(id);
					request.setAttribute("c", c);
					request.setAttribute("producto", p);
					request.setAttribute("lista", lista);
					request.setAttribute("totalpagar", totalPagar);
					request.setAttribute("nserie", numserie);
					break;
				case "Agregar":
					request.setAttribute("c", c);
					request.setAttribute("nserie", numserie);
					totalPagar = 0.0;
					item = item+1;
					cod =p.getId();
					descripcion = request.getParameter("nomproducto");
					precio = Double.parseDouble(request.getParameter("precio"));
					cant = Integer.parseInt(request.getParameter("cantidad"));
					subtotal = precio*cant;
					v = new Venta();
					v.setItem(item);
					v.setIdProducto(cod);
					v.setDescripcionP(descripcion);
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
				case "GenerarVenta":
					//Actualizar Stock
					for(int i=0;i<lista.size();i++) {
						Producto pd=new Producto();
						int cantd=lista.get(i).getCantidad();
						int idproducto=lista.get(i).getIdProducto();
						ProductoDAO aO=new ProductoDAO();
						pd=aO.buscar(idproducto);
						int stack=pd.getStock()-cantd;
						aO.actualizarStock(idproducto, stack);
					}
					//Generar venta
					v.setIdCliente(c.getId());
					v.setIdEmpleado(1);
					v.setNumSerie(numserie);
					v.setFecha("2022-12-04");
					v.setMonto(totalPagar);
					v.setEstado("1");
					vdao.GuardarVenta(v);
					//generar detalleventa
					int idv=Integer.parseInt(vdao.IdVentas());
					for(int i=0;i<lista.size();i++) {
						v = new Venta();
						v.setId(idv);
						v.setIdProducto(lista.get(i).getIdProducto());
						v.setCantidad(lista.get(i).getCantidad());
						v.setPrecio(lista.get(i).getPrecio());
						vdao.GuardarD_Ventas(v);
					}
					break;
				default:
					v = new Venta();
				    lista = new ArrayList<>();
				    item=0;
				    totalPagar=0.0;
				    
					numserie = vdao.GenerarSerie();
					if(numserie==null) {
						numserie="00000001";
						request.setAttribute("nserie", numserie);
					}else{
						int incrementar = Integer.parseInt(numserie);
						GenerarSerie gs = new GenerarSerie();
						numserie = gs.NumeroSerie(incrementar);
						request.setAttribute("nserie", numserie);
					}
					request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
				}
	            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
	        }

	    }
		
		
	}
