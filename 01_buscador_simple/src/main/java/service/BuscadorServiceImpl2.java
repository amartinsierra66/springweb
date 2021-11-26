package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import model.Pagina;

@Service(value = "instancia2")
public class BuscadorServiceImpl2 implements BuscadorService {
	
	@Override
	public List<Pagina> buscar(String clave) {
		
		//se realiza la búsqueda de las páginas en una base de datos
		return List.of(new Pagina());
	}

}
