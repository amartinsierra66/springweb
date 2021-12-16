package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Cliente;
import model.Libro;
import service.LibrosService;
import service.VentasService;

@Controller
public class CompraController {
	@Autowired
	LibrosService librosService;
	
	@Autowired
	VentasService ventasService;
	@GetMapping(value="doAgregarCarrito",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Libro> agregar(@SessionAttribute("carrito") List<Libro> carrito, 
							   @RequestParam("isbn") int isbn){
		carrito.add(librosService.recuperarLibroPorIsbn(isbn));
		return carrito;
	}
	@GetMapping(value="doEliminarCarrito",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Libro> eliminar(@SessionAttribute("carrito") List<Libro> carrito, 
			   @RequestParam("pos") int pos){
		if(carrito.size()>0) {	
			carrito.remove(pos);
		}
		return carrito;
	}
	@GetMapping(value="doProcesarCompra")
	public String procesar(@SessionAttribute("carrito") List<Libro> carrito,
			@SessionAttribute("cliente") Cliente cliente) {
		ventasService.nuevaVenta(cliente, carrito);
		carrito.clear();
		return "login";
	}
}
