package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import model.Contacto;
import service.ContactosService;

/**
 * Servlet implementation class RecuperarContactos
 */
@WebServlet("/RecuperarAction")
public class RecuperarAction extends HttpServlet {
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
		
		List<Contacto> contactos=service.recuperarContactos();
		if(contactos!=null&&contactos.size()>0) {
			//guardamos los contactos en un atributo de petición para que los pueda
			//recuperar la página jsp
			request.setAttribute("contactos", contactos);
			//atributo de petición para informar a Front Controller
			request.setAttribute("resultado", true);
			//request.getRequestDispatcher("contactos.jsp").forward(request, response);
		}else {
			//request.getRequestDispatcher("sincontactos.html").forward(request, response);
			//atributo de petición para informar a Front Controller
			request.setAttribute("resultado", false);
		}
	}

}
