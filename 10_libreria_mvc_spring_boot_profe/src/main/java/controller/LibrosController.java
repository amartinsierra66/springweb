package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Libro;
import service.LibrosService;

@Controller
public class LibrosController {
	@Autowired
	LibrosService librosService;
	
	@PostMapping(value="doTemas")
	public String temas(HttpServletRequest request) {
		request.setAttribute("temas", librosService.obtenerTemas());
		return "temas";
	}
	//respuesta a una petición AJAX
	@GetMapping(value="doLibros",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Libro> libros(@RequestParam("idTema") int idTema) {
		List<Libro> libros=librosService.recuperarLibros(idTema);
		return libros;
	}
}
