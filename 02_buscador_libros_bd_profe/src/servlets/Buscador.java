package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import model.Libro;
import service.LibrosService;

/**
 * Servlet implementation class Buscador
 */
@WebServlet("/Buscador")
public class Buscador extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyección
		//de objetos en este servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
	@Autowired
	@Qualifier(value="instanciaBd")
	LibrosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String textoBusqueda=request.getParameter("texto");
		String opcion=request.getParameter("opcion");
		
		RequestDispatcher dispatcher;
		if(opcion.equals("tema")){
			List<Libro> libros=service.librosPorTematica(textoBusqueda);
			if(libros!=null&&libros.size()>0) {
				//guardamos los libros en un atributo de petición para que los vea la JSP
				request.setAttribute("libros",libros );
				dispatcher=request.getRequestDispatcher("libros.jsp");
			}else {
				dispatcher=request.getRequestDispatcher("sinresultados.jsp");
			}
		}else {
			Libro libro=service.libroPorIsbn(Integer.parseInt(textoBusqueda));
			if(libro!=null) {
				//guardamos el libro encontrado en un atributo de petición para que lo vea la JSP
				request.setAttribute("libro",libro );
				dispatcher=request.getRequestDispatcher("libro.jsp");
			}else {
				dispatcher=request.getRequestDispatcher("error.jsp");
			}
		}
		dispatcher.forward(request, response);
	}

}
