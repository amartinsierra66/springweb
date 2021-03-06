package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import service.PaisesService;

@Controller
public class PaisesController {
	@Autowired
	PaisesService service;
	@RequestMapping(value="/") //para que se ejecute por get y por post
	public String continentes(HttpServletRequest request) {
		request.setAttribute("continentes", service.continentes());
		return "paises";
	}
	@PostMapping(value="doPaises")
	public String paises(HttpServletRequest request) {
		String continente =request.getParameter("continente");
		request.setAttribute("paises",service.paisesPorContinente(continente));
		request.setAttribute("habitantes", service.poblacionContinente(continente));		
		return "forward:/"; //para que ejecute de nuevo el controller de carga de continentes
	}
}
