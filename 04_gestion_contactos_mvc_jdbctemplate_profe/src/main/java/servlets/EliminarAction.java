package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import service.ContactosService;

/**
 * Servlet implementation class EliminarContacto
 */
@WebServlet("/EliminarAction")
public class EliminarAction extends HttpServlet {
	@Autowired
	ContactosService service;
	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyección
		//de objetos en este servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idContacto=Integer.parseInt(request.getParameter("idContacto"));
		
		service.eliminarContacto(idContacto);
		//volvemos a llamar al servlet que recupera los contactos de la base de datos
		//y transfiere el control a la página JSP que los muestra
		//request.getRequestDispatcher("RecuperarContactos").forward(request, response);
	}

}
