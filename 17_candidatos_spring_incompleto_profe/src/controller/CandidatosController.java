package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Candidato;
import service.CandidatosService;

@Controller
public class CandidatosController {
	@Autowired
	CandidatosService service;
	
	@PostMapping(value="alta")
	public String altaCandidato(@ModelAttribute("candidato") Candidato candidato) {
		
		service.altaCandidato(candidato);
		return "menu";
	}
	@GetMapping(value="recuperar")
	public String recuperarCandidatos(HttpServletRequest request) {
		List<Candidato> candidatos=service.recuperarCandidatos();
		
		return "candidatos";
	}
	@GetMapping(value="eliminar")
	public String eliminarCandidato(@RequestParam("idCandidato") int idCandidato, HttpServletRequest request) {
		service.eliminarCandidato(idCandidato);
		//transfiere la petición a otro controller
		return "forward:/recuperar";
	}
	
	@GetMapping(value="buscar")
	public String test(@RequestParam("email") String email,HttpServletRequest request) {
		Candidato candidato=service.buscarCandidato(email);
		request.setAttribute("candidato", candidato);
		return "datos";
	}
}
