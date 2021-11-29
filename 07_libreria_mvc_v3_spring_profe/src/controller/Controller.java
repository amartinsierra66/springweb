package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option=request.getParameter("option");
		String url="login.html";
		switch(option) {
			case "doRegistrar": //registro de un cliente
				request.getRequestDispatcher("RegistrarAction").include(request, response);
				url="login.html";
				break;
			case "doLogin": //hacer un login 
				request.getRequestDispatcher("LoginAction").include(request, response);
				
				url=(Boolean)request.getAttribute("resultado")?"temas.jsp":"error.html";
				break;
			case "doTemas":  //pulsaci�n del enlace otro tema
				request.getRequestDispatcher("TemasAction").include(request, response);
				url="temas.jsp";
				break;
			case "doLibros": //pulsaci�n del bot�n ver libros
				request.getRequestDispatcher("LibrosAction").forward(request, response);
				return;
			case "doAgregarCarrito":
            	request.getRequestDispatcher("AgregarCarritoAction").forward(request, response);
            	return;
			case "doProcesarCompra":
            	request.getRequestDispatcher("ProcesarCompraAction").include(request, response);
            	//recuperamos de nuevo los temas
        		request.getRequestDispatcher("TemasAction").include(request, response);
                url="temas.jsp";
                break;
            case "doEliminarCarrito":
            	request.getRequestDispatcher("EliminarCarritoAction").forward(request, response);
            	return;
			case "toRegistro":
				url="registro.html";
				break;
			case "toSalir":
				url="login.html";
				break;
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
