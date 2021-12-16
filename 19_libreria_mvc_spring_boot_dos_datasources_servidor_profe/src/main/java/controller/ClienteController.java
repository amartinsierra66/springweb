package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import model.Cliente;
import service.ClientesService;
import service.LibrosService;

@Controller
public class ClienteController {
	@Autowired
	ClientesService clientesService;
	@Autowired
	LibrosService librosService;
	
	@PostMapping(value="doLogin")
	public String login(HttpServletRequest request, HttpSession sesion) {
		Cliente cliente=clientesService.validarCliente(request.getParameter("user"),request.getParameter("pwd"));
		if(cliente!=null) {
			request.setAttribute("temas", librosService.obtenerTemas());
			sesion.setAttribute("cliente", cliente);
			return "temas";
		}else {
			return "error";
		}
	}
	@PostMapping(value="doRegistrar")
	public String registrar(@ModelAttribute("cliente") Cliente cliente) {
		if(clientesService.registrarCliente(cliente)) {
			return "login";
		}else {
			return "error";
		}
		
	}
}
