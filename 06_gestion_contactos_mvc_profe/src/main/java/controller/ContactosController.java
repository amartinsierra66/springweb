package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Contacto;
import service.ContactosService;

@Controller
public class ContactosController {
	@Autowired
	ContactosService service;
	
	@PostMapping(value="doAlta")
	public String alta(HttpServletRequest request) {
		Contacto contacto=new Contacto(0, 
				request.getParameter("nombre"), 
				request.getParameter("email"), 
				Integer.parseInt(request.getParameter("edad")));
		
		service.altaContacto(contacto);
		return "inicio";
	}
	@GetMapping(value="doEliminar")
	public String eliminar(@RequestParam("idContacto") int id) {		
		service.eliminarContacto(id);
		return "forward:/doRecuperar";
	}
	@GetMapping(value="doRecuperar")
	public String recuperar(HttpServletRequest request) {
		List<Contacto> contactos=service.recuperarContactos();
		if(contactos!=null&&contactos.size()>0) {
			//guardamos los contactos en un atributo de petición para que los pueda
			//recuperar la página jsp
			request.setAttribute("contactos", contactos);
			//atributo de petición para informar a Front Controller
			request.setAttribute("resultado", true);
			return "contactos";
		}else {
			//request.getRequestDispatcher("sincontactos.html").forward(request, response);
			//atributo de petición para informar a Front Controller
			request.setAttribute("resultado", false);
			return "sincontactos";
		}
	}
}
